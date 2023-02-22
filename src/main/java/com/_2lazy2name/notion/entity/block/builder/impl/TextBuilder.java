package com._2lazy2name.notion.entity.block.builder.impl;

import com._2lazy2name.notion.entity.block.builder.IRichTextBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;

import java.util.List;

public abstract class TextBuilder<S extends TextBuilder<S, T>, T>
        implements IRichTextBuilder<S, T>
{
    protected List<AbstractRichText> richText;

    public TextBuilder() {
        super();
    }

    @Override
    public S richText(String richText) {
        this.richText = List.of(AbstractRichText.buildPlainText(richText));
        return self();
    }

    @Override
    public S richText(List<AbstractRichText> richText) {
        this.richText = richText;
        return self();
    }


    public abstract T build();

    @SuppressWarnings("unchecked")
    private S self() {
        return (S) this;
    }

}
