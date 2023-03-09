package com._2lazy2name.notion.enumeration.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TextTypeEnum {
    TEXT("text"),
    MENTION("mention"),
    EQUATION("equation");

    final String type;

    @JsonCreator
    TextTypeEnum(String type) {
        this.type = type;
    }

    @Override
    @JsonValue
    public String toString() {
        return type;
    }


}
