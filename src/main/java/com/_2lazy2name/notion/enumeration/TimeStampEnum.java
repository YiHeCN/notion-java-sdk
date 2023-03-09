package com._2lazy2name.notion.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TimeStampEnum {
    CREATED_TIME("created_time"),
    LAST_EDITED_TIME("last_edited_time");

    final String value;

    @JsonCreator
    TimeStampEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return value;
    }
}
