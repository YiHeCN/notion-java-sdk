package com._2lazy2name.notion.entity.block.heading;

import com._2lazy2name.notion.entity.block.builder.impl.TextColorBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/block#heading-three-blocks">Heading Three Block</a>
 */
@Setter(AccessLevel.PRIVATE)
@Getter
public class HeadingThreeBlock extends AbstractHeadingBlock {
    private final BlockTypeEnum type = BlockTypeEnum.HEADING_3;
    @JsonProperty("heading_3")
    private Heading heading;

    private HeadingThreeBlock() {}

    private HeadingThreeBlock(List<AbstractRichText> text, ColorEnum color, Boolean isToggleable) {
        super(text, color, isToggleable);
    }

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

    public Heading getHeading() {
        return super.heading;
    }

}
