package com._2lazy2name.notion.entity.common.parent;

import com._2lazy2name.notion.entity.enumeration.type.ParentTypeEnum;

public class PageParent extends AbstractParent {
    private final ParentTypeEnum type = ParentTypeEnum.PAGE_ID;
    private String pageId;

    @Override
    public ParentTypeEnum getType() {
        return type;
    }

    public String getPageId() {
        return pageId;
    }

    public PageParent setPageId(String pageId) {
        this.pageId = pageId;
        return this;
    }
}
