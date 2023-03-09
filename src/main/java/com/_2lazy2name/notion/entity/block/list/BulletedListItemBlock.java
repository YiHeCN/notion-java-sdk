package com._2lazy2name.notion.entity.block.list;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.block.builder.impl.TextColorBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.common.richText.TextText;
import com._2lazy2name.notion.enumeration.ColorEnum;
import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author Chole
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/block#bulleted-list-item-blocks">Bulleted List Item Block</a>
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BulletedListItemBlock extends AbstractBlock {
    private final static BlockTypeEnum type = BlockTypeEnum.BULLETED_LIST_ITEM;
    private BulletedListItem bulletedListItem;

    public static class Builder extends TextColorBuilder<Builder, BulletedListItemBlock> {
        public BulletedListItemBlock build() {
            return new BulletedListItemBlock(richText, color);
        }
    }

    @JsonIgnore
    public List<AbstractRichText> getRichText() {
        return this.bulletedListItem.richText;
    }

    public BulletedListItemBlock setRichText(List<AbstractRichText> richText) {
        this.bulletedListItem.richText = richText;
        return this;
    }
    public BulletedListItemBlock setRichText(AbstractRichText richText) {
        this.bulletedListItem.richText = List.of(richText);
        return this;
    }
    public BulletedListItemBlock setRichText(String text) {
        this.bulletedListItem.richText = List.of(new TextText(text));
        return this;
    }

    @JsonIgnore
    public ColorEnum getColor() {
        return this.bulletedListItem.color;
    }

    public BulletedListItemBlock setColor(ColorEnum color) {
        this.bulletedListItem.color = color;
        return this;
    }

    @JsonIgnore
    public List<AbstractBlock> getChildren() {
        return this.bulletedListItem.children;
    }

    private BulletedListItemBlock setChildren(List<AbstractBlock> children) {
        this.bulletedListItem.children = children;
        return this;
    }

    public BlockTypeEnum getType() {
        return type;
    }


    private BulletedListItemBlock() {}

    private BulletedListItemBlock(List<AbstractRichText> richText, ColorEnum color) {
        this.bulletedListItem = new BulletedListItem();
        this.bulletedListItem.richText = richText;
        this.bulletedListItem.color = color;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class BulletedListItem {
        private List<AbstractRichText> richText;
        private ColorEnum color;
        private List<AbstractBlock> children;

        private List<AbstractRichText> getRichText() {
            return richText;
        }

        private BulletedListItem setRichText(List<AbstractRichText> richText) {
            this.richText = richText;
            return this;
        }

        private ColorEnum getColor() {
            return color;
        }

        private BulletedListItem setColor(ColorEnum color) {
            this.color = color;
            return this;
        }

        private List<AbstractBlock> getChildren() {
            return children;
        }

        private BulletedListItem setChildren(List<AbstractBlock> children) {
            this.children = children;
            return this;
        }
    }

    private BulletedListItem getBulletedListItem() {
        return bulletedListItem;
    }

    private BulletedListItemBlock setBulletedListItem(BulletedListItem bulletedListItem) {
        this.bulletedListItem = bulletedListItem;
        return this;
    }
}
