package com._2lazy2name.notion.entity.common.file;

import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.enumeration.type.FileTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

/**
 * {@link NotionHostedFile} objects contain data about a file that is uploaded to Notion.
 * {@link ExternalFile} file that is linked to in Notion.
 * Official Notion API does not provide a way to upload a file to Notion. i.e. Only External file is allowed to build.
 * However, you can still use the #{@link NotionHostedFile} from results of other API calls.
 * "It remains one of the files", according to Notion API.
 * TODO: Add a way to upload a file to Notion.
 * @version 1.0
 * @since 2023-02-01
 * @see <a href="https://developers.notion.com/reference/file-object">File object</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ExternalFile.class, name = "external"),
        @JsonSubTypes.Type(value = NotionHostedFile.class, name = "file"),
})
public abstract class AbstractFile {
    protected FileTypeEnum type;
    protected String name;
    protected List<AbstractRichText> caption;

    public abstract String getUrl();

    public FileTypeEnum getType() {
        return type;
    }

    public AbstractFile setType(FileTypeEnum type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public AbstractFile setName(String name) {
        this.name = name;
        return this;
    }

    public List<AbstractRichText> getCaption() {
        return caption;
    }

    public AbstractFile setCaption(List<AbstractRichText> caption) {
        this.caption = caption;
        return this;
    }
}
