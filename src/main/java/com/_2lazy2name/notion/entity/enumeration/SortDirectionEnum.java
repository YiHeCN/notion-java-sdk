package com._2lazy2name.notion.entity.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SortDirectionEnum {
    ASCENDING("ascending"),
    DESCENDING("descending");

    final String direction;

    @JsonCreator
    SortDirectionEnum(String direction) {
        this.direction = direction;
    }

    @Override
    @JsonValue
    public String toString() {
        return direction;
    }


}
