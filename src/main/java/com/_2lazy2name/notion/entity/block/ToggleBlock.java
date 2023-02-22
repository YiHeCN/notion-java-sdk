package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.block.builder.impl.TextColorBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class ToggleBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.TOGGLE;
    private List<AbstractRichText> richText;
    private ColorEnum color;
    private List<AbstractBlock> children;

    private ToggleBlock() {}

    private ToggleBlock(List<AbstractRichText> richText, ColorEnum color) {
        this.richText = richText;
        this.color = color;
    }

    public static class Builder extends TextColorBuilder<Builder, ToggleBlock> {
        public ToggleBlock build() {
            return new ToggleBlock(richText, color);
        }
    }
}
