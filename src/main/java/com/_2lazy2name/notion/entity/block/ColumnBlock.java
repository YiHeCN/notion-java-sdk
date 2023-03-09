package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ColumnBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.COLUMN;
    private Column column;

    public static ColumnBlock ofChildren(List<AbstractBlock> children) {
        ColumnBlock columnBlock = new ColumnBlock();
        columnBlock.column = new Column();
        columnBlock.column.children = children;
        return columnBlock;
    }

    public static ColumnBlock ofChildren(AbstractBlock... children) {
        return ofChildren(List.of(children));
    }

    public static ColumnBlock ofChild(AbstractBlock child) {
        return ofChildren(List.of(child));
    }

    @JsonIgnore
    public List<AbstractBlock> getChildren() {
        return this.column.children;
    }

    public ColumnBlock setChildren(List<AbstractBlock> children) {
        if (this.column == null) {
            this.column = new Column();
        }
        this.column.children = children;
        return this;
    }
    public ColumnBlock appendChildren(AbstractBlock... children) {
        if (this.column == null) {
            this.column = new Column();
        }
        if (this.column.children == null) {
            this.column.children = List.of();
        }
        this.column.children.addAll(List.of(children));
        return this;
    }
    public ColumnBlock appendChild(AbstractBlock child) {
        return appendChildren(child);
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class Column {
        private List<AbstractBlock> children;

        private List<AbstractBlock> getChildren() {
            return children;
        }

        private Column setChildren(List<AbstractBlock> children) {
            this.children = children;
            return this;
        }
    }

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private ColumnBlock() {}

    private Column getColumn() {
        return column;
    }

    private ColumnBlock setColumn(Column column) {
        this.column = column;
        return this;
    }
}
