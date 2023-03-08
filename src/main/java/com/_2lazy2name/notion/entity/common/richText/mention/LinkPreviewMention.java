package com._2lazy2name.notion.entity.common.richText.mention;

import com._2lazy2name.notion.entity.common.LinkPreview;
import com._2lazy2name.notion.entity.enumeration.type.MentionTypeEnum;

public class LinkPreviewMention extends AbstractMention {
    private final MentionTypeEnum type = MentionTypeEnum.LINK_PREVIEW;
    private LinkPreview linkPreview;

    private LinkPreviewMention() {
    }

    public LinkPreviewMention(LinkPreview linkPreview) {
        this.linkPreview = linkPreview;
    }

    public MentionTypeEnum getType() {
        return type;
    }

    public LinkPreview getLinkPreview() {
        return linkPreview;
    }

    public LinkPreviewMention setLinkPreview(LinkPreview linkPreview) {
        this.linkPreview = linkPreview;
        return this;
    }
}
