package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
public class EmbedBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.EMBED;
    private String url;

    private EmbedBlock() {}

    private EmbedBlock(String url) {
        this.url = url;
    }

    public static EmbedBlock ofUrl(@NonNull String url) {
        return new EmbedBlock(url);
    }
}
