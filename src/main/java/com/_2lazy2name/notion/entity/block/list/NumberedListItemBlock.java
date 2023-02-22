package com._2lazy2name.notion.entity.block.list;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.block.builder.impl.TextColorBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString @Getter @Setter
public class NumberedListItemBlock extends AbstractBlock {
    private final static BlockTypeEnum type = BlockTypeEnum.NUMBERED_LIST_ITEM;
    private List<AbstractRichText> richText;
    private ColorEnum color;
    private List<AbstractBlock> children;

    private NumberedListItemBlock() {}

    public NumberedListItemBlock(List<AbstractRichText> richText, ColorEnum color) {
        this.richText = richText;
        this.color = color;
    }

    public static class Builder extends TextColorBuilder<Builder, NumberedListItemBlock> {
        public NumberedListItemBlock build() {
            return new NumberedListItemBlock(richText, color);
        }
    }
}
