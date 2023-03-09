package com._2lazy2name.notion.enumeration.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserTypeEnum {
    PERSON("person"),
    BOT("bot");

    final String type;

    @JsonCreator
    UserTypeEnum (String type) {
        this.type = type;
    }

    @Override
    @JsonValue
    public String toString() {
        return type;
    }
}
