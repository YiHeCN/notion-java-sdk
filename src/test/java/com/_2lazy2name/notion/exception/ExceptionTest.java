package com._2lazy2name.notion.exception;

import com._2lazy2name.notion.Notion;
import com._2lazy2name.notion.NotionTest;
import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.block.DividerBlock;
import com._2lazy2name.notion.entity.common.PaginationResult;
import com._2lazy2name.util.HttpUtil;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTest extends NotionTest {

    @Test
    public void testExceptionCreation() {
        Assertions.assertThrows(NotionException.class, () -> notion.appendBlockChild("asda", DividerBlock.getInstance()));
    }
}
