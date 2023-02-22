package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString @Getter @Setter
public class SyncedBlockBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.SYNCED_BLOCK;
    private SyncedFrom syncedFrom;
    private List<AbstractBlock> children;

    @Getter @Setter @ToString
    private static class SyncedFrom {
        private String type;
        private String blockId;
    }

    private SyncedBlockBlock() {}
    private SyncedBlockBlock(SyncedFrom syncedFrom, List<AbstractBlock> children) {
        this.syncedFrom = syncedFrom;
        this.children = children;
    }

    public static SyncedBlockBlock from(SyncedFrom syncedFrom) {
        return new SyncedBlockBlock(syncedFrom, null);
    }
}
