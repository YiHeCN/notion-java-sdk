package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class ChildPageBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.CHILD_PAGE;
    private List<AbstractRichText> title;

    private ChildPageBlock() {}

    private ChildPageBlock(List<AbstractRichText> title) {
        this.title = title;
    }

    public static ChildPageBlock ofTitle(List<AbstractRichText> title) {
        return new ChildPageBlock(title);
    }

    public static ChildPageBlock ofTitle(String title) {
        return new ChildPageBlock(List.of(AbstractRichText.buildPlainText(title)));
    }
}
