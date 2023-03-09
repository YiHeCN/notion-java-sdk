package com._2lazy2name.notion.property.database;

import com._2lazy2name.notion.enumeration.NumberFormatEnum;
import com._2lazy2name.notion.enumeration.ObjectEnum;
import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.property.AbstractProperty;
import com.fasterxml.jackson.annotation.*;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, property = "type")
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

    public static RenamingProperty buildOnlyNamePropertyForRenaming(String name) {
        return new RenamingProperty(name);
    }

    public static CheckboxConfiguration buildCheckboxProperty() {
        return CheckboxConfiguration.getInstance();
    }

    public static CreatedByConfiguration buildCreatedByProperty() {
        return CreatedByConfiguration.getInstance();
    }

    public static CreatedTimeConfiguration buildCreatedTimeProperty() {
        return CreatedTimeConfiguration.getInstance();
    }

    public static DateConfiguration buildDateProperty() {
        return DateConfiguration.getInstance();
    }

    public static EmailConfiguration buildEmailProperty() {
        return EmailConfiguration.getInstance();
    }

    public static FileConfiguration buildFileProperty() {
        return FileConfiguration.getInstance();
    }

    public static FormulaConfiguration buildFormulaProperty(String expression) {
        return new FormulaConfiguration(expression);
    }

    public static LastEditedByConfiguration buildLastEditedByProperty() {
        return LastEditedByConfiguration.getInstance();
    }

    public static LastEditedTimeConfiguration buildLastEditedTimeProperty() {
        return LastEditedTimeConfiguration.getInstance();
    }

    public static MultiSelectConfiguration buildMultiSelectProperty(List<SelectOption> options) {
        return new MultiSelectConfiguration(options);
    }

    public static NumberConfiguration buildNumberProperty(NumberFormatEnum numberFormat) {
        return new NumberConfiguration(numberFormat);
    }

    public static PeopleConfiguration buildPeopleProperty() {
        return PeopleConfiguration.getInstance();
    }

    public static PhoneNumberConfiguration buildPhoneNumberProperty() {
        return PhoneNumberConfiguration.getInstance();
    }

    public static RichTextConfiguration buildRichTextProperty() {
        return RichTextConfiguration.getInstance();
    }


    public static SelectConfiguration buildSelectProperty(List<SelectOption> options) {
        return new SelectConfiguration(options);
    }

// TODO: This two methods are not implemented yet, because their class is not implemented yet.

//    public static RelationConfiguration buildRelationProperty(String databaseId) {
//        return new RelationConfiguration(databaseId);
//    }
//    public static StatusConfiguration buildStatusProperty(List<SelectOption> options) {
//        return new StatusConfiguration(options);
//    }

    public static TitleConfiguration buildTitleProperty() {
        return TitleConfiguration.getInstance();
    }

    public static UrlConfiguration buildUrlProperty() {
        return UrlConfiguration.getInstance();
    }

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
