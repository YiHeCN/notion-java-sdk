package com._2lazy2name.notion.entity.common.richText;

import com._2lazy2name.notion.enumeration.ColorEnum;
import com._2lazy2name.notion.enumeration.type.TextTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, property = "type")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextText.class, name = "text"),
        @JsonSubTypes.Type(value = EquationText.class, name = "equation"),
        @JsonSubTypes.Type(value = MentionText.class, name = "mention")
})
public abstract class AbstractRichText {
    protected TextTypeEnum type;
    private Annotation annotations;
    private String plainText;
    private String href;

    public static class Annotation {
        private Boolean bold;
        private Boolean italic;
        private Boolean strikethrough;
        private Boolean underline;
        private Boolean code;
        private ColorEnum color;

        public Boolean getBold() {
            return bold;
        }

        public Annotation setBold(Boolean bold) {
            this.bold = bold;
            return this;
        }

        public Boolean getItalic() {
            return italic;
        }

        public Annotation setItalic(Boolean italic) {
            this.italic = italic;
            return this;
        }

        public Boolean getStrikethrough() {
            return strikethrough;
        }

        public Annotation setStrikethrough(Boolean strikethrough) {
            this.strikethrough = strikethrough;
            return this;
        }

        public Boolean getUnderline() {
            return underline;
        }

        public Annotation setUnderline(Boolean underline) {
            this.underline = underline;
            return this;
        }

        public Boolean getCode() {
            return code;
        }

        public Annotation setCode(Boolean code) {
            this.code = code;
            return this;
        }

        public ColorEnum getColor() {
            return color;
        }

        public Annotation setColor(ColorEnum color) {
            this.color = color;
            return this;
        }
    }

    public AbstractRichText toggleBold() {
        if (annotations == null || annotations.getBold() == null) {
            this.annotations = new Annotation();
            this.annotations.setBold(true);
            return this;
        }
        annotations.setBold(!annotations.getBold());
        return this;
    }
    public AbstractRichText toggleItalic() {
        if (annotations == null || annotations.getItalic() == null) {
            this.annotations = new Annotation();
            this.annotations.setItalic(true);
            return this;
        }
        annotations.setItalic(!annotations.getItalic());
        return this;
    }
    public AbstractRichText toggleStrikethrough() {
        if (annotations == null || annotations.getStrikethrough() == null) {
            this.annotations = new Annotation();
            this.annotations.setStrikethrough(true);
            return this;
        }
        annotations.setStrikethrough(!annotations.getStrikethrough());
        return this;
    }
    public AbstractRichText toggleUnderline() {
        if (annotations == null) {
            this.annotations = new Annotation();
            this.annotations.setUnderline(true);
            return this;
        }
        annotations.setUnderline(!annotations.getUnderline());
        return this;
    }
    public AbstractRichText toggleCode() {
        if (annotations == null) {
            this.annotations = new Annotation();
            this.annotations.setCode(true);
            return this;
        }
        annotations.setCode(!annotations.getCode());
        return this;
    }
    public AbstractRichText setColor(ColorEnum color) {
        if (annotations == null) {
            this.annotations = new Annotation();
            this.annotations.setColor(color);
            return this;
        }
        annotations.setColor(color);
        return this;
    }

    public abstract TextTypeEnum getType();

    private AbstractRichText setType(TextTypeEnum type) {
        this.type = type;
        return this;
    }

    public Annotation getAnnotations() {
        return annotations;
    }

    private AbstractRichText setAnnotations(Annotation annotations) {
        this.annotations = annotations;
        return this;
    }

    public String getPlainText() {
        return plainText;
    }

    private AbstractRichText setPlainText(String plainText) {
        this.plainText = plainText;
        return this;
    }

    public String getHref() {
        return href;
    }

    public AbstractRichText setHref(String href) {
        this.href = href;
        return this;
    }
}
