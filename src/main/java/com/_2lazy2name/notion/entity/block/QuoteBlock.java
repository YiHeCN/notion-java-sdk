package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.block.builder.impl.TextBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class QuoteBlock extends AbstractBlock {
    private final static BlockTypeEnum type = BlockTypeEnum.QUOTE;
    private Quote quote;

    public static class Builder extends TextBuilder<Builder, QuoteBlock> {
        private List<AbstractBlock> children;

        public Builder children(List<AbstractBlock> children) {
            this.children = children;
            return this;
        }

        public QuoteBlock build() {
            return new QuoteBlock(richText, children);
        }
    }

    @JsonIgnore
    public List<AbstractRichText> getRichText() {
        return this.quote.richText;
    }

    public QuoteBlock setRichText(List<AbstractRichText> richText) {
        this.quote.richText = richText;
        return this;
    }
    public QuoteBlock setRichText(AbstractRichText richText) {
        this.quote.richText = List.of(richText);
        return this;
    }
    public QuoteBlock setRichText(String richText) {
        this.quote.richText = List.of(AbstractRichText.buildPlainText(richText));
        return this;
    }

    @JsonIgnore
    public List<AbstractBlock> getChildren() {
        return this.quote.children;
    }

    private QuoteBlock setChildren(List<AbstractBlock> children) {
        this.quote.children = children;
        return this;
    }

    private QuoteBlock() {}

    private QuoteBlock(List<AbstractRichText> richText, List<AbstractBlock> children) {
        this.quote = new Quote();
        this.quote.richText = richText;
        this.quote.children = children;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class Quote {
        private List<AbstractRichText> richText;
        private List<AbstractBlock> children;

        public List<AbstractRichText> getRichText() {
            return richText;
        }

        public Quote setRichText(List<AbstractRichText> richText) {
            this.richText = richText;
            return this;
        }

        public List<AbstractBlock> getChildren() {
            return children;
        }

        public Quote setChildren(List<AbstractBlock> children) {
            this.children = children;
            return this;
        }
    }

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    public Quote getQuote() {
        return quote;
    }

    public QuoteBlock setQuote(Quote quote) {
        this.quote = quote;
        return this;
    }
}
