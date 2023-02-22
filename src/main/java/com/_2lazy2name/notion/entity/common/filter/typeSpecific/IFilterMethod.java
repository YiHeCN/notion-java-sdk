package com._2lazy2name.notion.entity.common.filter.typeSpecific;

public interface IFilterMethod {
    int EMPTY_OBJECT = 1;
    int FILTER_OBJECT = 2;
    int BOOLEAN = 3;
    int BOOLEAN_ONLY_TRUE = 4;
    int STRING = 5;
    int NUMBER = 6;
    int DATE = 7;

    String getMethod();
    int getValueType();
}
