package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ColumnBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.COLUMN;
    private Column column;

    public ColumnBlock(List<AbstractBlock> children) {
        this.column = new Column();
        this.column.children = children;
    }

    public ColumnBlock(AbstractBlock... children) {
        this(List.of(children));
    }

    public ColumnBlock(AbstractBlock child) {
        this(List.of(child));
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
