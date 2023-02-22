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
 * @see <a href="https://developers.notion.com/reference/block#heading-one-blocks">Heading One Block</a>
 */
@Setter(AccessLevel.PRIVATE)
@Getter
public class HeadingOneBlock extends AbstractHeadingBlock {
    private final BlockTypeEnum type = BlockTypeEnum.HEADING_1;
    @JsonProperty("heading_1")
    private Heading heading;

    private HeadingOneBlock() {}

    private HeadingOneBlock(List<AbstractRichText> text, ColorEnum color, Boolean isToggleable) {
        super(text, color, isToggleable);
    }

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

    public Heading getHeading() {
        return super.heading;
    }

    private Heading setHeading(Heading heading) {
        return super.heading = heading;
    }

}
