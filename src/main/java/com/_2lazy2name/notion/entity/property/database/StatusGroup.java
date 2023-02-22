package com._2lazy2name.notion.entity.property.database;

import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#status-groups">Status Group</a>
 */
@Getter
@Setter
@ToString
public class StatusGroup {
    private String id;
    private String name;
    private ColorEnum color;
    private List<String> optionIds;
}
