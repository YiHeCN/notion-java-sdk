package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class BookmarkTest extends NotionTest {
    private final String testPageId = "63e4778008934c61b3f0cf6c07fe7c3e";
    private final static int SLEEP_TIME = 1000;

    @Test
    public void testCreate() throws IOException  {
        BookmarkBlock bookmark = new BookmarkBlock.Builder()
                .url("https://www.google.com")
                .caption("Google")
                .build();
        createdBlock.add(notion.appendBlockChild(testPageId, bookmark).getResult().getId());
    }

    @Test
    public void testUpdate() throws IOException {
        BookmarkBlock bookmark = new BookmarkBlock.Builder()
                .url("https://www.google.com")
                .caption("Google")
                .build();
        String id = notion.appendBlockChild(testPageId, bookmark).getResult().getId();
        createdBlock.add(id);
        notion.updateBlock(id, bookmark.setUrl("https://www.bing.com").setCaption("Bing"));
    }
}
