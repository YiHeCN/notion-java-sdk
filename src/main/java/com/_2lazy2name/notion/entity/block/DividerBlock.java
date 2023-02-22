package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com._2lazy2name.notion.entity.property.NullToEmptyObjectSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
public class DividerBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.DIVIDER;
    @JsonSerialize(nullsUsing = NullToEmptyObjectSerializer.class)
    private Object divider = null;
    private static final DividerBlock INSTANCE = new DividerBlock();

    private DividerBlock() {}

    public static DividerBlock getInstance() {
        return INSTANCE;
    }

}
