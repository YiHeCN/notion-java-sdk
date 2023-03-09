package com._2lazy2name.notion.property.page;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.property.database.SelectOption;


import java.util.List;

/**
 * I strongly recommend you to directly use the result of Database Retrieve as the parameter of this class.
 * Attempt to create SelectOption is not a wise choice.
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#multi-select">Multi-select</a>
 */
public class MultiselectValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.MULTI_SELECT;
    private List<SelectOption> multiSelect;

    private MultiselectValue() {
    }

    public MultiselectValue(List<SelectOption> multiSelect) {
        this.multiSelect = multiSelect;
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public List<SelectOption> getMultiSelect() {
        return multiSelect;
    }

    public MultiselectValue setMultiSelect(List<SelectOption> multiSelect) {
        this.multiSelect = multiSelect;
        return this;
    }
}
