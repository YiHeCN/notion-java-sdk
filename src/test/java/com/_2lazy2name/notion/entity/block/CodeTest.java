package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import com._2lazy2name.notion.entity.enumeration.LanguageEnum;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

class CodeTest extends NotionTest {
    private final String testPageId = "fa26bc15ba0b4e2eac73ff6db7fda283";

    @Test
    @SneakyThrows
    public void testCreate() {
        CodeBlock codeBlock = new CodeBlock.Builder()
                .language(LanguageEnum.JAVA)
                .caption("This is a caption")
                .richText("This is a text")
                .build();
        createdBlock.add(notion.appendBlockChild(testPageId, codeBlock).getResult().getId());
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
