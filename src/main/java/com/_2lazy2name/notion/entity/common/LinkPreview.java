package com._2lazy2name.notion.entity.common;

public class LinkPreview {
    private String url;

    public static LinkPreview ofUrl(String url) {
        return new LinkPreview(url);
    }

    public String getUrl() {
        return url;
    }

    public LinkPreview setUrl(String url) {
        this.url = url;
        return this;
    }

    private LinkPreview() {
    }

    private LinkPreview(String url) {
        this.url = url;
    }

}

