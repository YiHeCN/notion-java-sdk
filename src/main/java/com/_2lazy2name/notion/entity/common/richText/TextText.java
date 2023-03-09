package com._2lazy2name.notion.entity.common.richText;

import com._2lazy2name.notion.enumeration.type.TextTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

public class TextText extends AbstractRichText {
    private final TextTypeEnum type = TextTypeEnum.TEXT;
    private Text text;

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
    public static class Text {
        private String content;
        private Link link;

        public String getContent() {
            return content;
        }

        public Text setContent(String content) {
            this.content = content;
            return this;
        }

        public Link getLink() {
            return link;
        }

        public Text setLink(Link link) {
            this.link = link;
            return this;
        }
    }

    @Override
    public TextTypeEnum getType() {
        return type;
    }

    public Text getText() {
        return text;
    }

    public TextText setText(Text text) {
        this.text = text;
        return this;
    }
}
