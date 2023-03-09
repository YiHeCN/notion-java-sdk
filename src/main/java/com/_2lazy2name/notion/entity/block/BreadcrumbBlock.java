package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com._2lazy2name.notion.property.NullToEmptyObjectSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class BreadcrumbBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.BREADCRUMB;
    @JsonSerialize(nullsUsing = NullToEmptyObjectSerializer.class)
    private final Object breadcrumb = null;
    private static final BreadcrumbBlock INSTANCE = new BreadcrumbBlock();

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private BreadcrumbBlock() {}

    @JsonIgnore
    public static BreadcrumbBlock getInstance() {
        return INSTANCE;
    }
}
