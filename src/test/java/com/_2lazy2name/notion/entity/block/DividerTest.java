package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class DividerTest extends NotionTest {
    private final String testPageId = "325ba04e40d345d390a7f02b835a196c";

    @Test
    @SneakyThrows
    public void testCreate() {
        DividerBlock dividerBlock = DividerBlock.getInstance();
        createdBlock.add(notion.appendBlockChild(testPageId, dividerBlock).getResult().getId());
    }

}
