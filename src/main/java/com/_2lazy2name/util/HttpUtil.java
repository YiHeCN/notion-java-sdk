package com._2lazy2name.util;

import com._2lazy2name.notion.exception.NotionException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.HttpEntities;
import org.apache.hc.core5.http.message.BasicClassicHttpRequest;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.hc.core5.util.TimeValue;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedTrustManager;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpUtil {
    private final Map<String, String> defaultHeaders = new HashMap<>();
    private static final CloseableHttpClient httpClient;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger log = Logger.getLogger(HttpUtil.class.getName());

    static {
        httpClient = createHttpClient();
    }

    public void addDefaultHeaders(Map<String, String> headers) {
        defaultHeaders.putAll(headers);
    }

    public void addDefaultHeader(String key, String value) {
        defaultHeaders.put(key, value);
    }

    public void removeDefaultHeader(String key) {
        defaultHeaders.remove(key);
    }

    public void clearDefaultHeaders() {
        defaultHeaders.clear();
    }

    public Response get(String url) throws IOException {
        return execute(Method.GET, url, null, null, null);
    }

    public Response get(String url, Map<String, String> params) throws IOException{
        return execute(Method.GET, url, params, null, null);
    }

    public Response post(String url) throws IOException {
        return execute(Method.POST, url, null, null, null);
    }

    public Response post(String url, String body) throws IOException {
        return execute(Method.POST, url, null, body, null);
    }

    public Response post(String url, Map<String, String> params, String body) throws IOException {
        return execute(Method.POST, url, params, body, null);
    }

    public Response patch(String url, String body) throws IOException {
        return execute(Method.PATCH, url, null, body, null);
    }

    public Response patch(String url, Map<String, String> params, String body) throws IOException {
        return execute(Method.PATCH, url, params, body, null);
    }

    public Response patch(String url, Map<String, String> params) throws IOException {
        return execute(Method.PATCH, url, params, null, null);
    }

    public Response delete(String url) throws IOException {
        return execute(Method.DELETE, url, null, null, null);
    }

    private Response execute(Method method,
                                    String url,
                                    Map<String, String> urlParams,
                                    Object body,
                                    ContentType bodyType
    ) throws IOException {
        BasicClassicHttpRequest request;
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if (urlParams != null) {
                urlParams.forEach(uriBuilder::addParameter);
            }
            request = new BasicClassicHttpRequest(method.name(), uriBuilder.build());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }

        defaultHeaders.forEach(request::addHeader);

        if (body != null) {
            if (body instanceof String) {
                if (bodyType == null) {
                    bodyType = ContentType.APPLICATION_JSON;
                }
                request.setEntity(HttpEntities.create((String) body, bodyType));
            }
            if (body instanceof File) {
                if (bodyType == null) {
                    bodyType = ContentType.APPLICATION_OCTET_STREAM;
                }
                request.setEntity(HttpEntities.create((File) body, bodyType));
            }
        }
        log.log(Level.FINE, """
                {0}: {1}
                ============================
                {2}
                ============================
                
                
                """, new Object[]{method.name(), url, body == null ? "null" : body.toString()});
        ClassicHttpResponse res = httpClient.execute(request);
        Response response = new Response(res.getCode(), new String(res.getEntity().getContent().readAllBytes()));
        checkAndWrapHttpError(response);
        res.getEntity().getContent().close();
        res.getEntity().close();
        res.close();
        return response;
    }

    private static CloseableHttpClient createHttpClient() {
        return HttpClientBuilder.create()
                .setConnectionManager(PoolingHttpClientConnectionManagerBuilder.create()
                        .setSSLSocketFactory(createSSLFactory())
                        .setValidateAfterInactivity(TimeValue.ofSeconds(20))
                        .setMaxConnPerRoute(200 - 1)
                        .setMaxConnTotal(200)
                        .build())
                .evictIdleConnections(TimeValue.ofMinutes(1))
                .disableAutomaticRetries()
                .build();
    }

    private static void checkAndWrapHttpError(Response response) throws NotionException {
        if (!(response.getStatusCode() >= 400)) {
            return;
        }

        String message = response.getBody();

        try {
            throw objectMapper.readValue(message, NotionException.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static SSLConnectionSocketFactory createSSLFactory()  {
        X509ExtendedTrustManager manager = new X509ExtendedTrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }

            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType, Socket socket) {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType, Socket socket) {

            }

            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType, SSLEngine engine) {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType, SSLEngine engine) {

            }
        };
        SSLContext context;
        try {
            context = SSLContext.getInstance("TLS");
            context.init(null, new X509ExtendedTrustManager[]{manager}, null);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException(e);
        }
        return new SSLConnectionSocketFactory(context, NoopHostnameVerifier.INSTANCE);
    }

    public static class Response {
        private int statusCode;
        private String body;

        public Response(int statusCode, String body) {
            this.statusCode = statusCode;
            this.body = body;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "statusCode=" + statusCode +
                    ", body='" + body + '\'' +
                    '}';
        }
    }

}