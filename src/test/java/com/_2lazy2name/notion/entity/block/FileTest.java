    package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.common.file.NotionFile;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.List;

    class FileTest extends NotionTest {
    private final String testPageId = "a7f112c726c9459cbade461e625bad6b";

    @Test
    @SneakyThrows
    public void testCreate() {
        AbstractFile file = AbstractFile.buildExternalFile(List.of(AbstractRichText.buildPlainText("test")), "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
    }

}
