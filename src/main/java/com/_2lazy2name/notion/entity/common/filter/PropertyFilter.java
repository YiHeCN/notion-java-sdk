package com._2lazy2name.notion.entity.common.filter;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.common.filter.typeSpecific.IFilterMethod;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = FilterSerializer.class)
public abstract class PropertyFilter implements AbstractFilter {
    protected PropertyTypeEnum type;
    protected String property;
    protected IFilterMethod method;
    protected Object value;

    protected PropertyFilter() {
    }

    public PropertyTypeEnum getType() {
        return type;
    }

    public PropertyFilter setType(PropertyTypeEnum type) {
        this.type = type;
        return this;
    }

    public String getProperty() {
        return property;
    }

    public PropertyFilter setProperty(String property) {
        this.property = property;
        return this;
    }

    public IFilterMethod getMethod() {
        return method;
    }

    public PropertyFilter setMethod(IFilterMethod method) {
        this.method = method;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public PropertyFilter setValue(Object value) {
        this.value = value;
        return this;
    }
}
