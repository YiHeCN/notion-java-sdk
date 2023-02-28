package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

class BreadcrumbTest extends NotionTest {
    private final String testPageId = "f0dd27733f7d4f3bac21efb6f53a1326";

    @Test
    @SneakyThrows
    public void testCreate() {
        BreadcrumbBlock breadcrumb = BreadcrumbBlock.getInstance();
        createdBlock.add(notion.appendBlockChild(testPageId, breadcrumb).getResult().getId());
    }
}
