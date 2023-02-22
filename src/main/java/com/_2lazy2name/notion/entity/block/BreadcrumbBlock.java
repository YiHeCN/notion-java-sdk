package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com._2lazy2name.notion.entity.property.NullToEmptyObjectSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
public class BreadcrumbBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.BREADCRUMB;
    @JsonSerialize(nullsUsing = NullToEmptyObjectSerializer.class)
    private Object breadcrumb = null;
    private static BreadcrumbBlock INSTANCE = new BreadcrumbBlock();

    private BreadcrumbBlock() {}

    public static BreadcrumbBlock getInstance() {
        return INSTANCE;
    }
}
