package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.User;
import com._2lazy2name.notion.entity.common.Date;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.property.AbstractProperty;
import com._2lazy2name.notion.entity.property.database.SelectOption;
import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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
@Getter @Setter @ToString
public class AbstractPagePropertyValue extends AbstractProperty {
    private String id;
    protected PropertyTypeEnum type;

    public static CheckboxValue buildCheckboxValue(boolean value) {
        return new CheckboxValue(value);
    }

    public static DateValue buildDataValue(java.util.Date start, java.util.Date end, String timeZone) {
        Date date = new Date(start, end, timeZone);
        return new DateValue(date);
    }
    public static DateValue buildDataValue(java.util.Date start, java.util.Date end) {
        return buildDataValue(start, end, null);
    }
    public static DateValue buildDataValue(java.util.Date start) {
        return buildDataValue(start, null);
    }
    public static DateValue buildDataValue(String start, String end, String timeZone) {
        Date date = new Date(start, end, timeZone);
        return new DateValue(date);
    }
    public static DateValue buildDataValue(String start, String end) {
        return buildDataValue(start, end, null);
    }
    public static DateValue buildDataValue(String start) {
        return buildDataValue(start, null);
    }
    public static DateValue buildDataValue(Date date) {
        return new DateValue(date);
    }

    public static EmailValue buildEmailValue(String email) {
        return new EmailValue(email);
    }

    public static FilesValue buildFilesValue(List<AbstractFile> files) {
        return new FilesValue(files);
    }
    public static FilesValue buildFilesValue(AbstractFile file) {
        return new FilesValue(List.of(file));
    }

    public static MultiselectValue buildMultiSelectValue(List<SelectOption> selectedOptions) {
        return new MultiselectValue(selectedOptions);
    }
    public static MultiselectValue buildMultiSelectValue(SelectOption selectedOption) {
        return new MultiselectValue(List.of(selectedOption));
    }

    public static NumberValue buildNumberValue(double number) {
        return new NumberValue(number);
    }

    public static PeopleValue buildPeopleValue(User person) {
        return new PeopleValue(List.of(person));
    }
    public static PeopleValue buildPeopleValue(List<User> people) {
        return new PeopleValue(people);
    }

    public static PhoneNumberValue buildPhoneNumberValue(String phoneNumber) {
        return new PhoneNumberValue(phoneNumber);
    }

    public static RichTextValue buildRichTextValue(List<AbstractRichText> richText) {
        return new RichTextValue(richText);
    }
    public static RichTextValue buildRichTextValue(String value) {
        return new RichTextValue(List.of(AbstractRichText.buildPlainText(value)));
    }

    public static SelectValue buildSelectValue(SelectOption option) {
        return new SelectValue(option);
    }

    public static StatusValue buildStatusValue(SelectOption option) {
        return new StatusValue(option);
    }

    public static TitleValue buildTitleValue(String title) {
        return new TitleValue(List.of(AbstractRichText.buildPlainText(title)));
    }
    public static TitleValue buildTitleValue(List<AbstractRichText> title) {
        return new TitleValue(title);
    }

    public static UrlValue buildUrlValue(String url) {
        return new UrlValue(url);
    }
}
