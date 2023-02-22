package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
public class VideoBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.VIDEO;
    private AbstractFile video;

    private VideoBlock() {}

    private VideoBlock(AbstractFile video) {
        this.video = video;
    }

    public static VideoBlock ofVideo(AbstractFile video) {
        return new VideoBlock(video);
    }
}
