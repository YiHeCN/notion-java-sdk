package com._2lazy2name.notion.entity.common.sort;

import com._2lazy2name.notion.enumeration.SortDirectionEnum;


public class PropertyValueSort extends AbstractSort {
    private String property;

    private PropertyValueSort() {
    }

    public PropertyValueSort(String property, SortDirectionEnum direction) {
        this.property = property;
        this.direction = direction;
    }

    public String getProperty() {
        return property;
    }

    public PropertyValueSort setProperty(String property) {
        this.property = property;
        return this;
    }
}
