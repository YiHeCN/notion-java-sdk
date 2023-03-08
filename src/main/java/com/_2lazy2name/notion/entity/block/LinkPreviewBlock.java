package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.common.LinkPreview;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LinkPreviewBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.LINK_PREVIEW;
    private LinkPreview linkPreview;

    // The link_preview block can only be returned as part of a response.
    // The API does not support creating or appending link_preview blocks.
    // See: https://developers.notion.com/reference/block#link-preview
    private static LinkPreviewBlock ofUrl(String url) {
        return new LinkPreviewBlock(LinkPreview.ofUrl(url));
    }

    @JsonIgnore
    public String getUrl() {
        return linkPreview.getUrl();
    }

    public LinkPreviewBlock setUrl(String url) {
        this.linkPreview = linkPreview.setUrl(url);
        return this;
    }

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private LinkPreviewBlock() {}

    private LinkPreviewBlock(LinkPreview linkPreview) {
        this.linkPreview = linkPreview;
    }
}
