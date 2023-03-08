package com._2lazy2name.notion.entity.property.database;

import com._2lazy2name.notion.entity.enumeration.NumberFormatEnum;
import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#number-configuration">Number Configuration</a>
 */
public class NumberConfiguration extends AbstractDatabaseProperty {
    private final PropertyTypeEnum type = PropertyTypeEnum.NUMBER;
    private Number number;

    private static class Number {
        private NumberFormatEnum format;

        public NumberFormatEnum getFormat() {
            return format;
        }

        public Number setFormat(NumberFormatEnum format) {
            this.format = format;
            return this;
        }
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

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public Number getNumber() {
        return number;
    }

    public NumberConfiguration setNumber(Number number) {
        this.number = number;
        return this;
    }
}
