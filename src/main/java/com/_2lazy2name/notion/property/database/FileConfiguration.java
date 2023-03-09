package com._2lazy2name.notion.property.database;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.serializer.NullToEmptyObjectSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#files-configuration">Files Configuration</a>
 */
public class FileConfiguration extends AbstractDatabaseProperty {
    private final PropertyTypeEnum type = PropertyTypeEnum.FILES;
    @JsonSerialize(nullsUsing = NullToEmptyObjectSerializer.class)
    private final Object files = null;
    @JsonIgnore
    private static final FileConfiguration INSTANCE = new FileConfiguration();

    private FileConfiguration() {
    }

    public static FileConfiguration getInstance() {
        return INSTANCE;
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public Object getFiles() {
        return files;
    }
}
