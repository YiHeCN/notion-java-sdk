package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.block.builder.impl.TextBuilder;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString @Getter @Setter
public class FileBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.FILE;
    AbstractFile file;
    List<AbstractRichText> caption;

    private FileBlock() {}

    private FileBlock(AbstractFile file, List<AbstractRichText> caption) {
        this.file = file;
        this.caption = caption;
    }

    public static class Builder extends TextBuilder<Builder, FileBlock> {
        private AbstractFile file;

        public Builder file(@NonNull AbstractFile file) {
            this.file = file;
            return this;
        }

        public FileBlock build() {
            if (file == null) {
                throw new IllegalArgumentException("File cannot be null");
            }
            return new FileBlock(file, richText);
        }
    }


}
