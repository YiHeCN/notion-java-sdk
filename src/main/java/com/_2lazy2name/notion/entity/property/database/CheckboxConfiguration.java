package com._2lazy2name.notion.entity.property.database;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.property.NullToEmptyObjectSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#checkbox-configuration">Checkbox Configuration</a>
 */

public class CheckboxConfiguration extends AbstractDatabaseProperty {
    private final PropertyTypeEnum type = PropertyTypeEnum.CHECKBOX;
    @JsonSerialize(nullsUsing = NullToEmptyObjectSerializer.class)
    private final Object checkbox = null;
    @JsonIgnore
    private static final CheckboxConfiguration INSTANCE = new CheckboxConfiguration();

    private CheckboxConfiguration() {
    }

    public static CheckboxConfiguration getInstance() {
        return INSTANCE;
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public Object getCheckbox() {
        return checkbox;
    }
}
