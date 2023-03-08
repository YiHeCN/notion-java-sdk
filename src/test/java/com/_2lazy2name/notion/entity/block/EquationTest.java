    package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

    class EquationTest extends NotionTest {
    private final String testPageId = "3b6a43673a004b1dba99adbeb2728c63";

    @Test
    public void testCreate() throws IOException {
        EquationBlock equationBlock = EquationBlock.ofExpression("2+2");
        createdBlock.add(notion.appendBlockChild(testPageId, equationBlock).getResult().getId());
    }

}
