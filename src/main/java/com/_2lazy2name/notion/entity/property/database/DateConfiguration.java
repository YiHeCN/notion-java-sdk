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
 * @see <a href="https://developers.notion.com/reference/property-object#date-configuration">Date Configuration</a>
 */
@Getter @Setter @ToString
public class DateConfiguration extends AbstractDatabaseProperty {
    private PropertyTypeEnum type = PropertyTypeEnum.DATE;
    @JsonSerialize(nullsUsing = NullToEmptyObjectSerializer.class)
    private final Object date = null;
    @JsonIgnore
    private static final DateConfiguration INSTANCE = new DateConfiguration();

    private DateConfiguration() {
    }

    public static DateConfiguration getInstance() {
        return INSTANCE;
    }
}
