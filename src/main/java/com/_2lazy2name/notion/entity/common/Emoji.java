package com._2lazy2name.notion.entity.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Emoji {
    private String type = "emoji";
    private String emoji;

    private Emoji() {
    }

    public Emoji(char emoji) {
        this.emoji = Character.toString(emoji);
    }
}
