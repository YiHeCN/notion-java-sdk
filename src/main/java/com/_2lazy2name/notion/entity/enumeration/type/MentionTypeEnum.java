package com._2lazy2name.notion.entity.enumeration.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MentionTypeEnum {
    DATABASE("database"),
    DATE("date"),
    LINK_PREVIEW("link_preview"),
    PAGE("page"),
    TEMPLATE_MENTION("template_mention"),
    USER("user");


    final String type;

    @JsonCreator
    MentionTypeEnum(String type) {
        this.type = type;
    }

    @Override
    @JsonValue
    public String toString() {
        return type;
    }


}
