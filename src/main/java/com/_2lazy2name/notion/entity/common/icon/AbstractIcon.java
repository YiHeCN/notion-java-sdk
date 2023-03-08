package com._2lazy2name.notion.entity.common.icon;

import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.enumeration.type.IconTypeEnum;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(value = EmojiIcon.class, name = "emoji"),
        @JsonSubTypes.Type(value = FileIcon.class, name = "external"),
})
public abstract class AbstractIcon {
    private IconTypeEnum type;

    protected AbstractIcon() {
    }

    public static EmojiIcon buildEmojiIcon(char emoji) {
        return new EmojiIcon(emoji);
    }

    public static FileIcon buildFileIcon(AbstractFile file) {
        return new FileIcon(file);
    }

    public IconTypeEnum getType() {
        return type;
    }

    public AbstractIcon setType(IconTypeEnum type) {
        this.type = type;
        return this;
    }
}
