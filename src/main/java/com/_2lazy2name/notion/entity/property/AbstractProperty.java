package com._2lazy2name.notion.entity.property;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public abstract class AbstractProperty {
    private String id;
    protected PropertyTypeEnum type;

    public String getId() {
        return id;
    }

    public PropertyTypeEnum getType() {
        return type;
    }
}
