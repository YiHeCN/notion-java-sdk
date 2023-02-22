package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#phone-number">Phone Number</a>
 */
@Getter
@Setter
@ToString
public class PhoneNumberValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.PHONE_NUMBER;
    private String phoneNumber;

    private PhoneNumberValue() {
    }

    public PhoneNumberValue(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
