package com._2lazy2name.notion.entity.common.filter.typeSpecific;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.common.filter.PropertyFilter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class NumberFilter extends PropertyFilter {
    private final PropertyTypeEnum type = PropertyTypeEnum.NUMBER;
    private NumberFilterMethodEnum method;


    public NumberFilter(String property, NumberFilterMethodEnum method, Object value) {
        this.property = property;
        this.method = method;
        this.value = value;
    }

    public NumberFilter on(String property) {
        this.property = property;
        return this;
    }

    public NumberFilter equals(Float value) {
        this.method = NumberFilterMethodEnum.EQUALS;
        this.value = value;
        return this;
    }

    public NumberFilter doesNotEqual(Float value) {
        this.method = NumberFilterMethodEnum.DOES_NOT_EQUAL;
        this.value = value;
        return this;
    }

    public NumberFilter greaterThan(Float value) {
        this.method = NumberFilterMethodEnum.GREATER_THAN;
        this.value = value;
        return this;
    }

    public NumberFilter lessThan(Float value) {
        this.method = NumberFilterMethodEnum.LESS_THAN;
        this.value = value;
        return this;
    }

    public NumberFilter greaterThanOrEqualTo(Float value) {
        this.method = NumberFilterMethodEnum.GREATER_THAN_OR_EQUAL_TO;
        this.value = value;
        return this;
    }

    public NumberFilter lessThanOrEqualTo(Float value) {
        this.method = NumberFilterMethodEnum.LESS_THAN_OR_EQUAL_TO;
        this.value = value;
        return this;
    }

    public NumberFilter isEmpty() {
        this.method = NumberFilterMethodEnum.IS_EMPTY;
        this.value = null;
        return this;
    }

    public NumberFilter isNotEmpty() {
        this.method = NumberFilterMethodEnum.IS_NOT_EMPTY;
        this.value = null;
        return this;
    }

    @Getter
    public enum NumberFilterMethodEnum implements IFilterMethod {
        EQUALS("equals", NUMBER),
        DOES_NOT_EQUAL("does_not_equal", NUMBER),
        GREATER_THAN("greater_than", NUMBER),
        LESS_THAN("less_than", NUMBER),
        GREATER_THAN_OR_EQUAL_TO("greater_than_or_equal_to", NUMBER),
        LESS_THAN_OR_EQUAL_TO("less_than_or_equal_to", NUMBER),
        IS_EMPTY("is_empty", BOOLEAN_ONLY_TRUE),
        IS_NOT_EMPTY("is_not_empty", BOOLEAN_ONLY_TRUE);

        private final String method;
        private final int valueType;

        NumberFilterMethodEnum(String method, int valueType) {
            this.method = method;
            this.valueType = valueType;
        }
    }

}
