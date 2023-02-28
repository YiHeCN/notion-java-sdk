package com._2lazy2name.notion.entity.block.fileRelated;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class VideoBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.VIDEO;
    private AbstractFile video;

    public static VideoBlock ofVideo(AbstractFile video) {
        return new VideoBlock(video);
    }

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private VideoBlock() {}

    private VideoBlock(AbstractFile video) {
        this.video = video;
    }

    public AbstractFile getVideo() {
        return video;
    }

    public VideoBlock setVideo(AbstractFile video) {
        this.video = video;
        return this;
    }
}
