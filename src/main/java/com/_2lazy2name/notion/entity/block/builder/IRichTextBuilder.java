package com._2lazy2name.notion.entity.block.builder;

import com._2lazy2name.notion.entity.common.richText.AbstractRichText;

import java.util.List;

public interface IRichTextBuilder<S extends IRichTextBuilder<S, T>, T> {
    S richText(String text);
    S richText(List<AbstractRichText> text);
    T build();
}
