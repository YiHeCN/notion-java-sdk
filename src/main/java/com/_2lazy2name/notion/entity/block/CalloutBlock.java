package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.block.builder.impl.TextColorBuilder;
import com._2lazy2name.notion.entity.common.icon.AbstractIcon;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString @Getter @Setter
public class CalloutBlock extends AbstractBlock {
    private final static BlockTypeEnum type = BlockTypeEnum.CALLOUT;
    private AbstractIcon icon;
    private ColorEnum color;
    private List<AbstractRichText> richText;
    private List<AbstractBlock> children;

    private CalloutBlock() {}

    private CalloutBlock(List<AbstractRichText> richText, ColorEnum color, AbstractIcon icon) {
        this.icon = icon;
        this.color = color;
        this.richText = richText;

    }

    public static class Builder extends TextColorBuilder<Builder, CalloutBlock> {
        private AbstractIcon icon;

        public Builder icon(AbstractIcon icon) {
            this.icon = icon;
            return this;
        }

        public CalloutBlock build() {
            return new CalloutBlock(richText, color, icon);
        }
    }


}
