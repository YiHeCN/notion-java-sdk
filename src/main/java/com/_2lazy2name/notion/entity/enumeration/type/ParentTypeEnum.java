package com._2lazy2name.notion.entity.enumeration.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ParentTypeEnum {
    DATABASE_ID("database_id"),
    PAGE_ID("page_id"),
    WORKSPACE("workspace"),
    BLOCK_ID("block_id");

    final String type;

    @JsonCreator
    ParentTypeEnum(String type) {
        this.type = type;
    }

    @Override
    @JsonValue
    public String toString() {
        return type;
    }
}
