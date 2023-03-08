package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import com._2lazy2name.notion.entity.block.list.BulletedListItemBlock;
import com._2lazy2name.notion.entity.block.list.NumberedListItemBlock;
import com._2lazy2name.notion.entity.block.list.ToDoBlock;
import com._2lazy2name.notion.entity.common.PaginationResult;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ListTest extends NotionTest {
    private final String bulletedListPageID = "a2e216757f804f419b1ae78c033e429c";
    private final String numberedListPageID = "43815111d5814b0f819cc4c37500bffc";
    private final String toDoBlockPageID = "5f0de5fca9644b1780b4d2800789acd5";

    private final static int SLEEP_TIME = 1000;


    @Test
    public void testCreateBulletedList() throws IOException {
        BulletedListItemBlock bulletedListItemBlock = new BulletedListItemBlock.Builder()
                .richText("Bulleted List")
                .build();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(bulletedListPageID, bulletedListItemBlock);
        createdBlock.add(result.getResults().get(0).getId());
    }

    @Test
    public void testUpdatingBulletedListText() throws IOException {
        BulletedListItemBlock bulletedListItemBlock = new BulletedListItemBlock.Builder()
                .richText("Bulleted List")
                .build();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(bulletedListPageID, bulletedListItemBlock);
        notion.updateBlock(result.getResults().get(0).getId(), bulletedListItemBlock.setRichText("Updated Text"));
        createdBlock.add(result.getResults().get(0).getId());
    }

    @Test
    public void testUpdateBulletedListColor() throws IOException {
         BulletedListItemBlock bulletedListItemBlock = new BulletedListItemBlock.Builder()
                .richText("Bulleted List")
                .build();
         PaginationResult<AbstractBlock> result = notion.appendBlockChild(bulletedListPageID, bulletedListItemBlock);
         notion.updateBlock(result.getResults().get(0).getId(), bulletedListItemBlock.setColor(ColorEnum.getRandomColor()));
         createdBlock.add(result.getResults().get(0).getId());
    }


    @Test
    public void testCreateNumberedList() throws IOException {
        NumberedListItemBlock bulletedListItemBlock = new NumberedListItemBlock.Builder()
                .richText("Numbered List")
                .build();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(numberedListPageID, bulletedListItemBlock);
        notion.updateBlock(result.getResults().get(0).getId(), bulletedListItemBlock.setRichText("Updated Text"));
        createdBlock.add(result.getResults().get(0).getId());
    }

    @Test
    public void testUpdateNumberedListColor() throws IOException {
        NumberedListItemBlock bulletedListItemBlock = new NumberedListItemBlock.Builder()
                .richText("Numbered List")
                .build();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(numberedListPageID, bulletedListItemBlock);
        notion.updateBlock(result.getResults().get(0).getId(), bulletedListItemBlock.setColor(ColorEnum.getRandomColor()));
        createdBlock.add(result.getResults().get(0).getId());
    }

    @Test
    public void testUpdateNumberedListText() throws IOException {
        NumberedListItemBlock bulletedListItemBlock = new NumberedListItemBlock.Builder()
                .richText("Numbered List")
                .build();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(numberedListPageID, bulletedListItemBlock);
        notion.updateBlock(result.getResults().get(0).getId(), bulletedListItemBlock.setRichText("Updated Text"));
        createdBlock.add(result.getResults().get(0).getId());
    }


    @Test
    public void testCreateToDoBlock() throws IOException {
        ToDoBlock toDoBlock = new ToDoBlock.Builder()
                .richText("To Do Block")
                .checked(true)
                .randomColor()
                .build();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(toDoBlockPageID, toDoBlock);
        createdBlock.add(result.getResults().get(0).getId());
    }

    @Test
    public void testUpdateToDoBlockText() throws IOException {
        ToDoBlock toDoBlock = new ToDoBlock.Builder()
                .richText("To Do Block")
                .checked(true)
                .randomColor()
                .build();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(toDoBlockPageID, toDoBlock);
        notion.updateBlock(result.getResults().get(0).getId(), toDoBlock.setRichText("Updated Text"));
        createdBlock.add(toDoBlock.getId());
    }

    @Test
    public void testUpdateToDoBlockCheck() throws IOException {
        ToDoBlock toDoBlock = new ToDoBlock.Builder()
                .richText("To Do Block")
                .checked(false)
                .randomColor()
                .build();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(toDoBlockPageID, toDoBlock);
        notion.updateBlock(result.getResults().get(0).getId(), toDoBlock.setChecked(true));
        createdBlock.add(result.getResults().get(0).getId());
    }

    @Test
    public void testUpdateToDoBlockColor() throws IOException {
        ToDoBlock toDoBlock = new ToDoBlock.Builder()
                .richText("To Do Block")
                .checked(true)
                .randomColor()
                .build();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(toDoBlockPageID, toDoBlock);
        notion.updateBlock(result.getResults().get(0).getId(), toDoBlock.setColor(ColorEnum.getRandomColor()));
        createdBlock.add(result.getResults().get(0).getId());
    }

}
