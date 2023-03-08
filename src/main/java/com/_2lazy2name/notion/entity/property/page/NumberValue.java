package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;



/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#number">Number</a>
 */


public class NumberValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.NUMBER;
    private Double number;

    private NumberValue() {
    }

    public NumberValue(Double number) {
        this.number = number;
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public Double getNumber() {
        return number;
    }

    public NumberValue setNumber(Double number) {
        this.number = number;
        return this;
    }
}
