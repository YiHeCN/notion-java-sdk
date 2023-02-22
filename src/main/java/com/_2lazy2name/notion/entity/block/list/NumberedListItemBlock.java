package com._2lazy2name.notion.entity.block.list;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.block.builder.impl.TextColorBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class NumberedListItemBlock extends AbstractBlock {
    private final static BlockTypeEnum type = BlockTypeEnum.NUMBERED_LIST_ITEM;
    private NumberedListItem numberedListItem;

    public static class Builder extends TextColorBuilder<Builder, NumberedListItemBlock> {
        public NumberedListItemBlock build() {
            return new NumberedListItemBlock(richText, color);
        }
    }

    @JsonIgnore
    public List<AbstractRichText> getRichText() {
        return this.numberedListItem.richText;
    }

    public NumberedListItemBlock setRichText(List<AbstractRichText> richText) {
        this.numberedListItem.richText = richText;
        return this;
    }
    public NumberedListItemBlock setRichText(AbstractRichText richText) {
        this.numberedListItem.richText = List.of(richText);
        return this;
    }
    public NumberedListItemBlock setRichText(String text) {
        this.numberedListItem.richText = List.of(AbstractRichText.buildPlainText(text));
        return this;
    }

    @JsonIgnore
    public ColorEnum getColor() {
        return this.numberedListItem.color;
    }

    public NumberedListItemBlock setColor(ColorEnum color) {
        this.numberedListItem.color = color;
        return this;
    }

    @JsonIgnore
    public List<AbstractBlock> getChildren() {
        return this.numberedListItem.children;
    }

    private NumberedListItemBlock setChildren(List<AbstractBlock> children) {
        this.numberedListItem.children = children;
        return this;
    }

    public BlockTypeEnum getType() {
        return type;
    }

    private NumberedListItemBlock() {}

    private NumberedListItemBlock(List<AbstractRichText> richText, ColorEnum color) {
        this.numberedListItem = new NumberedListItem();
        this.numberedListItem.richText = richText;
        this.numberedListItem.color = color;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class NumberedListItem {
        private List<AbstractRichText> richText;
        private ColorEnum color;
        private List<AbstractBlock> children;

        private List<AbstractRichText> getRichText() {
            return richText;
        }

        private NumberedListItem setRichText(List<AbstractRichText> richText) {
            this.richText = richText;
            return this;
        }

        private ColorEnum getColor() {
            return color;
        }

        private NumberedListItem setColor(ColorEnum color) {
            this.color = color;
            return this;
        }

        private List<AbstractBlock> getChildren() {
            return children;
        }

        private NumberedListItem setChildren(List<AbstractBlock> children) {
            this.children = children;
            return this;
        }
    }

    private NumberedListItem getNumberedListItem() {
        return numberedListItem;
    }

    private NumberedListItemBlock setNumberedListItem(NumberedListItem numberedListItem) {
        this.numberedListItem = numberedListItem;
        return this;
    }
}
