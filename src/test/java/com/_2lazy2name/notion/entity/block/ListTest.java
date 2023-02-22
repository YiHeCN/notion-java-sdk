package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import com._2lazy2name.notion.entity.block.list.BulletedListItemBlock;
import com._2lazy2name.notion.entity.common.PaginationResult;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ListTest extends NotionTest {
    private final String bulletedListPageID = "a2e216757f804f419b1ae78c033e429c";
    private final String numberedListPageID = "a2e216757f804f419b1ae78c033e429c";
    private static final ArrayList<String> createdBlock = new ArrayList<>();
    private final static int SLEEP_TIME = 1000;


    @Test @SneakyThrows
    public void testCreateBulletedList() {
        BulletedListItemBlock bulletedListItemBlock = new BulletedListItemBlock.Builder()
                .richText("Bulleted List")
                .build();
        PaginationResult<AbstractBlock> result = notion.appendBlockChild(bulletedListPageID, bulletedListItemBlock);
        createdBlock.add(result.getResults().get(0).getId());
    }

   @Test @SneakyThrows
   public void testUpdatingText() {
       BulletedListItemBlock bulletedListItemBlock = new BulletedListItemBlock.Builder()
               .richText("Bulleted List")
               .build();
       PaginationResult<AbstractBlock> result = notion.appendBlockChild(bulletedListPageID, bulletedListItemBlock);
       notion.updateBlock(result.getResults().get(0).getId(), bulletedListItemBlock.setRichText("Updated Text"));
   }



//    @AfterAll
    @SneakyThrows
    public static void deleteAll() {
        createdBlock.forEach(notion::deleteBlock);
    }

}
