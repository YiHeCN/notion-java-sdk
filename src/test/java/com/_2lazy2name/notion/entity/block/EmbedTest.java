    package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class EmbedTest extends NotionTest {
    private final String testPageId = "668627061669445daa11d8a933f86de1";

    @Test
    @SneakyThrows
    public void testCreate() {
        EmbedBlock embedBlock = EmbedBlock.ofUrl("google.com");
        createdBlock.add(notion.appendBlockChild(testPageId, embedBlock).getResult().getId());
    }

}
