package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TableOfContentsBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.TABLE_OF_CONTENTS;
    private TableOfContents tableOfContents;

    public static TableOfContentsBlock ofColor(ColorEnum color) {
        return new TableOfContentsBlock(color);
    }

    @JsonIgnore
    public ColorEnum getColor() {
        return this.tableOfContents.color;
    }

    public TableOfContentsBlock setColor(ColorEnum color) {
        this.tableOfContents.color = color;
        return this;
    }

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private TableOfContentsBlock() {}

    private TableOfContentsBlock(ColorEnum color) {
        this.tableOfContents = new TableOfContents();
        this.tableOfContents.color = color;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class TableOfContents {
        private ColorEnum color;

        public ColorEnum getColor() {
            return color;
        }

        public TableOfContents setColor(ColorEnum color) {
            this.color = color;
            return this;
        }
    }

    public TableOfContents getTableOfContents() {
        return tableOfContents;
    }

    public TableOfContentsBlock setTableOfContents(TableOfContents tableOfContents) {
        this.tableOfContents = tableOfContents;
        return this;
    }
}
