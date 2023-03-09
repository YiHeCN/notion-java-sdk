package com._2lazy2name.notion.entity.common.filter.typeSpecific;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.common.filter.PropertyFilter;


public class MultiselectFilter extends PropertyFilter {
    private final PropertyTypeEnum type = PropertyTypeEnum.SELECT;
    private MultiselectFilterMethodEnum method;

    public MultiselectFilter(String property, MultiselectFilterMethodEnum method, Object value) {
        this.property = property;
        this.method = method;
        this.value = value;
    }

    public MultiselectFilter on(String property) {
        this.property = property;
        return this;
    }

    public MultiselectFilter contains(String value) {
        this.method = MultiselectFilterMethodEnum.CONTAINS;
        this.value = value;
        return this;
    }

    public MultiselectFilter doesNotContain(String value) {
        this.method = MultiselectFilterMethodEnum.DOES_NOT_CONTAIN;
        this.value = value;
        return this;
    }

    public MultiselectFilter isEmpty() {
        this.method = MultiselectFilterMethodEnum.IS_EMPTY;
        this.value = null;
        return this;
    }

    public MultiselectFilter isNotEmpty() {
        this.method = MultiselectFilterMethodEnum.IS_NOT_EMPTY;
        this.value = null;
        return this;
    }

    public enum MultiselectFilterMethodEnum implements IFilterMethod {
        CONTAINS("contains", STRING),
        DOES_NOT_CONTAIN("does_not_contain", STRING),
        IS_EMPTY("is_empty", BOOLEAN_ONLY_TRUE),
        IS_NOT_EMPTY("is_not_empty", BOOLEAN_ONLY_TRUE);

        private final String method;
        private final int valueType;

        MultiselectFilterMethodEnum(String method, int valueType) {
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
    public MultiselectFilterMethodEnum getMethod() {
        return method;
    }

    public MultiselectFilter setMethod(MultiselectFilterMethodEnum method) {
        this.method = method;
        return this;
    }

    public MultiselectFilter() {
    }
}
