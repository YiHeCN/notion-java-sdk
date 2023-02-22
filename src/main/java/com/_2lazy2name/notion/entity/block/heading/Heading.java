package com._2lazy2name.notion.entity.block.heading;

import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter(AccessLevel.MODULE)
@Getter
@ToString
class Heading {
    private List<AbstractRichText> richText;
    private ColorEnum color;
    private Boolean isToggleable;

    public Heading(List<AbstractRichText> richText, ColorEnum color, Boolean isToggleable) {
        this.richText = richText;
        this.color = color;
        this.isToggleable = isToggleable;
    }

    private Heading() {}
}
