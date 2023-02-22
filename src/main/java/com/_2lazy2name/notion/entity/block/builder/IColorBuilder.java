package com._2lazy2name.notion.entity.block.builder;

import com._2lazy2name.notion.entity.enumeration.ColorEnum;

public interface IColorBuilder<S extends IColorBuilder<S, T>, T> {
    S color(ColorEnum color);
    S randomColor();
    S randomColorBackground();
    T build();
}
