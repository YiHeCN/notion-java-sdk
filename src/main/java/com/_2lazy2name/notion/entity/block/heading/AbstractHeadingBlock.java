package com._2lazy2name.notion.entity.block.heading;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.ToString;

import java.util.List;

/**
 * @author Chole
 * @since 1.0
 * @version 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = HeadingOneBlock.class, name = "heading_1"),
        @JsonSubTypes.Type(value = HeadingTwoBlock.class, name = "heading_2"),
        @JsonSubTypes.Type(value = HeadingThreeBlock.class, name = "heading_3")
})
public abstract class AbstractHeadingBlock extends AbstractBlock {
    protected List<AbstractBlock> children;
    protected Heading heading;

    protected AbstractHeadingBlock() {}

    protected AbstractHeadingBlock(List<AbstractRichText> text, ColorEnum color, Boolean isToggleable) {
        this.heading = new Heading(text, color, isToggleable);
    }

    public List<AbstractBlock> getChildren() {
        return children;
    }

    private AbstractHeadingBlock setChildren(List<AbstractBlock> children) {
        this.children = children;
        return this;
    }

    @JsonIgnore
    public List<AbstractRichText> getText() {
        return heading.getRichText();
    }

    public AbstractHeadingBlock setRichText(List<AbstractRichText> text) {
        heading.setRichText(text);
        return this;
    }
    public AbstractHeadingBlock setRichText(AbstractRichText text) {
        heading.setRichText(List.of(text));
        return this;
    }
    public AbstractHeadingBlock setRichText(String text) {
        heading.setRichText(List.of(AbstractRichText.buildPlainText(text)));
        return this;
    }

    @JsonIgnore
    public ColorEnum getColor() {
        return heading.getColor();
    }

    public AbstractHeadingBlock setColor(ColorEnum color) {
        heading.setColor(color);
        return this;
    }

    @JsonIgnore
    public Boolean isToggleable() {
        return heading.getToggleable();
    }

    public AbstractHeadingBlock setToggleable(Boolean toggleable) {
        heading.setToggleable(toggleable);
        return this;
    }

    protected Heading getHeading() {
        return this.heading;
    }
    protected void setHeading(Heading heading) {
        this.heading = heading;
    }
}
