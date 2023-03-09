package com._2lazy2name.notion.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TemplateMentionEnum {
    DATE("template_mention_date"),
    USER("template_mention_user");

    final String type;


    @JsonCreator
    TemplateMentionEnum(String type) {
        this.type = type;
    }

    @Override
    @JsonValue
    public String toString() {
        return type;
    }
}
