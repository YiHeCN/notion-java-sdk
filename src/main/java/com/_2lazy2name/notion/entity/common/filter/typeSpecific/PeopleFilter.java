package com._2lazy2name.notion.entity.common.filter.typeSpecific;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.common.filter.PropertyFilter;

public class PeopleFilter extends PropertyFilter {
    private PeopleFilterMethodEnum method;

    public PeopleFilter(PropertyTypeEnum type, String property, PeopleFilterMethodEnum method, String value) {
        checkIfSupported(type);
        this.type = type;
        this.property = property;
        this.method = method;
        this.value = value;
    }

    public static void checkIfSupported(PropertyTypeEnum type) {
        if (type != PropertyTypeEnum.PEOPLE && type != PropertyTypeEnum.CREATED_BY && type != PropertyTypeEnum.LAST_EDITED_BY) {
            throw new IllegalArgumentException("TextFilter is not supported for type " + type + ". SEE: https://developers.notion.com/reference/post-database-query-filter#people-filter-condition");
        }
    }

    public PeopleFilter on(PropertyTypeEnum propertyType, String property) {
        checkIfSupported(propertyType);
        this.type = propertyType;
        this.property = property;
        return this;
    }

    public PeopleFilter asField(PropertyTypeEnum propertyTypeEnum) {
        checkIfSupported(propertyTypeEnum);
        this.type = propertyTypeEnum;
        this.property = null;
        return this;
    }

    public PeopleFilter contains(String value) {
        this.method = PeopleFilterMethodEnum.CONTAINS;
        this.value = value;
        return this;
    }

    public PeopleFilter doesNotContain(String value) {
        this.method = PeopleFilterMethodEnum.DOES_NOT_CONTAIN;
        this.value = value;
        return this;
    }

    public PeopleFilter isEmpty() {
        this.method = PeopleFilterMethodEnum.IS_EMPTY;
        this.value = null;
        return this;
    }

    public PeopleFilter isNotEmpty() {
        this.method = PeopleFilterMethodEnum.IS_NOT_EMPTY;
        this.value = null;
        return this;
    }

    public enum PeopleFilterMethodEnum implements IFilterMethod {
        CONTAINS("contains", STRING),
        DOES_NOT_CONTAIN("does_not_contain", STRING),
        IS_EMPTY("is_empty", BOOLEAN_ONLY_TRUE),
        IS_NOT_EMPTY("is_not_empty", BOOLEAN_ONLY_TRUE);

        private final String method;
        private final int valueType;

        PeopleFilterMethodEnum(String method, int valueType) {
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

    public PeopleFilter() {
    }

    @Override
    public PeopleFilterMethodEnum getMethod() {
        return method;
    }

    public PeopleFilter setMethod(PeopleFilterMethodEnum method) {
        this.method = method;
        return this;
    }
}
