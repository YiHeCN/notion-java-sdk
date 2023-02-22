package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class ColumnListBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.COLUMN_LIST;
    private List<Column> column;

    @Getter @Setter @ToString
    private static class Column extends AbstractBlock {
        private static final BlockTypeEnum type = BlockTypeEnum.COLUMN;
        private List<AbstractBlock> children;
    }

    private ColumnListBlock() {}

    private ColumnListBlock(List<Column> column) {
        this.column = column;
    }

    public static ColumnListBlock ofColumns(List<Column> column) {
        return new ColumnListBlock(column);
    }

    public static ColumnListBlock ofColumn(Column column) {
        return new ColumnListBlock(List.of(column));
    }

    public static ColumnListBlock ofColumns(Column... column) {
        return new ColumnListBlock(List.of(column));
    }

    public static Column ofChildren(List<AbstractBlock> children) {
        Column column = new Column();
        column.setChildren(children);
        return column;
    }

    public static Column ofChild(AbstractBlock child) {
        Column column = new Column();
        column.setChildren(List.of(child));
        return column;
    }

    public static Column ofChildren(AbstractBlock... children) {
        Column column = new Column();
        column.setChildren(List.of(children));
        return column;
    }
}
