package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import com._2lazy2name.notion.entity.block.heading.AbstractHeadingBlock;
import com._2lazy2name.notion.entity.block.heading.HeadingOneBlock;
import com._2lazy2name.notion.entity.block.heading.HeadingTwoBlock;
import com._2lazy2name.notion.entity.common.PaginationResult;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import lombok.SneakyThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class HeadingBlockTest extends NotionTest {
    private final String testPageId = "bb5580f5ecfc4a379110a0455a7010d3";
    private static final ArrayList<String> createdBlock = new ArrayList<>();
    private final static int SLEEP_TIME = 1000;

    private static HeadingOneBlock createHeadingOneBlock() {
        return new HeadingOneBlock.Builder()
                .text("Test Heading 1")
                .randomColor()
                .build();
    }

    @Test @SneakyThrows
    public void testCreateHeading1() {
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(testPageId, createHeadingOneBlock());
        createdBlock.add(result.getResults().get(0).getId());
    }

    @Test @SneakyThrows
    public void testCreateHeading2() {
        AbstractHeadingBlock headingTwoBlock = new HeadingTwoBlock.Builder()
                .text("Heading 2")
                .randomColorBackground()
                .build();
        PaginationResult<AbstractBlock> result =  notion.appendBlockChild(testPageId, headingTwoBlock);
        createdBlock.add(result.getResults().get(0).getId());
    }

    @Test @SneakyThrows
    public void testCreateHeading3() {
        AbstractHeadingBlock headingThreeBlock = new HeadingTwoBlock.Builder()
                .text("Heading 3")
                .randomColor()
                .build();
        PaginationResult<AbstractBlock> result =  notion.appendBlockChild(testPageId, headingThreeBlock);
        createdBlock.add(result.getResults().get(0).getId());
    }

    @Test @SneakyThrows
    public void testArchivedBlock() {
        HeadingOneBlock headingOneBlock = new HeadingOneBlock.Builder().text("Heading 1").build();
        PaginationResult<AbstractBlock> result =  notion.appendBlockChild(testPageId, headingOneBlock);
        Thread.sleep(SLEEP_TIME);
        notion.updateBlock(result.getResults().get(0).getId(), true);
    }

    @Test @SneakyThrows
    public void testUpdateHeadingText() {
        HeadingOneBlock headingOneBlock = createHeadingOneBlock();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(testPageId, headingOneBlock);
        Thread.sleep(SLEEP_TIME);
        String blockId = result.getResults().get(0).getId();
        headingOneBlock = (HeadingOneBlock) result.getResults().get(0);
        headingOneBlock.updateText("Heading 1 updated");
        notion.updateBlock(blockId, headingOneBlock);
    }

    @Test @SneakyThrows
    public void testUpdateHeadingColor() {
        HeadingOneBlock headingOneBlock = createHeadingOneBlock();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(testPageId, headingOneBlock);
        Thread.sleep(SLEEP_TIME);
        String blockId = result.getResults().get(0).getId();
        headingOneBlock = (HeadingOneBlock) result.getResults().get(0);
        headingOneBlock.updateColor(ColorEnum.RED_BACKGROUND);
        notion.updateBlock(blockId, headingOneBlock);
    }

    @Test @SneakyThrows
    public void testCreateToggleableHeading() {
        HeadingOneBlock headingOneBlock = new HeadingOneBlock.Builder()
                .isToggleable(true)
                .text("Heading 1")
                .build();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(testPageId, headingOneBlock);
        createdBlock.add(result.getResults().get(0).getId());
    }


    @AfterAll @SneakyThrows
    public static void deleteAll() {
        createdBlock.forEach(notion::deleteBlock);
    }


}
