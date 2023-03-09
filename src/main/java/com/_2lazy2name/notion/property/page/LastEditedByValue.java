package com._2lazy2name.notion.property.page;

import com._2lazy2name.notion.entity.User;
import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;


/**
 * This object cannot be updated.
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#last-edited-by">Last Edited By</a>
 */
public class LastEditedByValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.LAST_EDITED_BY;
    private User lastEditedBy;

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public User getLastEditedBy() {
        return lastEditedBy;
    }

    public LastEditedByValue setLastEditedBy(User lastEditedBy) {
        this.lastEditedBy = lastEditedBy;
        return this;
    }
}
