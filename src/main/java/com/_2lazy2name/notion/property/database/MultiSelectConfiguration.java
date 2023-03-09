package com._2lazy2name.notion.property.database;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#multi-select-configuration">Multiselect Configuration</a>
 */
public class MultiSelectConfiguration extends AbstractDatabaseProperty {
    private PropertyTypeEnum type = PropertyTypeEnum.MULTI_SELECT;
    private Multiselect multiSelect;
    
    private static class Multiselect {
        private List<SelectOption> options;

        public List<SelectOption> getOptions() {
            return options;
        }

        public Multiselect setOptions(List<SelectOption> options) {
            this.options = options;
            return this;
        }
    }

    private MultiSelectConfiguration() {
    }

    public MultiSelectConfiguration(List<SelectOption> options) {
        this.multiSelect = new MultiSelectConfiguration.Multiselect();
        this.multiSelect.setOptions(options);
    }

    @JsonIgnore
    public List<SelectOption> getOptions() {
        return this.multiSelect.getOptions();
    }

    public void setOptions(List<SelectOption> options) {
        this.multiSelect.setOptions(options);
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public MultiSelectConfiguration setType(PropertyTypeEnum type) {
        this.type = type;
        return this;
    }

    public Multiselect getMultiSelect() {
        return multiSelect;
    }

    public MultiSelectConfiguration setMultiSelect(Multiselect multiSelect) {
        this.multiSelect = multiSelect;
        return this;
    }
}
