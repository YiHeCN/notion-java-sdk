package com._2lazy2name.notion.property.page;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.property.database.SelectOption;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#status">Status</a>
 */
public class StatusValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.STATUS;
    private SelectOption status;

    private StatusValue() {
    }

    public StatusValue(SelectOption status) {
        this.status = status;
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public SelectOption getStatus() {
        return status;
    }

    public StatusValue setStatus(SelectOption status) {
        this.status = status;
        return this;
    }
}
