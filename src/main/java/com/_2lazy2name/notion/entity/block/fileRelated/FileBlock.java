package com._2lazy2name.notion.entity.block.fileRelated;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author Chole
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/block#file">File</a>
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FileBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.FILE;
    private AbstractFile file;

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private FileBlock() {}

    public FileBlock(AbstractFile file) {
        this.file = file;
    }

    public AbstractFile getFile() {
        return file;
    }

    public FileBlock setFile(AbstractFile file) {
        this.file = file;
        return this;
    }
}
