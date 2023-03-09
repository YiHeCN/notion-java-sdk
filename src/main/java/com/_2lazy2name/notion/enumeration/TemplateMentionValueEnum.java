package com._2lazy2name.notion.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TemplateMentionValueEnum {
    TODAY("template_mention_date"),
    NOW("template_mention_user"),
    ME("me");

    final String type;

    @JsonCreator
    TemplateMentionValueEnum(String type) {
        this.type = type;
    }

    @Override
    @JsonValue
    public String toString() {
        return type;
    }

}
