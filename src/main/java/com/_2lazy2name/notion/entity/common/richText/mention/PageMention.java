package com._2lazy2name.notion.entity.common.richText.mention;

import com._2lazy2name.notion.enumeration.type.MentionTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Validate Constructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PageMention extends AbstractMention {
    private final MentionTypeEnum type = MentionTypeEnum.PAGE;
    private PageId page;

    @JsonIgnore
    public String getPageId() {
        return page == null ? null : page.getId();
    }

    public void setPageId(String pageId) {
        if (this.page == null) this.page = new PageId();
        this.page.id = pageId;
    }

    private PageMention() {}

    public PageMention(String pageId) {
        this.page = new PageMention.PageId();
        this.page.id = pageId;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class PageId {
        private String id;

        private String getId() {
            return id;
        }

        private PageMention.PageId setId(String id) {
            this.id = id;
            return this;
        }
    }

    public MentionTypeEnum getType() {
        return type;
    }

    private PageMention.PageId getPage() {
        return page;
    }

    private PageMention setPage(PageMention.PageId page) {
        this.page = page;
        return this;
    }
}
