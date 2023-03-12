package com._2lazy2name.notion.property.page;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.property.AbstractProperty;
import com.fasterxml.jackson.annotation.*;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values">Page Property Value</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CheckboxValue.class, name = "checkbox"),
        @JsonSubTypes.Type(value = CreatedByValue.class, name = "created_by"),
        @JsonSubTypes.Type(value = CreatedTimeValue.class, name = "created_time"),
        @JsonSubTypes.Type(value = DateValue.class, name = "date"),
        @JsonSubTypes.Type(value = EmailValue.class, name = "email"),
        @JsonSubTypes.Type(value = FilesValue.class, name = "files"),
        @JsonSubTypes.Type(value = FormulaValue.class, name = "formula"),
        @JsonSubTypes.Type(value = LastEditedByValue.class, name = "last_edited_by"),
        @JsonSubTypes.Type(value = LastEditedTimeValue.class, name = "last_edited_time"),
        @JsonSubTypes.Type(value = MultiselectValue.class, name = "multi_select"),
        @JsonSubTypes.Type(value = NumberValue.class, name = "number"),
        @JsonSubTypes.Type(value = PeopleValue.class, name = "people"),
        @JsonSubTypes.Type(value = PhoneNumberValue.class, name = "phone_number"),
        @JsonSubTypes.Type(value = RelationValue.class, name = "relation"),
        @JsonSubTypes.Type(value = RichTextValue.class, name = "rich_text"),
        @JsonSubTypes.Type(value = RollupValue.class, name = "rollup"),
        @JsonSubTypes.Type(value = SelectValue.class, name = "select"),
        @JsonSubTypes.Type(value = StatusValue.class, name = "status"),
        @JsonSubTypes.Type(value = TitleValue.class, name = "title"),
        @JsonSubTypes.Type(value = UrlValue.class, name = "url")
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AbstractPagePropertyValue extends AbstractProperty {
    private String id;
    protected PropertyTypeEnum type;

    @Override
    public String getId() {
        return id;
    }

    public AbstractPagePropertyValue setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public AbstractPagePropertyValue setType(PropertyTypeEnum type) {
        this.type = type;
        return this;
    }
}
