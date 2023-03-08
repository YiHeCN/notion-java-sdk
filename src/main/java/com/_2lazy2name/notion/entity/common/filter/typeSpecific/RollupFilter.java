package com._2lazy2name.notion.entity.common.filter.typeSpecific;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.common.filter.PropertyFilter;
import lombok.*;

public class RollupFilter extends PropertyFilter {
    private final PropertyTypeEnum type = PropertyTypeEnum.ROLLUP;
    private RollupFilterMethodEnum method;

    public RollupFilter(String property, RollupFilterMethodEnum method, Object value) {
        this.property = property;
    }

    public RollupFilter on(String property) {
        this.property = property;
        return this;
    }

    public RollupFilter any(PropertyFilter value) {
        this.method = RollupFilterMethodEnum.ANY;
        this.value = value;
        return this;
    }

    public RollupFilter every(PropertyFilter value) {
        this.method = RollupFilterMethodEnum.EVERY;
        this.value = value;
        return this;
    }

    public RollupFilter none(PropertyFilter value) {
        this.method = RollupFilterMethodEnum.NONE;
        this.value = value;
        return this;
    }
    public RollupFilter number(NumberFilter value) {
        this.method = RollupFilterMethodEnum.NUMBER;
        this.value = value;
        return this;
    }

    public RollupFilter date(DateFilter value) {
        this.method = RollupFilterMethodEnum.DATE;
        this.value = value;
        return this;
    }


    public enum RollupFilterMethodEnum implements IFilterMethod {
        ANY("any", FILTER_OBJECT),
        EVERY("every", FILTER_OBJECT),
        NONE("none", FILTER_OBJECT),
        NUMBER("number", FILTER_OBJECT),
        DATE("date", FILTER_OBJECT);

        private final String method;
        private final int valueType;

        RollupFilterMethodEnum(String method, int valueType) {
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
    public RollupFilterMethodEnum getMethod() {
        return method;
    }

    public RollupFilter setMethod(RollupFilterMethodEnum method) {
        this.method = method;
        return this;
    }
}
