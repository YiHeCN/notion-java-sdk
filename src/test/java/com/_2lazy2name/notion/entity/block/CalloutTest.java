package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

class CalloutTest extends NotionTest {
    private final String testPageId = "66e8a3fbdedf4f13912efbc0eafa10fe";

    @Test
    @SneakyThrows
    public void testCreate() {
        CalloutBlock calloutBlock = new CalloutBlock.Builder()
                .richText("Test")
                .color(ColorEnum.RED)
                .build();
        createdBlock.add(notion.appendBlockChild(testPageId, calloutBlock).getResult().getId());
    }

    @Test
    @SneakyThrows
    public void testUpdate() {
        CalloutBlock calloutBlock = new CalloutBlock.Builder()
                .richText("Test")
                .color(ColorEnum.RED)
                .build();
        String id = notion.appendBlockChild(testPageId, calloutBlock).getResult().getId();
        createdBlock.add(id);
        notion.updateBlock(id, calloutBlock.setRichText("Test2").setColor(ColorEnum.getRandomColorBackground()));
    }

}
