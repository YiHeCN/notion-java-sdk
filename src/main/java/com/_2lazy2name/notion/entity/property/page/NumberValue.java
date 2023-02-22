package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#number">Number</a>
 */
@Getter
@Setter
@ToString
public class NumberValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.NUMBER;
    private Double number;

    private NumberValue() {
    }

    public NumberValue(Double number) {
        this.number = number;
    }

}
