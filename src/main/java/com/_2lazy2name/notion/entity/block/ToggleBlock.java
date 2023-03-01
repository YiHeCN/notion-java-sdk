package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.block.builder.impl.TextColorBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class ToggleBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.TOGGLE;
    private Toggle toggle;

    public static class Builder extends TextColorBuilder<Builder, ToggleBlock> {
        public ToggleBlock build() {
            return new ToggleBlock(richText, color);
        }
    }

    @JsonIgnore
    public List<AbstractRichText> getRichText() {
        return this.toggle.richText;
    }

    public ToggleBlock setRichText(List<AbstractRichText> richText) {
        this.toggle.richText = richText;
        return this;
    }

    @JsonIgnore
    public ColorEnum getColor() {
        return this.toggle.color;
    }

    public ToggleBlock setColor(ColorEnum color) {
        this.toggle.color = color;
        return this;
    }

    @JsonIgnore
    public List<AbstractBlock> getChildren() {
        return this.toggle.children;
    }

    private ToggleBlock setChildren(List<AbstractBlock> children) {
        this.toggle.children = children;
        return this;
    }

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private ToggleBlock() {}

    private ToggleBlock(List<AbstractRichText> richText, ColorEnum color) {
        this.toggle = new Toggle();
        this.toggle.richText = richText;
        this.toggle.color = color;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class Toggle {
        private List<AbstractBlock> children;
        private List<AbstractRichText> richText;
        private ColorEnum color;

        public List<AbstractBlock> getChildren() {
            return children;
        }

        public Toggle setChildren(List<AbstractBlock> children) {
            this.children = children;
            return this;
        }

        public List<AbstractRichText> getRichText() {
            return richText;
        }

        public Toggle setRichText(List<AbstractRichText> richText) {
            this.richText = richText;
            return this;
        }

        public ColorEnum getColor() {
            return color;
        }

        public Toggle setColor(ColorEnum color) {
            this.color = color;
            return this;
        }
    }

    public Toggle getToggle() {
        return toggle;
    }

    public ToggleBlock setToggle(Toggle toggle) {
        this.toggle = toggle;
        return this;
    }
}
