package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ColumnListBlock extends AbstractBlock {
    public static final BlockTypeEnum type = BlockTypeEnum.COLUMN_LIST;

    private ColumnList columnList;

    public static ColumnListBlock ofColumns(ColumnBlock... columns) {
        ColumnListBlock columnListBlock = new ColumnListBlock();
        columnListBlock.columnList = new ColumnList();
        columnListBlock.columnList.children = new ArrayList<>();
        Collections.addAll(columnListBlock.columnList.children, columns);
        return columnListBlock;
    }

    public static ColumnListBlock ofColumns(List<ColumnBlock> columns) {
        ColumnListBlock columnListBlock = new ColumnListBlock();
        columnListBlock.columnList = new ColumnList();
        columnListBlock.columnList.children = columns;
        return columnListBlock;
    }

    @JsonIgnore
    public List<ColumnBlock> getColumns() {
        return columnList.children;
    }

    public ColumnListBlock setColumns(List<ColumnBlock> columns) {
        if (this.columnList == null) {
            this.columnList = new ColumnList();
        }
        this.columnList.children = columns;
        return this;
    }
    public ColumnListBlock appendColumns(ColumnBlock... columns) {
        if (this.columnList == null) {
            this.columnList = new ColumnList();
        }
        if (this.columnList.children == null) {
            this.columnList.children = new ArrayList<>();
        }
        Collections.addAll(this.columnList.children, columns);
        return this;
    }
    public ColumnListBlock appendColumn(ColumnBlock column) {
        return appendColumns(column);
    }


    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class ColumnList {
        private List<ColumnBlock> children;

        private List<ColumnBlock> getChildren() {
            return children;
        }

        private ColumnList setChildren(List<ColumnBlock> children) {
            this.children = children;
            return this;
        }
    }

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private ColumnListBlock() {}

    @JsonProperty("column_list")
    private ColumnList getColumnList() {
        return columnList;
    }

    private ColumnListBlock setColumnList(ColumnList columnList) {
        this.columnList = columnList;
        return this;
    }
}
