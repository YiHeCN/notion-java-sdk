package com._2lazy2name.notion.entity.common.richText;

import com._2lazy2name.notion.enumeration.type.TextTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TextText extends AbstractRichText {
    private final TextTypeEnum type = TextTypeEnum.TEXT;
    private Text text;

    private TextText() {
    }
    public TextText(String content) {
        this.text = new Text().setContent(content);
    }
    public TextText(String content, String url) {
        this.text = new Text().setContent(content).setLink(new Link().setUrl(url));
    }

    @JsonIgnore
    public String getContent() {
        return text.getContent();
    }

    public String setContent(String content) {
        text.setContent(content);
        return content;
    }

    @JsonIgnore
    public String getUrl() {
        if (text.getLink() == null) {
            return null;
        }
        return text.getLink().getUrl();
    }

    public String setUrl(String url) {
        if (text.getLink() == null) {
            text.setLink(new Link().setUrl(url));
        } else {
            text.getLink().setUrl(url);
        }
        return url;
    }

    public static class Link {
        private String url;

        public String getUrl() {
            return url;
        }

        public Link setUrl(String url) {
            this.url = url;
            return this;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class Text {
        private String content;
        private Link link;

        private String getContent() {
            return content;
        }

        private Text setContent(String content) {
            this.content = content;
            return this;
        }

        private Link getLink() {
            return link;
        }

        private Text setLink(Link link) {
            this.link = link;
            return this;
        }
    }

    @Override
    public TextTypeEnum getType() {
        return this.type;
    }

    private Text getText() {
        return text;
    }

    private TextText setText(Text text) {
        this.text = text;
        return this;
    }
}
