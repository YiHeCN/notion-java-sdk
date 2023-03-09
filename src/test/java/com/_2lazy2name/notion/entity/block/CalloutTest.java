package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import com._2lazy2name.notion.enumeration.ColorEnum;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CalloutTest extends NotionTest {
    private final String testPageId = "66e8a3fbdedf4f13912efbc0eafa10fe";

    @Test
    public void testCreate() throws IOException  {
        CalloutBlock calloutBlock = new CalloutBlock.Builder()
                .richText("Test")
                .color(ColorEnum.RED)
                .build();
        createdBlock.add(notion.appendBlockChild(testPageId, calloutBlock).getResult().getId());
    }

    @Test
    public void testUpdate() throws IOException {
        CalloutBlock calloutBlock = new CalloutBlock.Builder()
                .richText("Test")
                .color(ColorEnum.RED)
                .build();
        String id = notion.appendBlockChild(testPageId, calloutBlock).getResult().getId();
        createdBlock.add(id);
        notion.updateBlock(id, calloutBlock.setRichText("Test2").setColor(ColorEnum.getRandomColorBackground()));
    }

}
