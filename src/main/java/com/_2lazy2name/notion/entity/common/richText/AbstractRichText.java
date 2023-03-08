package com._2lazy2name.notion.entity.common.richText;

import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com._2lazy2name.notion.entity.enumeration.type.TextTypeEnum;
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

    public static TextText buildPlainText(String content) {
        return buildPlainText(content, null);
    }

    public static TextText buildPlainText(String content, String url) {
        TextText text = new TextText();
        TextText.Text _text = new TextText.Text();
        _text.setContent(content);
        if (url != null) {
            TextText.Link link = new TextText.Link();
            link.setUrl(url);
            _text.setLink(link);
            text.setHref(url);
        }
        text.setText(_text);
        return text;
    }

    // TODO: Add builder for User and Page Mention Text
   
    public static EquationText buildEquationText(String expression) {
        EquationText equation = new EquationText();
        EquationText.Equation _equation = new EquationText.Equation();
        _equation.setExpression(expression);
        equation.setEquation(_equation);
        return equation;
    }

    private void ifNullThenCreateAnnotations() {
        if (annotations == null) {
            annotations = new Annotation();
        }
        annotations.setColor(ColorEnum.DEFAULT);
    }
    public AbstractRichText toggleBold() {
        ifNullThenCreateAnnotations();
        annotations.setBold(!annotations.getBold());
        return this;
    }
    public AbstractRichText toggleItalic() {
        ifNullThenCreateAnnotations();
        annotations.setItalic(!annotations.getItalic());
        return this;
    }
    public AbstractRichText toggleStrikethrough() {
        ifNullThenCreateAnnotations();
        annotations.setStrikethrough(!annotations.getStrikethrough());
        return this;
    }
    public AbstractRichText toggleUnderline() {
        ifNullThenCreateAnnotations();
        annotations.setUnderline(!annotations.getUnderline());
        return this;
    }
    public AbstractRichText toggleCode() {
        ifNullThenCreateAnnotations();
        annotations.setCode(!annotations.getCode());
        return this;
    }
    public AbstractRichText setColor(ColorEnum color) {
        ifNullThenCreateAnnotations();
        annotations.setColor(color);
        return this;
    }

    public TextTypeEnum getType() {
        return type;
    }

    public AbstractRichText setType(TextTypeEnum type) {
        this.type = type;
        return this;
    }

    public Annotation getAnnotations() {
        return annotations;
    }

    public AbstractRichText setAnnotations(Annotation annotations) {
        this.annotations = annotations;
        return this;
    }

    public String getPlainText() {
        return plainText;
    }

    public AbstractRichText setPlainText(String plainText) {
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
