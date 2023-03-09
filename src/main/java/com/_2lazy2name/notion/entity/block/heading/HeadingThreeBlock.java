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
 * @see <a href="https://developers.notion.com/reference/block#heading-three-blocks">Heading Three Block</a>
 */
public class HeadingThreeBlock extends AbstractHeadingBlock {
    private final BlockTypeEnum type = BlockTypeEnum.HEADING_3;

    public static class Builder extends TextColorBuilder<Builder, HeadingThreeBlock> {
        private Boolean isToggleable;

        public Builder isToggleable(Boolean isToggleable) {
            this.isToggleable = isToggleable;
            return this;
        }

        public HeadingThreeBlock build() {
            return new HeadingThreeBlock(richText, color, isToggleable);
        }
    }


    private HeadingThreeBlock() {}

    private HeadingThreeBlock(List<AbstractRichText> text, ColorEnum color, Boolean isToggleable) {
        super(text, color, isToggleable);
    }

    @Override
    @JsonProperty("heading_3")
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
