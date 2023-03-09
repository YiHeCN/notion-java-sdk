package com._2lazy2name.notion.property.page;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;

/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#phone-number">Phone Number</a>
 */
public class PhoneNumberValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.PHONE_NUMBER;
    private String phoneNumber;

    private PhoneNumberValue() {
    }

    public PhoneNumberValue(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PhoneNumberValue setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
