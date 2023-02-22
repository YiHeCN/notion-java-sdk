package com._2lazy2name.notion.entity.block.heading;

import com._2lazy2name.notion.entity.block.builder.impl.TextColorBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HeadingOneBlock extends AbstractHeadingBlock {
    private final BlockTypeEnum type = BlockTypeEnum.HEADING_1;

    public static class Builder extends TextColorBuilder<Builder, HeadingOneBlock> {
        private Boolean isToggleable;

        public Builder isToggleable(Boolean isToggleable) {
            this.isToggleable = isToggleable;
            return this;
        }

        public HeadingOneBlock build() {
            return new HeadingOneBlock(richText, color, isToggleable);
        }
    }

    private HeadingOneBlock() {}

    private HeadingOneBlock(List<AbstractRichText> text, ColorEnum color, Boolean isToggleable) {
        super(text, color, isToggleable);
    }

    @Override
    @JsonProperty("heading_1")
    protected Heading getHeading() {
        return super.heading;
    }

    @Override
    protected void setHeading(Heading heading) {
        super.setHeading(heading);
    }

    public BlockTypeEnum getType() {
        return type;
    }
}
