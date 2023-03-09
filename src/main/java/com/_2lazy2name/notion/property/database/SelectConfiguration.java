package com._2lazy2name.notion.property.database;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.ArrayList;
import java.util.List;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#select-configuration">Select Configuration</a>
 */
public class SelectConfiguration extends AbstractDatabaseProperty {
    private final PropertyTypeEnum type = PropertyTypeEnum.SELECT;
    private Select select;


    private static class Select {
        private List<SelectOption> options = new ArrayList<>();

        public List<SelectOption> getOptions() {
            return options;
        }

        public Select setOptions(List<SelectOption> options) {
            this.options = options;
            return this;
        }
    }

    private SelectConfiguration() {
    }

    public SelectConfiguration(List<SelectOption> options) {
        this.select = new Select();
        this.select.setOptions(options);
    }

    @JsonIgnore
    public List<SelectOption> getOptions() {
        return this.select.getOptions();
    }

    public void setOptions(List<SelectOption> options) {
        this.select.setOptions(options);
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public Select getSelect() {
        return select;
    }

    public SelectConfiguration setSelect(Select select) {
        this.select = select;
        return this;
    }
}
