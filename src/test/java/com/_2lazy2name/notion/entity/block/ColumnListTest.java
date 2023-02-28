package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import com._2lazy2name.notion.entity.block.heading.HeadingOneBlock;
import com._2lazy2name.notion.entity.common.PaginationResult;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.LanguageEnum;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class ColumnListTest extends NotionTest {
    private final String testPageId = "6588177ff34448fca47de8fffe8851fd";


    @Test
    @SneakyThrows
    public void testCreate() {
        ColumnBlock columnBlock = ColumnBlock.ofChildren(
                new HeadingOneBlock.Builder().richText("This is a text").build(),
                new HeadingOneBlock.Builder().richText("This is a text").build(),
                new HeadingOneBlock.Builder().richText("This is a text").build());
        ColumnListBlock columnListBlock = ColumnListBlock.ofColumns(columnBlock, columnBlock);
        createdBlock.add(notion.appendBlockChild(testPageId, columnListBlock).getResult().getId());
    }

    @Test @SneakyThrows
    public void testUpdate() {
        CodeBlock codeBlock = new CodeBlock.Builder()
                .language(LanguageEnum.JAVA)
                .caption("This is a caption")
                .richText("This is a text")
                .build();
        String id = notion.appendBlockChild(testPageId, codeBlock).getResult().getId();
        createdBlock.add(id);
        notion.updateBlock(id, codeBlock.setRichText("System.out.println(\"Hello World!\");"));
    }
}
