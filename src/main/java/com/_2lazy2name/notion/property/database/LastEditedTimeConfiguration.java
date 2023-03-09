package com._2lazy2name.notion.property.database;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.serializer.NullToEmptyObjectSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#last-edited-time-configuration">Last Edited Time Configuration</a>
 */

public class LastEditedTimeConfiguration extends AbstractDatabaseProperty {
    private final PropertyTypeEnum type = PropertyTypeEnum.LAST_EDITED_TIME;
    @JsonSerialize(nullsUsing = NullToEmptyObjectSerializer.class)
    private final Object lastEditedTime = null;
    @JsonIgnore
    private static final LastEditedTimeConfiguration INSTANCE = new LastEditedTimeConfiguration();

    private LastEditedTimeConfiguration() {
    }

    public static LastEditedTimeConfiguration getInstance() {
        return INSTANCE;
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public Object getLastEditedTime() {
        return lastEditedTime;
    }
}
