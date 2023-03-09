package com._2lazy2name.notion.entity.block.fileRelated;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PdfBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.PDF;
    private AbstractFile pdf;

    public static PdfBlock ofPdf(AbstractFile pdf) {
        return new PdfBlock(pdf);
    }

    public static PdfBlock ofPdf(String url) {
        return new PdfBlock(AbstractFile.buildExternalFile(url));
    }

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private PdfBlock() {}

    private PdfBlock(AbstractFile pdf) {
        this.pdf = pdf;
    }

    public AbstractFile getPdf() {
        return pdf;
    }

    public PdfBlock setPdf(AbstractFile pdf) {
        this.pdf = pdf;
        return this;
    }
}
