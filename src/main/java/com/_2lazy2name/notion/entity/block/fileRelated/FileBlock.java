package com._2lazy2name.notion.entity.block.fileRelated;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FileBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.FILE;
    private AbstractFile file;

    public static FileBlock ofFile(AbstractFile file) {
        return new FileBlock(file);
    }

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private FileBlock() {}

    private FileBlock(AbstractFile file) {
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
