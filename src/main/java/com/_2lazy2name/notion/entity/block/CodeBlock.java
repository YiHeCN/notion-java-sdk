package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.block.builder.impl.TextBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.common.richText.TextText;
import com._2lazy2name.notion.enumeration.LanguageEnum;
import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CodeBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.CODE;
    private Code code;

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
            this.caption = List.of(new TextText(caption));
            return this;
        }

        public CodeBlock build() {
            return new CodeBlock(language, richText, caption);
        }
    }

    @JsonIgnore
    public LanguageEnum getLanguage() {
        return this.code.language;
    }
    public CodeBlock setLanguage(LanguageEnum language) {
        this.code.language = language;
        return this;
    }

    @JsonIgnore
    public List<AbstractRichText> getRichText() {
        return this.code.richText;
    }
    public CodeBlock setRichText(List<AbstractRichText> richText) {
        this.code.richText = richText;
        return this;
    }
    public CodeBlock setRichText(AbstractRichText richText) {
        this.code.richText = List.of(richText);
        return this;
    }
    public CodeBlock setRichText(String text) {
        this.code.richText = List.of(new TextText(text));
        return this;
    }

    @JsonIgnore
    public List<AbstractRichText> getCaption() {
        return this.code.caption;
    }
    public CodeBlock setCaption(List<AbstractRichText> caption) {
        this.code.caption = caption;
        return this;
    }


    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private CodeBlock() {}

    private CodeBlock(LanguageEnum language, List<AbstractRichText> richText, List<AbstractRichText> caption) {
        this.code = new Code();
        this.code.language = language;
        this.code.richText = richText;
        this.code.caption = caption;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class Code {
        private LanguageEnum language;
        private List<AbstractRichText> caption;
        private List<AbstractRichText> richText;

        private LanguageEnum getLanguage() {
            return language;
        }

        private Code setLanguage(LanguageEnum language) {
            this.language = language;
            return this;
        }

        private List<AbstractRichText> getCaption() {
            return caption;
        }

        private Code setCaption(List<AbstractRichText> caption) {
            this.caption = caption;
            return this;
        }

        private List<AbstractRichText> getRichText() {
            return richText;
        }

        private Code setRichText(List<AbstractRichText> richText) {
            this.richText = richText;
            return this;
        }
    }

    private Code getCode() {
        return code;
    }

    private CodeBlock setCode(Code code) {
        this.code = code;
        return this;
    }


}
