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

@Getter @Setter @ToString
public class BulletedListItemBlock extends AbstractBlock {
    private final static BlockTypeEnum type = BlockTypeEnum.BULLETED_LIST_ITEM;
    private List<AbstractRichText> richText;
    private ColorEnum color;
    private List<AbstractBlock> children;

    private BulletedListItemBlock() {}

    public BulletedListItemBlock(List<AbstractRichText> richText, ColorEnum color) {
        this.richText = richText;
        this.color = color;
    }

    public static class Builder extends TextColorBuilder<Builder, BulletedListItemBlock> {
        public BulletedListItemBlock build() {
            return new BulletedListItemBlock(richText, color);
        }
    }
}
