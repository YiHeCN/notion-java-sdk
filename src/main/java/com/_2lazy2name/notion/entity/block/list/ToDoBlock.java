package com._2lazy2name.notion.entity.block.list;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.block.builder.impl.TextColorBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class ToDoBlock extends AbstractBlock {
    private final static BlockTypeEnum type = BlockTypeEnum.TO_DO;
    private List<AbstractRichText> richText;
    private ColorEnum color;
    private Boolean checked;
    private List<AbstractBlock> children;

    private ToDoBlock() {}

    public ToDoBlock(List<AbstractRichText> richText, ColorEnum color, Boolean checked) {
        this.richText = richText;
        this.color = color;
        this.checked = checked;
    }

    public static class Builder extends TextColorBuilder<Builder, ToDoBlock> {
        private Boolean checked;

        public Builder checked(Boolean checked) {
            this.checked = checked;
            return this;
        }

        public ToDoBlock build() {
            return new ToDoBlock(richText, color, checked);
        }
    }
}
