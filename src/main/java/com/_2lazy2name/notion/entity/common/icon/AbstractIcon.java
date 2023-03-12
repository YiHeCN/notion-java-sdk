package com._2lazy2name.notion.entity.common.icon;

import com._2lazy2name.notion.enumeration.type.IconTypeEnum;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(value = EmojiIcon.class, name = "emoji"),
        @JsonSubTypes.Type(value = FileIcon.class, name = "external"),
})
public abstract class AbstractIcon {
    protected IconTypeEnum type;

    protected AbstractIcon() {
    }

    public abstract IconTypeEnum getType();
}
