package com._2lazy2name.notion.entity.common.icon;

import com._2lazy2name.notion.entity.common.Emoji;
import com._2lazy2name.notion.entity.enumeration.type.IconTypeEnum;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
public class EmojiIcon extends AbstractIcon{
    private final static IconTypeEnum type = IconTypeEnum.EMOJI;
    @JsonUnwrapped
    private Emoji emoji;

    private EmojiIcon() {
    }

    public EmojiIcon(char emoji) {
        this.emoji = new Emoji(emoji);
    }
}
