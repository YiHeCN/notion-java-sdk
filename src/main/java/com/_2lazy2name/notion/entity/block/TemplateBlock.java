package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.block.builder.impl.TextBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class TemplateBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.TEMPLATE;
    private List<AbstractRichText> richText;
    private List<AbstractBlock> children;

    private TemplateBlock() {}
    private TemplateBlock(List<AbstractRichText> richText) {
        this.richText = richText;
    }

    public static class Builder extends TextBuilder<Builder, TemplateBlock> {
        public TemplateBlock build() {
            return new TemplateBlock(richText);
        }
    }
}
