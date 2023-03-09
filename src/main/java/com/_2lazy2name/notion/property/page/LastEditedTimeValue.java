package com._2lazy2name.notion.property.page;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;

import java.util.Date;

/**
 * This object cannot be updated.
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#last-edited-time">Last Edited Time</a>
 */
public class LastEditedTimeValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.LAST_EDITED_TIME;
    private Date lastEditedTime;

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public Date getLastEditedTime() {
        return lastEditedTime;
    }

    public LastEditedTimeValue setLastEditedTime(Date lastEditedTime) {
        this.lastEditedTime = lastEditedTime;
        return this;
    }
}
