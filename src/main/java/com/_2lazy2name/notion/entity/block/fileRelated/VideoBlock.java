package com._2lazy2name.notion.entity.block.fileRelated;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.common.file.ExternalFile;
import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class VideoBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.VIDEO;
    private AbstractFile video;

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private VideoBlock() {}

    public VideoBlock(AbstractFile video) {
        this.video = video;
    }

    public VideoBlock(String url) {
        this.video = new ExternalFile(url);
    }

    public AbstractFile getVideo() {
        return video;
    }

    public VideoBlock setVideo(AbstractFile video) {
        this.video = video;
        return this;
    }
}
