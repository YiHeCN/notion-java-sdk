package com._2lazy2name.notion.entity.property.database;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#select-configuration">Select Configuration</a>
 */
@Getter @Setter @ToString
public class SelectConfiguration extends AbstractDatabaseProperty {
    private final PropertyTypeEnum type = PropertyTypeEnum.SELECT;
    private Select select;

    @Getter @Setter @ToString
    private static class Select {
        private List<SelectOption> options = new ArrayList<>();
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
}
