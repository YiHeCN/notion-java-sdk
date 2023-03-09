package com._2lazy2name.notion.property.database;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.serializer.NullToEmptyObjectSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#date-configuration">Date Configuration</a>
 */
public class DateConfiguration extends AbstractDatabaseProperty {
    private PropertyTypeEnum type = PropertyTypeEnum.DATE;
    @JsonSerialize(nullsUsing = NullToEmptyObjectSerializer.class)
    private final Object date = null;
    @JsonIgnore
    private static final DateConfiguration INSTANCE = new DateConfiguration();

    private DateConfiguration() {
    }

    public static DateConfiguration getInstance() {
        return INSTANCE;
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public DateConfiguration setType(PropertyTypeEnum type) {
        this.type = type;
        return this;
    }

    public Object getDate() {
        return date;
    }
}
