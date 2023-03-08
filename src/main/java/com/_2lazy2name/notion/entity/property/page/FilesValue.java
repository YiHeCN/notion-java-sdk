package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;


import java.util.List;

/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#files">Files</a>
 */
public class FilesValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.FILES;
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
