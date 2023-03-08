package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import com._2lazy2name.notion.entity.block.heading.AbstractHeadingBlock;
import com._2lazy2name.notion.entity.block.heading.HeadingOneBlock;
import com._2lazy2name.notion.entity.block.heading.HeadingTwoBlock;
import com._2lazy2name.notion.entity.common.PaginationResult;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class HeadingBlockTest extends NotionTest {
    private final String testPageId = "bb5580f5ecfc4a379110a0455a7010d3";

    private static HeadingOneBlock createHeadingOneBlock() throws IOException {
        return new HeadingOneBlock.Builder()
                .richText("Test Heading 1")
                .randomColor()
                .build();
    }

    @Test
    public void testCreateHeading1() throws IOException {
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(testPageId, createHeadingOneBlock());
        createdBlock.add(result.getResults().get(0).getId());
    }

    @Test
    public void testCreateHeading2() throws IOException {
        AbstractHeadingBlock headingTwoBlock = new HeadingTwoBlock.Builder()
                .richText("Heading 2")
                .randomColorBackground()
                .build();
        PaginationResult<AbstractBlock> result =  notion.appendBlockChild(testPageId, headingTwoBlock);
        createdBlock.add(result.getResults().get(0).getId());
    }

    @Test
    public void testCreateHeading3() throws IOException {
        AbstractHeadingBlock headingThreeBlock = new HeadingTwoBlock.Builder()
                .richText("Heading 3")
                .randomColor()
                .build();
        PaginationResult<AbstractBlock> result =  notion.appendBlockChild(testPageId, headingThreeBlock);
        createdBlock.add(result.getResults().get(0).getId());
    }

    @Test
    public void testArchivedBlock() throws IOException, InterruptedException {
        HeadingOneBlock headingOneBlock = new HeadingOneBlock.Builder().richText("Heading 1").build();
        PaginationResult<AbstractBlock> result =  notion.appendBlockChild(testPageId, headingOneBlock);
        Thread.sleep(SLEEP_TIME);
        notion.updateBlock(result.getResults().get(0).getId(), true);
        createdBlock.add(result.getResults().get(0).getId());
    }

    @Test
    public void testUpdateHeadingText() throws IOException, InterruptedException {
        HeadingOneBlock headingOneBlock = createHeadingOneBlock();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(testPageId, headingOneBlock);
        Thread.sleep(SLEEP_TIME);
        String blockId = result.getResults().get(0).getId();
        headingOneBlock = (HeadingOneBlock) result.getResults().get(0);
        headingOneBlock.setRichText("Heading 1 updated");
        notion.updateBlock(blockId, headingOneBlock);
        createdBlock.add(blockId);
    }

    @Test
    public void testUpdateHeadingColor() throws IOException, InterruptedException {
        HeadingOneBlock headingOneBlock = createHeadingOneBlock();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(testPageId, headingOneBlock);
        Thread.sleep(SLEEP_TIME);
        String blockId = result.getResults().get(0).getId();
        headingOneBlock = (HeadingOneBlock) result.getResults().get(0);
        headingOneBlock.setColor(ColorEnum.RED_BACKGROUND);
        notion.updateBlock(blockId, headingOneBlock);
        createdBlock.add(blockId);
    }

    @Test
    public void testCreateToggleableHeading() throws IOException  {
        HeadingOneBlock headingOneBlock = new HeadingOneBlock.Builder()
                .isToggleable(true)
                .richText("Heading 1")
                .build();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(testPageId, headingOneBlock);
        createdBlock.add(result.getResults().get(0).getId());
    }




}
