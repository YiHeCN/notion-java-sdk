package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.block.builder.impl.TextColorBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/block#paragraph-blocks">ParagraphBlock</a>
 */
@Setter @Getter @ToString
public class ParagraphBlock extends AbstractBlock {
    private final BlockTypeEnum type = BlockTypeEnum.PARAGRAPH;
    private Paragraph paragraph;

    @Getter @Setter @ToString
    private static class Paragraph {
        private List<AbstractRichText> richText;
        private ColorEnum color;
        private List<AbstractBlock> children;
    }

    private ParagraphBlock() {}
    private ParagraphBlock(List<AbstractRichText> richText, ColorEnum color) {
        this.paragraph = new Paragraph();
        this.paragraph.setRichText(richText);
        this.paragraph.setColor(color);
    }

    private static class Builder extends TextColorBuilder<Builder, ParagraphBlock> {
        public ParagraphBlock build() {
            return new ParagraphBlock(richText, color);
        }
    }
}
