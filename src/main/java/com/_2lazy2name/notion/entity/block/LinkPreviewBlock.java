package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.common.LinkPreview;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LinkPreviewBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.LINK_PREVIEW;
    private LinkPreview linkPreview;

    public static LinkPreviewBlock ofUrl(String url) {
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
