package com._2lazy2name.notion.property.database;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.property.NullToEmptyObjectSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#phone-number-configuration">Phone Number Configuration</a>
 */

public class PhoneNumberConfiguration extends AbstractDatabaseProperty {
    private final PropertyTypeEnum type = PropertyTypeEnum.PHONE_NUMBER;
    @JsonSerialize(nullsUsing = NullToEmptyObjectSerializer.class)
    private final Object phoneNumber = null;
    @JsonIgnore
    private static final PhoneNumberConfiguration INSTANCE = new PhoneNumberConfiguration();

    private PhoneNumberConfiguration() {
    }

    public static PhoneNumberConfiguration getInstance() {
        return INSTANCE;
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public Object getPhoneNumber() {
        return phoneNumber;
    }
}
