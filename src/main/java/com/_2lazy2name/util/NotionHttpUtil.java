package com._2lazy2name.util;

import com._2lazy2name.notion.exception.NotionException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NotionHttpUtil extends HttpUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void checkAndWrapHttpError(Response response) {
        {
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
    }
}
