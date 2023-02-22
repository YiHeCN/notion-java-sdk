package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.block.builder.impl.TextBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class QuoteBlock extends AbstractBlock {
    private final static BlockTypeEnum type = BlockTypeEnum.QUOTE;
    private List<AbstractRichText> richText;
    private List<AbstractBlock> children;

    private QuoteBlock() {}
    private QuoteBlock(List<AbstractRichText> richText) {
        this.richText = richText;
    }

    public static class Builder extends TextBuilder<Builder, QuoteBlock> {
        public QuoteBlock build() {
            return new QuoteBlock(richText);
        }
    }
}
