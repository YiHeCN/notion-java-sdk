package com._2lazy2name.notion.entity.block.table;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TableRow extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.TABLE_ROW;
    private final Row tableRow;

    public TableRow addCell(List<AbstractRichText> cell) {
        this.tableRow.cells.add(cell);
        return this;
    }
    public TableRow addCell(AbstractRichText cell) {
        this.tableRow.cells.add(List.of(cell));
        return this;
    }
    public TableRow addCell(String cell) {
        this.tableRow.cells.add(List.of(AbstractRichText.buildPlainText(cell)));
        return this;
    }
    public TableRow addCells(List<List<AbstractRichText>> cells) {
        this.tableRow.cells.addAll(cells);
        return this;
    }
    public TableRow removeAllCells() {
        this.tableRow.cells.clear();
        return this;
    }
    public TableRow removeLastCell() {
        this.tableRow.cells.remove(this.tableRow.cells.size() - 1);
        return this;
    }
    @JsonIgnore
    public int getCellCount() {
        return this.tableRow.cells.size();
    }

    public BlockTypeEnum getType() {
        return type;
    }


    public TableRow() {
        this.tableRow = new Row();
        this.tableRow.cells = new ArrayList<>();
    }

    public TableRow(List<List<AbstractRichText>> cells) {
        this.tableRow = new Row();
        this.tableRow.cells = cells;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class Row {
        private List<List<AbstractRichText>> cells;
        private List<List<AbstractRichText>> getCells() {
            return cells;
        }
        private Row setCells(List<List<AbstractRichText>> cells) {
            this.cells = cells;
            return this;
        }
    }

    @JsonIgnore
    public List<List<AbstractRichText>> getCells() {
        return this.tableRow.cells;
    }

    private TableRow setCells(List<List<AbstractRichText>> cells) {
        this.tableRow.cells = cells;
        return this;
    }
}
