package com._2lazy2name.notion.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ColorEnum {
    BLUE("blue"),
    BROWN("brown"),
    GRAY("gray"),
    GREEN("green"),
    ORANGE("orange"),
    PINK("pink"),
    PURPLE("purple"),
    RED("red"),
    YELLOW("yellow"),
    BLUE_BACKGROUND("blue_background"),
    BROWN_BACKGROUND("brown_background"),
    GRAY_BACKGROUND("gray_background"),
    GREEN_BACKGROUND("green_background"),
    ORANGE_BACKGROUND("orange_background"),
    PINK_BACKGROUND("pink_background"),
    PURPLE_BACKGROUND("purple_background"),
    RED_BACKGROUND("red_background"),
    YELLOW_BACKGROUND("yellow_background"),
    DEFAULT("default");

    final String color;

    @JsonCreator
    ColorEnum(String color) {
        this.color = color;
    }

    @Override
    @JsonValue
    public String toString() {
        return color;
    }

    public static ColorEnum getRandomColor() {
        return values()[(int) (Math.random() * 9)];
    }

    public static ColorEnum getRandomColorBackground() {
        return values()[(int) (Math.random() * 9) + 9];
    }

}
