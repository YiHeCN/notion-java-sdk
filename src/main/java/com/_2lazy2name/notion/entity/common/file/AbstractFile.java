package com._2lazy2name.notion.entity.common.file;

import com._2lazy2name.notion.entity.enumeration.type.FileTypeEnum;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * {@link NotionFile} objects contain data about a file that is uploaded to Notion.
 * {@link ExternalFile} file that is linked to in Notion.
 * Official Notion API does not provide a way to upload a file to Notion. i.e. Only External file is allowed to build.
 * However, you can still use the #{@link NotionFile} from results of other API calls.
 * "It remains one of the files", according to Notion API.
 * TODO: Add a way to upload a file to Notion.
 * @version 1.0
 * @since 2023-02-01
 * @see <a href="https://developers.notion.com/reference/file-object">File object</a>
 */
@Getter @Setter @ToString
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ExternalFile.class, name = "external"),
        @JsonSubTypes.Type(value = NotionFile.class, name = "file"),
})
public abstract class AbstractFile {
    protected FileTypeEnum type;
    protected String name;

    public static ExternalFile buildExternalFile(String name, String url) {
        return new ExternalFile(name, url);
    }
}
