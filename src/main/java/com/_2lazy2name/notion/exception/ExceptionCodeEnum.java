package com._2lazy2name.notion.exception;

public enum ExceptionCodeEnum {
    INVALID_JSON("invalid_json", 400),
    INVALID_REQUEST_URL("invalid_request_url", 400),
    INVALID_REQUEST("invalid_request", 400),
    VALIDATION_ERROR("validation_error", 400),
    MISSING_VERSION("missing_version", 400),
    UNAUTHORIZED("unauthorized", 401),
    RESTRICTED_RESOURCE("restricted_resource", 403),
    OBJECT_NOT_FOUND("object_not_found", 404),
    CONFLICT_ERROR("conflict_error", 409),
    RATE_LIMITED("rate_limited", 429),
    INTERNAL_SERVER_ERROR("internal_server_error", 500),
    SERVICE_UNAVAILABLE("service_unavailable", 503),
    DATABASE_CONNECTION_UNAVAILABLE("database_connection_unavailable", 503),
    GATEWAY_TIMEOUT("gateway_timeout", 504);

    private final String code;
    private final int statusCode;

    ExceptionCodeEnum(String code, int statusCode) {
        this.code = code;
        this.statusCode = statusCode;
    }

    public String getCode() {
        return code;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public static ExceptionCodeEnum getByCode(String code) {
        for (ExceptionCodeEnum exceptionCodeEnum : values()) {
            if (exceptionCodeEnum.getCode().equals(code)) {
                return exceptionCodeEnum;
            }
        }
        return null;
    }

    public static ExceptionCodeEnum getByStatusCode(int statusCode) {
        for (ExceptionCodeEnum exceptionCodeEnum : values()) {
            if (exceptionCodeEnum.getStatusCode() == statusCode) {
                return exceptionCodeEnum;
            }
        }
        return null;
    }

}
