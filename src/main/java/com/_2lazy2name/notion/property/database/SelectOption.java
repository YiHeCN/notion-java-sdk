package com._2lazy2name.notion.property.database;

import com._2lazy2name.notion.enumeration.ColorEnum;
import com.fasterxml.jackson.annotation.JsonInclude;



/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#select-options">Select Options</a>
 */
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

    public String getName() {
        return name;
    }

    public SelectOption setName(String name) {
        this.name = name;
        return this;
    }

    public String getId() {
        return id;
    }

    public SelectOption setId(String id) {
        this.id = id;
        return this;
    }

    public ColorEnum getColor() {
        return color;
    }

    public SelectOption setColor(ColorEnum color) {
        this.color = color;
        return this;
    }
}
