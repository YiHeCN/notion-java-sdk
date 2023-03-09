package com._2lazy2name.notion.entity.common.richText.mention;

import com._2lazy2name.notion.enumeration.type.MentionTypeEnum;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = DatabaseMention.class, name = "database"),
        @JsonSubTypes.Type(value = DateMention.class, name = "date"),
        @JsonSubTypes.Type(value = PageMention.class, name = "page"),
        @JsonSubTypes.Type(value = UserMention.class, name = "user"),
        @JsonSubTypes.Type(value = TemplateMention.class, name = "template_mention"),
        @JsonSubTypes.Type(value = LinkPreviewMention.class, name = "link_preview"),
})
public abstract class AbstractMention {
    protected MentionTypeEnum type;

    public abstract MentionTypeEnum getType();
}
