package com._2lazy2name.notion.enumeration;

import com._2lazy2name.notion.entity.common.filter.typeSpecific.IFilterMethod;


public enum DateFilterMethodEnum implements IFilterMethod {
    EQUALS("equals", DATE),
    BEFORE("before", DATE),
    AFTER("after", DATE),
    ON_OR_BEFORE("on_or_before", DATE),
    ON_OR_AFTER("on_or_after", DATE),
    IS_EMPTY("is_empty", BOOLEAN_ONLY_TRUE),
    IS_NOT_EMPTY("is_not_empty", BOOLEAN_ONLY_TRUE),
    PAST_WEEK("past_week", EMPTY_OBJECT),
    PAST_MONTH("past_month", EMPTY_OBJECT),
    PAST_YEAR("past_year", EMPTY_OBJECT),
    THIS_WEEK("this_week", EMPTY_OBJECT),
    NEXT_WEEK("next_week", EMPTY_OBJECT),
    NEXT_MONTH("next_month", EMPTY_OBJECT),
    NEXT_YEAR("next_year", EMPTY_OBJECT);

    private final String method;
    private final int valueType;

    DateFilterMethodEnum(String method, int valueType) {
        this.method = method;
        this.valueType = valueType;
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public int getValueType() {
        return valueType;
    }
}
