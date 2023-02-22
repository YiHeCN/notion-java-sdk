package com._2lazy2name.notion.entity.common.icon;

import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.enumeration.type.IconTypeEnum;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
public class FileIcon extends AbstractIcon {
    private final IconTypeEnum type = IconTypeEnum.EXTERNAL;
    @JsonUnwrapped
    private AbstractFile file;

    private FileIcon() {
    }

    public FileIcon(@NonNull AbstractFile file) {
        this.file = file;
    }
}
