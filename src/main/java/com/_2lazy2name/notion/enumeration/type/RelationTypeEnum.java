package com._2lazy2name.notion.enumeration.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RelationTypeEnum {
    SINGLE_PROPERTY("single_property"),
    DUAL_PROPERTY("dual_property");

    private final String type;

    @JsonCreator
    RelationTypeEnum(String type) {
        this.type = type;
    }

    @JsonValue
    public String toString() {
        return type;
    }
}
