package com._2lazy2name.notion.entity.property.database;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.property.NullToEmptyObjectSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#last-edited-by-configuration">Last Edited By Configuration</a>
 */
@Getter @Setter @ToString
public class LastEditedByConfiguration extends AbstractDatabaseProperty {
    private final PropertyTypeEnum type = PropertyTypeEnum.LAST_EDITED_BY;
    @JsonSerialize(nullsUsing = NullToEmptyObjectSerializer.class)
    private final Object lastEditedBy = null;
    @JsonIgnore
    private static final LastEditedByConfiguration INSTANCE = new LastEditedByConfiguration();

    private LastEditedByConfiguration() {
    }

    public static LastEditedByConfiguration getInstance() {
        return INSTANCE;
    }
}
