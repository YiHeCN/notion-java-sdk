package com._2lazy2name.notion.entity.property.database;

import com._2lazy2name.notion.entity.enumeration.NumberFormatEnum;
import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#number-configuration">Number Configuration</a>
 */
@Getter
@Setter
@ToString
public class NumberConfiguration extends AbstractDatabaseProperty {
    private final PropertyTypeEnum type = PropertyTypeEnum.NUMBER;
    private Number number;

    @Getter @Setter
    private static class Number {
        private NumberFormatEnum format;
    }

    private NumberConfiguration() {
    }

    public NumberConfiguration(NumberFormatEnum format) {
        this.number = new Number();
        this.number.setFormat(format);
    }

    @JsonIgnore
    public NumberFormatEnum getFormat() {
        return this.number.getFormat();
    }

    public void setFormat(NumberFormatEnum format) {
        this.number.setFormat(format);
    }
}
