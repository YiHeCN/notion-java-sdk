package com._2lazy2name.notion.exception;

import com._2lazy2name.notion.NotionTest;
import com._2lazy2name.notion.entity.block.DividerBlock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTest extends NotionTest {

    @Test
    public void testExceptionCreation() {
        Assertions.assertThrows(NotionException.class, () -> notion.appendBlockChild("asda", DividerBlock.getInstance()));
    }
}
