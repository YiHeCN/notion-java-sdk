package com._2lazy2name.notion.entity.common.filter.typeSpecific;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.common.filter.PropertyFilter;

public class StatusFilter extends PropertyFilter {
    private final PropertyTypeEnum type = PropertyTypeEnum.SELECT;
    private StatusFilterMethodEnum method;

    public StatusFilter(String property, StatusFilterMethodEnum method, Object value) {
        this.property = property;
        this.method = method;
        this.value = value;
    }

    public StatusFilter on(String property) {
        this.property = property;
        return this;
    }

    public StatusFilter equals(String value) {
        this.method = StatusFilterMethodEnum.EQUALS;
        this.value = value;
        return this;
    }

    public StatusFilter doesNotEqual(String value) {
        this.method = StatusFilterMethodEnum.DOES_NOT_EQUAL;
        this.value = value;
        return this;
    }

    public StatusFilter isEmpty() {
        this.method = StatusFilterMethodEnum.IS_EMPTY;
        this.value = null;
        return this;
    }

    public StatusFilter isNotEmpty() {
        this.method = StatusFilterMethodEnum.IS_NOT_EMPTY;
        this.value = null;
        return this;
    }

    public enum StatusFilterMethodEnum implements IFilterMethod {
        EQUALS("equals", STRING),
        DOES_NOT_EQUAL("does_not_equal", STRING),
        IS_EMPTY("is_empty", BOOLEAN_ONLY_TRUE),
        IS_NOT_EMPTY("is_not_empty", BOOLEAN_ONLY_TRUE);

        private final String method;
        private final int valueType;

        StatusFilterMethodEnum(String method, int valueType) {
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

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    @Override
    public StatusFilterMethodEnum getMethod() {
        return method;
    }

    public StatusFilter setMethod(StatusFilterMethodEnum method) {
        this.method = method;
        return this;
    }

    public StatusFilter() {
    }
}
