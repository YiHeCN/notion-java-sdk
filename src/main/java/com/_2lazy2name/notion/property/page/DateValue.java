package com._2lazy2name.notion.property.page;

import com._2lazy2name.notion.entity.common.Date;
import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#date">Date</a>
 */
public class DateValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.DATE;
    private Date date;

    private DateValue() {
    }

    public DateValue(Date date) {
        this.date = date;
    }

    public DateValue(java.util.Date date) {
        this.date = new Date(date);
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public DateValue setDate(Date date) {
        this.date = date;
        return this;
    }
}
