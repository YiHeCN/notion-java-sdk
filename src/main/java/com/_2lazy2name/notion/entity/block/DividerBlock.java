package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com._2lazy2name.notion.serializer.NullToEmptyObjectSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class DividerBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.DIVIDER;
    @JsonSerialize(nullsUsing = NullToEmptyObjectSerializer.class)
    private Object divider = null;
    private static final DividerBlock INSTANCE = new DividerBlock();

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private DividerBlock() {}

    public static DividerBlock getInstance() {
        return INSTANCE;
    }

    private Object getDivider() {
        return divider;
    }

    private DividerBlock setDivider(Object divider) {
        this.divider = divider;
        return this;
    }
}
