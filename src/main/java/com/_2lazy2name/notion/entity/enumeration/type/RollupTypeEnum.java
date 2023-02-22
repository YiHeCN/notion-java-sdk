package com._2lazy2name.notion.entity.enumeration.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RollupTypeEnum {
    ARRAY("array"),
    DATE("date"),
    NUMBER("number"),
    INCOMPLETE("incomplete"),
    UNSUPPORTED("unsupported");

    final String type;

    @JsonCreator
    RollupTypeEnum(String type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public String toString() {
        return type;
    }
}
