package com._2lazy2name.notion.entity.common.filter;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.common.filter.typeSpecific.IFilterMethod;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@ToString @Getter @Setter
@JsonSerialize(using = FilterSerializer.class)
public abstract class PropertyFilter implements AbstractFilter {
    protected PropertyTypeEnum type;
    protected String property;
    protected IFilterMethod method;
    protected Object value;

    protected PropertyFilter() {
    }
}
