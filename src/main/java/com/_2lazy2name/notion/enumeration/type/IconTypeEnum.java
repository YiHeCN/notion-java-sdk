package com._2lazy2name.notion.enumeration.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum IconTypeEnum {
    EMOJI("emoji"),
    EXTERNAL("external");

    private final String type;

    @JsonCreator
    IconTypeEnum(String type) {
        this.type = type;
    }

    @Override
    @JsonValue
    public String toString() {
        return type;
    }
}
