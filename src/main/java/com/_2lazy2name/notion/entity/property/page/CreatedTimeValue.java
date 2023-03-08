package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;

import java.util.Date;

/**
 * This object cannot be updated.
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#created-time">Created Time</a>
 */

public class CreatedTimeValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.CREATED_TIME;
    private Date createdTime;

    private CreatedTimeValue() {
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public CreatedTimeValue setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
        return this;
    }
}
