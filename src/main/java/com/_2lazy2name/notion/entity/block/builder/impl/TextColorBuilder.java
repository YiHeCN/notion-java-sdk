package com._2lazy2name.notion.entity.block.builder.impl;

import com._2lazy2name.notion.entity.block.builder.IColorBuilder;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;

public abstract class TextColorBuilder<S extends TextColorBuilder<S, T>, T>
        extends TextBuilder<S, T>
        implements IColorBuilder<S, T> {
    protected ColorEnum color;

    public TextColorBuilder() {
        super();
    }

    @Override
    public S color(ColorEnum color) {
        this.color = color;
        return self();
    }

    @Override
    public S randomColor() {
        this.color = ColorEnum.getRandomColor();
        return self();
    }

    @Override
    public S randomColorBackground() {
        this.color = ColorEnum.getRandomColorBackground();
        return self();
    }

    public abstract T build();

    @SuppressWarnings("unchecked")
    private S self() {
        return (S) this;
    }
}
