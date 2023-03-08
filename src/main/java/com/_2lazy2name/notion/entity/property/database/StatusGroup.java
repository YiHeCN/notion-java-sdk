package com._2lazy2name.notion.entity.property.database;

import com._2lazy2name.notion.entity.enumeration.ColorEnum;


import java.util.List;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#status-groups">Status Group</a>
 */

public class StatusGroup {
    private String id;
    private String name;
    private ColorEnum color;
    private List<String> optionIds;

    public String getId() {
        return id;
    }

    public StatusGroup setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StatusGroup setName(String name) {
        this.name = name;
        return this;
    }

    public ColorEnum getColor() {
        return color;
    }

    public StatusGroup setColor(ColorEnum color) {
        this.color = color;
        return this;
    }

    public List<String> getOptionIds() {
        return optionIds;
    }

    public StatusGroup setOptionIds(List<String> optionIds) {
        this.optionIds = optionIds;
        return this;
    }
}
