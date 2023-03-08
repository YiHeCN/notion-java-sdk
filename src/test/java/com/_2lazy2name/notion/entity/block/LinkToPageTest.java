package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class LinkToPageTest extends NotionTest {
    private final String testPageId = "d9581058bf214821822ae1c07c193198";

    @Test
    @SneakyThrows
    public void testCreate() {
        LinkToPageBlock linkToPageBlock = LinkToPageBlock.toPage(testPageId);
        createdBlock.add(notion.appendBlockChild(testPageId, linkToPageBlock).getResult().getId());
    }
}
