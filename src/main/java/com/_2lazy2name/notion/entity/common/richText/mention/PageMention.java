package com._2lazy2name.notion.entity.common.richText.mention;

import com._2lazy2name.notion.entity.Page;
import com._2lazy2name.notion.enumeration.type.MentionTypeEnum;

public class PageMention extends AbstractMention {
    private final MentionTypeEnum type = MentionTypeEnum.PAGE;
    private Page page;

    private PageMention() {
    }

    public PageMention(Page page) {
        this.page = page;
    }

    public MentionTypeEnum getType() {
        return type;
    }

    public Page getPage() {
        return page;
    }

    public PageMention setPage(Page page) {
        this.page = page;
        return this;
    }
}
