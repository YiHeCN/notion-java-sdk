package com._2lazy2name.notion.entity.property.database;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.property.NullToEmptyObjectSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#email-configuration">Email Configuration</a>
 */
public class EmailConfiguration extends AbstractDatabaseProperty {
    private final PropertyTypeEnum type = PropertyTypeEnum.EMAIL;
    @JsonSerialize(nullsUsing = NullToEmptyObjectSerializer.class)
    private final Object email = null;
    @JsonIgnore
    private static final EmailConfiguration INSTANCE = new EmailConfiguration();

    private EmailConfiguration() {
    }

    public static EmailConfiguration getInstance() {
        return INSTANCE;
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public Object getEmail() {
        return email;
    }
}
