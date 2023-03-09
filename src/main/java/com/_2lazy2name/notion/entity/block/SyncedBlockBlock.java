package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;

import java.util.List;

// TODO: test
public class SyncedBlockBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.SYNCED_BLOCK;
    private SyncedBlock syncedBlock;

    private static class SyncedBlock {
        private SyncedFrom syncedFrom;
        private List<AbstractBlock> children;
    }

    private static class SyncedFrom {
        private String type;
        private String blockId;
    }

    private SyncedBlockBlock() {}
    private SyncedBlockBlock(SyncedFrom syncedFrom, List<AbstractBlock> children) {

    }

    public static SyncedBlockBlock from(SyncedFrom syncedFrom) {
        return new SyncedBlockBlock(syncedFrom, null);
    }
}
