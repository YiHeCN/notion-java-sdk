package com._2lazy2name.notion.property.database;

import com._2lazy2name.notion.enumeration.ObjectEnum;
import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.property.AbstractProperty;
import com.fasterxml.jackson.annotation.*;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSubTypes({
    @JsonSubTypes.Type(value = CheckboxConfiguration.class, name = "checkbox"),
    @JsonSubTypes.Type(value = CreatedByConfiguration.class, name = "created_by"),
    @JsonSubTypes.Type(value = CreatedTimeConfiguration.class, name = "created_time"),
    @JsonSubTypes.Type(value = DateConfiguration.class, name = "date"),
    @JsonSubTypes.Type(value = EmailConfiguration.class, name = "email"),
    @JsonSubTypes.Type(value = FileConfiguration.class, name = "files"),
    @JsonSubTypes.Type(value = FormulaConfiguration.class, name = "formula"),
    @JsonSubTypes.Type(value = LastEditedByConfiguration.class, name = "last_edited_by"),
    @JsonSubTypes.Type(value = LastEditedTimeConfiguration.class, name = "last_edited_time"),
    @JsonSubTypes.Type(value = MultiSelectConfiguration.class, name = "multi_select"),
    @JsonSubTypes.Type(value = NumberConfiguration.class, name = "number"),
    @JsonSubTypes.Type(value = PeopleConfiguration.class, name = "people"),
    @JsonSubTypes.Type(value = PhoneNumberConfiguration.class, name = "phone_number"),
    @JsonSubTypes.Type(value = RelationConfiguration.class, name = "relation"),
    @JsonSubTypes.Type(value = RichTextConfiguration.class, name = "rich_text"),
    @JsonSubTypes.Type(value = RollupConfiguration.class, name = "rollup"),
    @JsonSubTypes.Type(value = SelectConfiguration.class, name = "select"),
    @JsonSubTypes.Type(value = StatusConfiguration.class, name = "status"),
    @JsonSubTypes.Type(value = TitleConfiguration.class, name = "title"),
    @JsonSubTypes.Type(value = UrlConfiguration.class, name = "url"),
})
public abstract class AbstractDatabaseProperty extends AbstractProperty {
    private ObjectEnum object;
    protected PropertyTypeEnum type;
    private String name;

    public ObjectEnum getObject() {
        return object;
    }

    public PropertyTypeEnum getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
