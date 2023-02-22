package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#checkbox">Checkbox</a>
 */
@Getter
@Setter
@ToString
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
}
