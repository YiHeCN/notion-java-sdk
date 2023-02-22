package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
public class LinkPreviewBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.LINK_PREVIEW;
    private String url;

    private LinkPreviewBlock() {}

    private LinkPreviewBlock(String url) {
        this.url = url;
    }

    public static LinkPreviewBlock ofUrl(@NonNull String url) {
        return new LinkPreviewBlock(url);
    }
}
