    package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

    public class EmbedTest extends NotionTest {
    private final String testPageId = "668627061669445daa11d8a933f86de1";

    @Test
    public void testCreate() throws IOException  {
        EmbedBlock embedBlock = EmbedBlock.ofUrl("google.com");
        createdBlock.add(notion.appendBlockChild(testPageId, embedBlock).getResult().getId());
    }
}
