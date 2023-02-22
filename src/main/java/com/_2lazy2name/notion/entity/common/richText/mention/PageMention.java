package com._2lazy2name.notion.entity.common.richText.mention;

import com._2lazy2name.notion.entity.Page;
import com._2lazy2name.notion.entity.enumeration.type.MentionTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PageMention extends AbstractMention {
    private final MentionTypeEnum type = MentionTypeEnum.PAGE;
    private Page page;

    private PageMention() {
    }

    public PageMention(Page page) {
        this.page = page;
    }
}
