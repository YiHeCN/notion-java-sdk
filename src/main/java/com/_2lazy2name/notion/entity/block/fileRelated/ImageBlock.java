package com._2lazy2name.notion.entity.block.fileRelated;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ImageBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.IMAGE;
    private AbstractFile image;

    public static ImageBlock ofImage(AbstractFile image) {
        return new ImageBlock(image);
    }

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private ImageBlock() {}

    private ImageBlock(AbstractFile image) {
        this.image = image;
    }

    public AbstractFile getImage() {
        return image;
    }

    public ImageBlock setImage(AbstractFile image) {
        this.image = image;
        return this;
    }

}
