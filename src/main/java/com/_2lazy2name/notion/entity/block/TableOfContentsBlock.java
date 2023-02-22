package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
public class TableOfContentsBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.TABLE_OF_CONTENTS;
    private ColorEnum color;

    private TableOfContentsBlock() {}

    private TableOfContentsBlock(ColorEnum color) {
        this.color = color;
    }

    public static TableOfContentsBlock ofColor(ColorEnum color) {
        return new TableOfContentsBlock(color);
    }

    public static TableOfContentsBlock ofRandomColor() {
        return new TableOfContentsBlock(ColorEnum.getRandomColor());
    }

    public static TableOfContentsBlock ofRandomBackground() {
        return new TableOfContentsBlock(ColorEnum.getRandomColorBackground());
    }
}
