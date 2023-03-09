package com._2lazy2name.notion.entity.block.heading;

import com._2lazy2name.notion.entity.block.builder.impl.TextColorBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.enumeration.ColorEnum;
import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/block#heading-one-blocks">Heading One Block</a>
 */
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
