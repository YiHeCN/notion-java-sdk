package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DividerTest extends NotionTest {
    private final String testPageId = "325ba04e40d345d390a7f02b835a196c";

    @Test
    public void testCreate() throws IOException {
        DividerBlock dividerBlock = DividerBlock.getInstance();
        createdBlock.add(notion.appendBlockChild(testPageId, dividerBlock).getResult().getId());
    }

}
