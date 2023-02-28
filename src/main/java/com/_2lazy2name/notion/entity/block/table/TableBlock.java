package com._2lazy2name.notion.entity.block.table;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.block.builder.impl.TextColorBuilder;
import com._2lazy2name.notion.entity.block.list.NumberedListItemBlock;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chole
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/block#table">Table Block</a>
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TableBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.TABLE;
    private Table table;

    public static class Builder {
        private Integer tableWidth;
        private Boolean hasColumnHeader;
        private Boolean hasRowHeader;
        private List<TableRow> children;

        public Builder tableWidth(Integer tableWidth) {
            this.tableWidth = tableWidth;
            return this;
        }

        public Builder hasColumnHeader(Boolean hasColumnHeader) {
            this.hasColumnHeader = hasColumnHeader;
            return this;
        }

        public Builder hasRowHeader(Boolean hasRowHeader) {
            this.hasRowHeader = hasRowHeader;
            return this;
        }

        public Builder children(List<TableRow> children) {
            this.children = children;
            return this;
        }

        public Builder children(TableRow children) {
            this.children = List.of(children);
            return this;
        }

        public TableBlock build() {
            return new TableBlock(tableWidth, hasColumnHeader, hasRowHeader, children);
        }
    }

    @JsonIgnore
    public Integer getTableWidth() {
        return this.table.tableWidth;
    }
    // TableWidth is not editable, go see doc.
    private TableBlock setTableWidth(Integer tableWidth) {
        this.table.tableWidth = tableWidth;
        return this;
    }

    @JsonIgnore
    public Boolean getHasColumnHeader() {
        return this.table.hasColumnHeader;
    }
    public TableBlock setHasColumnHeader(Boolean hasColumnHeader) {
        this.table.hasColumnHeader = hasColumnHeader;
        return this;
    }

    @JsonIgnore
    public Boolean getHasRowHeader() {
        return this.table.hasRowHeader;
    }
    public TableBlock setHasRowHeader(Boolean hasRowHeader) {
        this.table.hasRowHeader = hasRowHeader;
        return this;
    }

    /**
     * TODO: Consider to make it private.
     * This method is only used if you want to see what you put in.
     * It is null in the return of calling appendBlock or update.
     * For modifying the row / cell is use the id returned and call the {@link com._2lazy2name.notion.Notion#retrieveBlock(String)} method.
     * @return List of TableRow.
     */
    @JsonIgnore
    public List<TableRow> getChildren() {
        return this.table.children;
    }
    public TableBlock setChildren(List<TableRow> children) {
        this.table.children = children;
        return this;
    }
    public TableBlock setChild(TableRow child) {
        this.table.children = List.of(child);
        return this;
    }
    public TableBlock appendChild(TableRow child) {
        if (this.table.children == null) this.table.children = new ArrayList<>();
        this.table.children.add(child);
        return this;
    }
    public TableBlock appendChildren(List<TableRow> children) {
        if (this.table.children == null) this.table.children = new ArrayList<>();
        this.table.children.addAll(children);
        return this;
    }


    public BlockTypeEnum getType() {
        return type;
    }

    private TableBlock() {
        this.table = new Table();
    }

    private TableBlock(Integer tableWidth, Boolean hasColumnHeader, Boolean hasRowHeader, List<TableRow> children) {
        this.table = new Table();
        this.table.tableWidth = tableWidth;
        this.table.hasColumnHeader = hasColumnHeader;
        this.table.hasRowHeader = hasRowHeader;
        this.table.children = children;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class Table {
        private Integer tableWidth;
        private Boolean hasColumnHeader;
        private Boolean hasRowHeader;
        private List<TableRow> children;

        private Integer getTableWidth() {
            return tableWidth;
        }

        private Table setTableWidth(Integer tableWidth) {
            this.tableWidth = tableWidth;
            return this;
        }

        private Boolean getHasColumnHeader() {
            return hasColumnHeader;
        }

        private Table setHasColumnHeader(Boolean hasColumnHeader) {
            this.hasColumnHeader = hasColumnHeader;
            return this;
        }

        private Boolean getHasRowHeader() {
            return hasRowHeader;
        }

        private Table setHasRowHeader(Boolean hasRowHeader) {
            this.hasRowHeader = hasRowHeader;
            return this;
        }

        private List<TableRow> getChildren() {
            return children;
        }

        private Table setChildren(List<TableRow> children) {
            this.children = children;
            return this;
        }
    }

    private Table getTable() {
        return this.table;
    }

    private TableBlock setTable(Table table) {
        this.table = table;
        return this;
    }
}
