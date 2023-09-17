package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;

import java.util.List;

// TODO: not supported yet
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

    public SyncedBlockBlock(String syncedFromId) {
        this.syncedBlock = new SyncedBlock();
        this.syncedBlock.syncedFrom = new SyncedFrom();
        this.syncedBlock.syncedFrom.type = "block_id";
        this.syncedBlock.syncedFrom.blockId = syncedFromId;
    }
}
