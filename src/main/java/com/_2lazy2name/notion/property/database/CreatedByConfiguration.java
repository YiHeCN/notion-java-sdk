package com._2lazy2name.notion.property.database;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.property.NullToEmptyObjectSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#created-by-configuration">Created By Configuration</a>
 */

public class CreatedByConfiguration extends AbstractDatabaseProperty {
    private final PropertyTypeEnum type = PropertyTypeEnum.CREATED_BY;
    @JsonSerialize(nullsUsing = NullToEmptyObjectSerializer.class)
    private final Object createdBy = null;
    @JsonIgnore
    private static final CreatedByConfiguration INSTANCE = new CreatedByConfiguration();

    private CreatedByConfiguration() {
    }

    public static CreatedByConfiguration getInstance() {
        return INSTANCE;
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public Object getCreatedBy() {
        return createdBy;
    }
}
