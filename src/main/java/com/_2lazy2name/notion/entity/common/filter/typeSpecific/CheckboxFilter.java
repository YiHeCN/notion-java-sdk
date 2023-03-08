package com._2lazy2name.notion.entity.common.filter.typeSpecific;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.common.filter.PropertyFilter;

public class CheckboxFilter extends PropertyFilter {
    private final PropertyTypeEnum type = PropertyTypeEnum.CHECKBOX;
    private CheckboxFilterMethodEnum method;

    public CheckboxFilter(String property, CheckboxFilterMethodEnum method, Object value) {
        this.property = property;
        this.method = method;
        this.value = value;
    }

    public CheckboxFilter on(String propertyName) {
        this.property = propertyName;
        return this;
    }

    public CheckboxFilter equals(Boolean value) {
        this.method = CheckboxFilterMethodEnum.EQUALS;
        this.value = value;
        return this;
    }

    public CheckboxFilter doesNotEqual(Boolean value) {
        this.method = CheckboxFilterMethodEnum.DOES_NOT_EQUAL;
        this.value = value;
        return this;
    }

    public enum CheckboxFilterMethodEnum implements IFilterMethod {
        EQUALS("equals", BOOLEAN),
        DOES_NOT_EQUAL("does_not_equal", BOOLEAN);

        private final String method;
        private final int valueType;

        CheckboxFilterMethodEnum(String method, int valueType) {
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
    public CheckboxFilterMethodEnum getMethod() {
        return method;
    }

    public CheckboxFilter setMethod(CheckboxFilterMethodEnum method) {
        this.method = method;
        return this;
    }

    public CheckboxFilter() {
    }
}
