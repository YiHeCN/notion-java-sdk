package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import com._2lazy2name.notion.entity.block.table.TableBlock;
import com._2lazy2name.notion.entity.block.table.TableRow;
import com._2lazy2name.notion.entity.common.PaginationResult;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.common.richText.TextText;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class TableTest extends NotionTest {
    private final String testPageId = "c168dafdb15d446cbd73e95a1ad5b9c7";

    @Test
    public void testCreateTableBlock() throws IOException  {
        TableRow tableRow = new TableRow().addCell("Test").addCell("Test2");
        TableBlock tableBlock = new TableBlock.Builder()
                .tableWidth(2)
                .hasColumnHeader(true)
                .hasRowHeader(true)
                .children(List.of(tableRow))
                .build();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(testPageId, tableBlock);
        createdBlock.add(result.getResults().get(0).getId());
    }

    @Test
    public void testAppendRow() throws IOException {
        TableRow tableRow = new TableRow().addCell("Test").addCell("Test2");
        TableBlock tableBlock = new TableBlock.Builder()
                .tableWidth(2)
                .hasColumnHeader(true)
                .hasRowHeader(true)
                .children(List.of(tableRow, tableRow, tableRow, tableRow))
                .build();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(testPageId, tableBlock);
        String id = result.getResults().get(0).getId();
        createdBlock.add(id);

        TableRow tableRow2 = new TableRow().addCell("Test3").addCell("Test4");
        notion.appendBlockChild(id, tableRow2);
    }

    @Test
    public void testUpdateRowContent() throws IOException {
        TableRow tableRow = new TableRow().addCell("Test").addCell("Test2");
        TableBlock tableBlock = new TableBlock.Builder()
                .tableWidth(2)
                .hasColumnHeader(true)
                .hasRowHeader(true)
                .children(List.of(tableRow, tableRow, tableRow, tableRow))
                .build();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(testPageId, tableBlock);
        String id = result.getResults().get(0).getId();

        TableRow rowCreated = (TableRow) notion.retrieveBlockChildren(id).getResults().get(0);
        rowCreated.getCells().get(0).set(0, new TextText("Replaced"));
        notion.updateBlock(rowCreated);
        createdBlock.add(id);
    }

    @Test
    public void testUpdateRowHeaders() throws IOException {
        TableRow tableRow = new TableRow().addCell("Test").addCell("Test2");
        TableBlock tableBlock = new TableBlock.Builder()
                .tableWidth(2)
                .hasColumnHeader(true)
                .hasRowHeader(true)
                .children(List.of(tableRow, tableRow, tableRow, tableRow))
                .build();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(testPageId, tableBlock);

        String id = result.getResults().get(0).getId();

        TableBlock tableBlockNew = new TableBlock.Builder()
                .hasRowHeader(false).hasColumnHeader(false).build();

        notion.updateBlock(id, tableBlockNew);
        createdBlock.add(id);
    }

    @Test
    public void testDeleteRow() throws IOException {
        TableRow tableRow = new TableRow().addCell("Test").addCell("Test2");
        TableBlock tableBlock = new TableBlock.Builder()
                .tableWidth(2)
                .hasColumnHeader(true)
                .hasRowHeader(true)
                .children(List.of(tableRow, tableRow, tableRow, tableRow))
                .build();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(testPageId, tableBlock);
        String id = result.getResults().get(0).getId();

        TableRow rowCreated = (TableRow) notion.retrieveBlockChildren(id).getResults().get(0);
        notion.deleteBlock(rowCreated);
        createdBlock.add(id);
    }
}
