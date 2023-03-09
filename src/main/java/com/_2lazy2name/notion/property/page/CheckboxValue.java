package com._2lazy2name.notion.property.page;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;

/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#checkbox">Checkbox</a>
 */

public class CheckboxValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.CHECKBOX;
    private Boolean checkbox;

    private CheckboxValue() {
    }

    public CheckboxValue(Boolean checkbox) {
        this.checkbox = checkbox;
    }

    public Boolean toggle() {
        this.checkbox = !this.checkbox;
        return this.checkbox;
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public Boolean getCheckbox() {
        return checkbox;
    }

    public CheckboxValue setCheckbox(Boolean checkbox) {
        this.checkbox = checkbox;
        return this;
    }
}
