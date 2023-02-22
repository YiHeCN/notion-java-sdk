package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.property.database.SelectOption;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#select">Select</a>
 */
@Getter
@Setter
@ToString
public class SelectValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.SELECT;
    private SelectOption select;

    private SelectValue() {
    }

    public SelectValue(SelectOption select) {
        this.select = select;
    }
}
