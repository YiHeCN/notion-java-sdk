package com._2lazy2name.notion.enumeration.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FileTypeEnum {
    EXTERNAL("external"),
    FILE("file");

    final String type;

    @JsonCreator
    FileTypeEnum(String type) {
        this.type = type;
    }

    @Override
    @JsonValue
    public String toString() {
        return type;
    }


}
