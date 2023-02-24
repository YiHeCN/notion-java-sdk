package com._2lazy2name.notion.entity.block.heading;

import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author Chole
 * @since 1.0
 * @version 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Heading {
    private List<AbstractRichText> richText;
    private ColorEnum color;
    private Boolean isToggleable;

    Heading(List<AbstractRichText> richText, ColorEnum color, Boolean isToggleable) {
        this.richText = richText;
        this.color = color;
        this.isToggleable = isToggleable;
    }

    Heading() {}

    List<AbstractRichText> getRichText() {
        return richText;
    }

    Heading setRichText(List<AbstractRichText> richText) {
        this.richText = richText;
        return this;
    }

    ColorEnum getColor() {
        return color;
    }

    Heading setColor(ColorEnum color) {
        this.color = color;
        return this;
    }

    Boolean getToggleable() {
        return isToggleable;
    }

    Heading setToggleable(Boolean toggleable) {
        isToggleable = toggleable;
        return this;
    }
}
