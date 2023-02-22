package com._2lazy2name.notion.entity.block.builder;

import com._2lazy2name.notion.entity.common.richText.AbstractRichText;

import java.util.List;

public interface IRichTextBuilder<S extends IRichTextBuilder<S, T>, T> {
    S text(String text);
    S text(List<AbstractRichText> text);
    T build();
}
