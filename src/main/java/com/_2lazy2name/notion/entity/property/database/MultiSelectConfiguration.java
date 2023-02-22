package com._2lazy2name.notion.entity.property.database;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#multi-select-configuration">Multiselect Configuration</a>
 */
@Getter
@Setter
@ToString
public class MultiSelectConfiguration extends AbstractDatabaseProperty {
    private PropertyTypeEnum type = PropertyTypeEnum.MULTI_SELECT;
    private Multiselect multiSelect;
    
    @Getter @Setter
    private static class Multiselect {
        private List<SelectOption> options;
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


}
