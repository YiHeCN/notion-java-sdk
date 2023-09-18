package com._2lazy2name.notion.property.page;

import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.List;

/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#files">Files</a>
 */
public class FilesValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.FILES;
    @JsonFormat(shape = JsonFormat.Shape.OBJECT, with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<AbstractFile> files;

    private FilesValue() {
    }

    public FilesValue(List<AbstractFile> files) {
        this.files = files;
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public List<AbstractFile> getFiles() {
        return files;
    }

    public FilesValue setFiles(List<AbstractFile> files) {
        this.files = files;
        return this;
    }
}
