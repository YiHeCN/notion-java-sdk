package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.common.Date;
import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#date">Date</a>
 */
@Getter
@Setter
@ToString
public class DateValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.DATE;
    private Date date;

    private DateValue() {
    }

    public DateValue(Date date) {
        this.date = date;
    }
}
