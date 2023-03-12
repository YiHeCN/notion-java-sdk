package com._2lazy2name.notion.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotionException extends RuntimeException {
    private final String object = "error";
    private int status;
    private String code;
    @JsonProperty("message")
    protected String message;


    public NotionException() {
    }

    public int getStatus() {
        return status;
    }

    public NotionException setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getCode() {
        return code;
    }

    public NotionException setCode(String code) {
        this.code = code;
        return this;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String getMessage() {
        return """
                
                NotionException:
                Code %d: %s
                =================================
                %s
                """.formatted(status, code, message);
    }

    public NotionException setMessage(String message) {
        this.message = message;
        return this;
    }

}
