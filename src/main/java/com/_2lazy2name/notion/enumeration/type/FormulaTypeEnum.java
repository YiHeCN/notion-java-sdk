package com._2lazy2name.notion.enumeration.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FormulaTypeEnum {
    STRING("string"),
    NUMBER("number"),
    BOOLEAN("boolean"),
    DATE("date");

    final String type;

    @JsonCreator
    FormulaTypeEnum(String type) {
        this.type = type;
    }

    @Override
    @JsonValue
    public String toString() {
        return type;
    }
}
