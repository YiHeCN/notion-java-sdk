package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.block.builder.impl.TextColorBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.enumeration.ColorEnum;
import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/block#paragraph-blocks">ParagraphBlock</a>
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ParagraphBlock extends AbstractBlock {
    private final BlockTypeEnum type = BlockTypeEnum.PARAGRAPH;
    private Paragraph paragraph;

    public static class Builder extends TextColorBuilder<Builder, ParagraphBlock> {
        private List<AbstractBlock> children;

        public Builder children(List<AbstractBlock> children) {
            this.children = children;
            return this;
        }

        public ParagraphBlock build() {
            return new ParagraphBlock(richText, color, children);
        }
    }

    @JsonIgnore
    public List<AbstractRichText> getRichText() {
        return paragraph.getRichText();
    }

    public ParagraphBlock setRichText(List<AbstractRichText> richText) {
        this.paragraph.setRichText(richText);
        return this;
    }
    public ParagraphBlock setRichText(AbstractRichText richText) {
        return setRichText(List.of(richText));
    }
    public ParagraphBlock setRichText(String richText) {
        return setRichText(List.of(AbstractRichText.buildPlainText(richText)));
    }

    @JsonIgnore
    public ColorEnum getColor() {
        return paragraph.color;
    }

    public ParagraphBlock setColor(ColorEnum color) {
        this.paragraph.color = color;
        return this;
    }

    @JsonIgnore
    public List<AbstractBlock> getChildren() {
        return paragraph.children;
    }

    private List<AbstractBlock> setChildren(List<AbstractBlock> children) {
        paragraph.children = children;
        return children;
    }

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private ParagraphBlock() {}

    private ParagraphBlock(List<AbstractRichText> richText, ColorEnum color, List<AbstractBlock> children) {
        this.paragraph = new Paragraph();
        this.paragraph.richText = richText;
        this.paragraph.color = color;
        this.paragraph.children = children;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class Paragraph {
        private List<AbstractRichText> richText;
        private ColorEnum color;
        private List<AbstractBlock> children;

        private List<AbstractRichText> getRichText() {
            return richText;
        }

        private Paragraph setRichText(List<AbstractRichText> richText) {
            this.richText = richText;
            return this;
        }

        private ColorEnum getColor() {
            return color;
        }

        private Paragraph setColor(ColorEnum color) {
            this.color = color;
            return this;
        }

        private List<AbstractBlock> getChildren() {
            return children;
        }

        private Paragraph setChildren(List<AbstractBlock> children) {
            this.children = children;
            return this;
        }
    }

    public Paragraph getParagraph() {
        return paragraph;
    }

    public ParagraphBlock setParagraph(Paragraph paragraph) {
        this.paragraph = paragraph;
        return this;
    }
}
