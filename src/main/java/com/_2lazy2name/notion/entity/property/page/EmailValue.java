package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;

/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#email">Email</a>
 */
public class EmailValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.EMAIL;
    private String email;

    private EmailValue() {
    }

    public EmailValue(String email) {
        this.email = email;
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public EmailValue setEmail(String email) {
        this.email = email;
        return this;
    }
}
