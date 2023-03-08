package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class BreadcrumbTest extends NotionTest {
    private final String testPageId = "f0dd27733f7d4f3bac21efb6f53a1326";

    @Test
    public void testCreate() throws IOException {
        BreadcrumbBlock breadcrumb = BreadcrumbBlock.getInstance();
        createdBlock.add(notion.appendBlockChild(testPageId, breadcrumb).getResult().getId());
    }
}
