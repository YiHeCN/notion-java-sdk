    package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import com._2lazy2name.notion.entity.block.fileRelated.FileBlock;
import com._2lazy2name.notion.entity.block.fileRelated.ImageBlock;
import com._2lazy2name.notion.entity.block.fileRelated.PdfBlock;
import com._2lazy2name.notion.entity.block.fileRelated.VideoBlock;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.List;

class FileTest extends NotionTest {
    private final String testPageId = "a7f112c726c9459cbade461e625bad6b";

    @Test
    @SneakyThrows
    public void testCreateFileBlock() {
        AbstractFile file = AbstractFile.buildExternalFile(List.of(AbstractRichText.buildPlainText("test")), "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
        FileBlock fileBlock = FileBlock.ofFile(file);
        notion.appendBlockChild(testPageId, fileBlock);
    }

    @Test @SneakyThrows
    public void testCreateImageBlock() {
        AbstractFile file = AbstractFile.buildExternalFile(List.of(AbstractRichText.buildPlainText("test")), "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
        ImageBlock fileBlock = ImageBlock.ofImage(file);
        notion.appendBlockChild(testPageId, fileBlock);
    }

    @Test @SneakyThrows
    public void testCreatePdfBlock () {
        AbstractFile file = AbstractFile.buildExternalFile("https://www.phocos.com/wp-content/uploads/2021/05/Any-Bridge_chinese-datasheet_2022-08-26.pdf");
        PdfBlock fileBlock = PdfBlock.ofPdf(file);
        notion.appendBlockChild(testPageId, fileBlock);
    }

    @Test @SneakyThrows
    public void testCreateVideoBlock() {
        AbstractFile file = AbstractFile.buildExternalFile("https://a.com/0.mp4");
        VideoBlock fileBlock = VideoBlock.ofVideo(file);
        notion.appendBlockChild(testPageId, fileBlock);
    }



}
