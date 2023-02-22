package com._2lazy2name.notion.entity.common.richText.mention;

import com._2lazy2name.notion.entity.common.LinkPreview;
import com._2lazy2name.notion.entity.enumeration.type.MentionTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
public class LinkPreviewMention extends AbstractMention {
    private final MentionTypeEnum type = MentionTypeEnum.LINK_PREVIEW;
    private LinkPreview linkPreview;

    private LinkPreviewMention() {
    }

    public LinkPreviewMention(LinkPreview linkPreview) {
        this.linkPreview = linkPreview;
    }
}
