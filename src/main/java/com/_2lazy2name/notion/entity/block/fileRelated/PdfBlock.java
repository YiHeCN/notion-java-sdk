package com._2lazy2name.notion.entity.block.fileRelated;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.common.file.ExternalFile;
import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * TODO: Add validation in the constructor. The image must be a valid pdf link.
 * @author Chole
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/block#pdf">PDF</a>
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PdfBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.PDF;
    private AbstractFile pdf;

    public PdfBlock(AbstractFile pdf) {
        this.pdf = pdf;
    }

    public PdfBlock(String url) {
        this.pdf = new ExternalFile(url);
    }

    @JsonIgnore
    public String getUrl() {
        return this.pdf.getUrl();
    }

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private PdfBlock() {}

    public AbstractFile getPdf() {
        return pdf;
    }

    public PdfBlock setPdf(AbstractFile pdf) {
        this.pdf = pdf;
        return this;
    }
}
