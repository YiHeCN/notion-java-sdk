package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import com._2lazy2name.notion.entity.block.heading.HeadingOneBlock;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ColumnListTest extends NotionTest {
    private final String testPageId = "6588177ff34448fca47de8fffe8851fd";

    @Test
    public void testCreate() throws IOException {
       ColumnBlock columnBlock = new ColumnBlock(
               new HeadingOneBlock.Builder().richText("This is a text").build(),
               new HeadingOneBlock.Builder().richText("This is a text").build(),
               new HeadingOneBlock.Builder().richText("This is a text").build()
       );
       ColumnListBlock columnListBlock = new ColumnListBlock(columnBlock, columnBlock);
       createdBlock.add(notion.appendBlockChild(testPageId, columnListBlock).getResult().getId());
    }

}
