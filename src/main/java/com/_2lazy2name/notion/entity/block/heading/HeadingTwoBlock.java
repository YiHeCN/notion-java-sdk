package com._2lazy2name.notion.entity.block.heading;

import com._2lazy2name.notion.entity.block.builder.impl.TextColorBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;


public class HeadingTwoBlock extends AbstractHeadingBlock {
    private final BlockTypeEnum type = BlockTypeEnum.HEADING_2;

    public static class Builder extends TextColorBuilder<Builder, HeadingTwoBlock> {
        private Boolean isToggleable;

        public Builder isToggleable(Boolean isToggleable) {
            this.isToggleable = isToggleable;
            return this;
        }

        public HeadingTwoBlock build() {
            return new HeadingTwoBlock(richText, color, isToggleable);
        }
    }

    private HeadingTwoBlock() {}

    private HeadingTwoBlock(List<AbstractRichText> text, ColorEnum color, Boolean isToggleable) {
        super(text, color, isToggleable);
    }

    @Override
    @JsonProperty("heading_2")
    protected Heading getHeading() {
        return super.heading;
    }

    @Override
    protected void setHeading(Heading heading) {
        super.heading = heading;
    }

    public BlockTypeEnum getType() {
        return type;
    }
}
