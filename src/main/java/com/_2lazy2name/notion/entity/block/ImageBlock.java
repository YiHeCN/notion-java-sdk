package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ImageBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.IMAGE;
    private AbstractFile image;

    private ImageBlock() {}

    private ImageBlock(AbstractFile image) {
        this.image = image;
    }

    public static ImageBlock ofImage(@NonNull AbstractFile image) {
        return new ImageBlock(image);
    }
}
