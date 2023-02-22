package com._2lazy2name.notion.entity.block.heading;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = HeadingOneBlock.class, name = "heading_1"),
        @JsonSubTypes.Type(value = HeadingTwoBlock.class, name = "heading_2"),
        @JsonSubTypes.Type(value = HeadingThreeBlock.class, name = "heading_3")
})
@Setter(AccessLevel.PRIVATE)
@Getter
@ToString
public abstract class AbstractHeadingBlock extends AbstractBlock {
    protected List<AbstractBlock> children;
    @JsonProperty(namespace = "heading_1")
    protected Heading heading;

    protected AbstractHeadingBlock() {}

    protected AbstractHeadingBlock(List<AbstractRichText> text, ColorEnum color, Boolean isToggleable) {
        this.heading = new Heading(text, color, isToggleable);
    }


    public List<AbstractRichText> updateText(List<AbstractRichText> text) {
        List<AbstractRichText> oldText = this.heading.getRichText();
        this.heading.setRichText(text);
        return oldText;
    }

    public List<AbstractRichText> updateText(String text) {
        List<AbstractRichText> oldText = this.heading.getRichText();
        this.heading.setRichText(List.of(AbstractRichText.buildPlainText(text)));
        return oldText;
    }

    public ColorEnum updateColor(ColorEnum color) {
        ColorEnum oldColor = this.heading.getColor();
        this.heading.setColor(color);
        return oldColor;
    }
}
