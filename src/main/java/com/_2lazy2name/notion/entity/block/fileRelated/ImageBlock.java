package com._2lazy2name.notion.entity.block.fileRelated;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * TODO: Add validation in the constructor. The image must be a valid image link.
 * @author Chole
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/block#image">Image</a>
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ImageBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.IMAGE;
    private AbstractFile image;

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private ImageBlock() {}

    public ImageBlock(AbstractFile image) {
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
