package com._2lazy2name.notion.entity.common.icon;

import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.enumeration.type.IconTypeEnum;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class FileIcon extends AbstractIcon {
    private final IconTypeEnum type = IconTypeEnum.EXTERNAL;
    @JsonUnwrapped
    private AbstractFile file;

    private FileIcon() {
    }

    public FileIcon(AbstractFile file) {
        this.file = file;
    }

    @Override
    public IconTypeEnum getType() {
        return type;
    }

    public AbstractFile getFile() {
        return file;
    }

    public FileIcon setFile(AbstractFile file) {
        this.file = file;
        return this;
    }
}
