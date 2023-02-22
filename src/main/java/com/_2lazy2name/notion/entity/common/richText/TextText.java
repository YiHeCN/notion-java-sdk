package com._2lazy2name.notion.entity.common.richText;

import com._2lazy2name.notion.entity.enumeration.type.TextTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
public class TextText extends AbstractRichText {
    private final TextTypeEnum type = TextTypeEnum.TEXT;
    private Text text;

    @ToString @Getter @Setter
    public static class Link {
        private String url;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ToString @Getter @Setter
    public static class Text {
        private String content;
        private Link link;
    }

}
