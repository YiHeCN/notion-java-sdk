package com._2lazy2name.notion.entity.common.parent;

import com._2lazy2name.notion.enumeration.type.ParentTypeEnum;

public class BlockParent extends AbstractParent {
    private final ParentTypeEnum type = ParentTypeEnum.BLOCK_ID;
    private String blockId;

    private BlockParent() {
    }

    public BlockParent(String blockId) {
        this.blockId = blockId;
    }

    @Override
    public ParentTypeEnum getType() {
        return this.type;
    }

    public String getBlockId() {
        return blockId;
    }

    public BlockParent setBlockId(String blockId) {
        this.blockId = blockId;
        return this;
    }
}
