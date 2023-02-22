package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.block.builder.impl.TextBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.LanguageEnum;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString @Getter @Setter
public class CodeBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.CODE;
    private LanguageEnum language;
    private List<AbstractRichText> richText;
    private List<AbstractRichText> caption;

    private CodeBlock() {}

    private CodeBlock(LanguageEnum language, List<AbstractRichText> richText, List<AbstractRichText> caption) {
        this.language = language;
        this.richText = richText;
        this.caption = caption;
    }


    public static class Builder extends TextBuilder<Builder, CodeBlock> {
        private LanguageEnum language;
        private List<AbstractRichText> caption;

        public Builder language(LanguageEnum language) {
            this.language = language;
            return this;
        }

        public Builder caption(List<AbstractRichText> caption) {
            this.caption = caption;
            return this;
        }

        public Builder caption(String caption) {
            this.caption = List.of(AbstractRichText.buildPlainText(caption));
            return this;
        }

        public CodeBlock build() {
            return new CodeBlock(language, richText, caption);
        }
    }


}
