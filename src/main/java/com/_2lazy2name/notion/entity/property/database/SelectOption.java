package com._2lazy2name.notion.entity.property.database;

import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#select-options">Select Options</a>
 */
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SelectOption {
    private String name;
    private String id;
    private ColorEnum color;

    private SelectOption() {
    }

    public SelectOption(String name, ColorEnum color) {
        this.name = name;
        this.color = color;
    }

    public SelectOption(String name) {
        this.name = name;
    }


}
