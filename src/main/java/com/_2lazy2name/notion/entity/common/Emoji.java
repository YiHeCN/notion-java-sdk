package com._2lazy2name.notion.entity.common;


public class Emoji {
    private String type = "emoji";
    private String emoji;

    private Emoji() {
    }

    public Emoji(char emoji) {
        this.emoji = Character.toString(emoji);
    }

    public String getType() {
        return type;
    }

    public Emoji setType(String type) {
        this.type = type;
        return this;
    }

    public String getEmoji() {
        return emoji;
    }

    public Emoji setEmoji(String emoji) {
        this.emoji = emoji;
        return this;
    }
}
