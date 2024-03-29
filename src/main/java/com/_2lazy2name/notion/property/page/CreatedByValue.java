package com._2lazy2name.notion.property.page;

import com._2lazy2name.notion.entity.User;
import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;


/**
 * This object cannot be updated.
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#created-by">Created By</a>
 */
public class CreatedByValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.CREATED_BY;
    private User createdBy;

    private CreatedByValue() {
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public CreatedByValue setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
        return this;
    }
}
