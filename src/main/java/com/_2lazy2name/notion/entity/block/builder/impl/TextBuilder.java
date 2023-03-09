package com._2lazy2name.notion.entity.block.builder.impl;

import com._2lazy2name.notion.entity.block.builder.IRichTextBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.common.richText.TextText;

import java.util.List;


/**
 * For block contains editable text property.
 * @author Chole
 * @since 1.0
 * @version 1.0
 */
public abstract class TextBuilder<S extends TextBuilder<S, T>, T>
        implements IRichTextBuilder<S, T>
{
    protected List<AbstractRichText> richText;

    public TextBuilder() {
        super();
    }

    @Override
    public S richText(String richText) {
        this.richText = List.of(new TextText(richText));
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
