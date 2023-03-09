package com._2lazy2name.notion.property.database;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.serializer.NullToEmptyObjectSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#created-time-configuration">Created Time Configuration</a>
 */

public class CreatedTimeConfiguration extends AbstractDatabaseProperty{
    private final PropertyTypeEnum type = PropertyTypeEnum.CREATED_TIME;
    @JsonSerialize(nullsUsing = NullToEmptyObjectSerializer.class)
    private final Object createdTime = null;
    @JsonIgnore
    private static final CreatedTimeConfiguration INSTANCE = new CreatedTimeConfiguration();

    private CreatedTimeConfiguration() {
    }

    public static CreatedTimeConfiguration getInstance() {
        return INSTANCE;
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public Object getCreatedTime() {
        return createdTime;
    }
}
