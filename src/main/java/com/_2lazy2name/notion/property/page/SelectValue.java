package com._2lazy2name.notion.property.page;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.property.database.SelectOption;

/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#select">Select</a>
 */
public class SelectValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.SELECT;
    private SelectOption select;

    private SelectValue() {
    }

    public SelectValue(SelectOption select) {
        this.select = select;
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public SelectOption getSelect() {
        return select;
    }

    public SelectValue setSelect(SelectOption select) {
        this.select = select;
        return this;
    }
}
