package com._2lazy2name.notion.entity.block.heading;

import com._2lazy2name.notion.entity.block.builder.impl.TextColorBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/block#heading-two-blocks">Heading Two Block</a>
 */
@Setter(AccessLevel.PRIVATE)
@Getter
public class HeadingTwoBlock extends AbstractHeadingBlock {
    private final BlockTypeEnum type = BlockTypeEnum.HEADING_2;
    @JsonProperty("heading_2")
    private Heading heading;

    private HeadingTwoBlock() {}

    private HeadingTwoBlock(List<AbstractRichText> text, ColorEnum color, Boolean isToggleable) {
        super(text, color, isToggleable);
    }

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

    public Heading getHeading() {
        return super.heading;
    }
}
