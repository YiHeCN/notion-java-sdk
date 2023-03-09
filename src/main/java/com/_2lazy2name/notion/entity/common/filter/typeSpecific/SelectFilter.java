package com._2lazy2name.notion.entity.common.filter.typeSpecific;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.common.filter.PropertyFilter;

public class SelectFilter extends PropertyFilter {
    private final PropertyTypeEnum type = PropertyTypeEnum.SELECT;
    private SelectFilterMethodEnum method;

    public SelectFilter(String property, SelectFilterMethodEnum method, Object value) {
        this.property = property;
        this.method = method;
        this.value = value;
    }

    public SelectFilter on(String property) {
        this.property = property;
        return this;
    }

    public SelectFilter equals(String value) {
        this.method = SelectFilterMethodEnum.EQUALS;
        this.value = value;
        return this;
    }

    public SelectFilter doesNotEqual(String value) {
        this.method = SelectFilterMethodEnum.DOES_NOT_EQUAL;
        this.value = value;
        return this;
    }

    public SelectFilter isEmpty() {
        this.method = SelectFilterMethodEnum.IS_EMPTY;
        this.value = null;
        return this;
    }

    public SelectFilter isNotEmpty() {
        this.method = SelectFilterMethodEnum.IS_NOT_EMPTY;
        this.value = null;
        return this;
    }

    public enum SelectFilterMethodEnum implements IFilterMethod {
        EQUALS("equals", STRING),
        DOES_NOT_EQUAL("does_not_equal", STRING),
        IS_EMPTY("is_empty", BOOLEAN_ONLY_TRUE),
        IS_NOT_EMPTY("is_not_empty", BOOLEAN_ONLY_TRUE);

        private final String method;
        private final int valueType;

        SelectFilterMethodEnum(String method, int valueType) {
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

    public SelectFilter() {
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    @Override
    public SelectFilterMethodEnum getMethod() {
        return method;
    }

    public SelectFilter setMethod(SelectFilterMethodEnum method) {
        this.method = method;
        return this;
    }
}
