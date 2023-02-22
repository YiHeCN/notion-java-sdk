package com._2lazy2name.notion.entity.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RollupFunctionEnum {
    AVERAGE("average"),
    CHECKED("checked"),
    COUNT("count"),
    COUNT_PER_GROUP("count_per_group"),
    COUNT_VALUES("count_values"),
    DATE_RANGE("date_range"),
    EARLIEST_DATE("earliest_date"),
    EMPTY("empty"),
    LATEST_DATE("latest_date"),
    MAX("max"),
    MEDIAN("median"),
    MIN("min"),
    NOT_EMPTY("not_empty"),
    PERCENT_CHECKED("percent_checked"),
    PERCENT_EMPTY("percent_empty"),
    PERCENT_NOT_EMPTY("percent_not_empty"),
    PERCENT_PER_GROUP("percent_per_group"),
    PERCENT_UNCHECKED("percent_unchecked"),
    RANGE("range"),
    SHOW_ORIGINAL("show_original"),
    SHOW_UNIQUE("show_unique"),
    SUM("sum"),
    UNCHECKED("unchecked"),
    UNIQUE("unique");

    final String function;

    @JsonCreator
    RollupFunctionEnum(String function) {
        this.function = function;
    }

    @JsonValue
    @Override
    public String toString() {
        return function;
    }
}
