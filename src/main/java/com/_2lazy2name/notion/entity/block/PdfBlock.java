package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
public class PdfBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.PDF;
    private AbstractFile pdf;

    private PdfBlock() {}
    private PdfBlock(AbstractFile pdf) {
        this.pdf = pdf;
    }

    public static PdfBlock ofPdf(@NonNull AbstractFile pdf) {
        return new PdfBlock(pdf);
    }
}
