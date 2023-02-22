package com._2lazy2name.notion.entity.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ObjectEnum {
    DATABASE("database"),
    USER("user"),
    PAGE("page"),
    BLOCK("block"),
    COMMENTS("comments"),
    LIST("list"),
    PROPERTY_ITEM("property_item");

    final String type;

    @JsonCreator
    ObjectEnum(String type) {
        this.type = type;
    }

    @Override
    @JsonValue
    public String toString() {
        return type;
    }
}
