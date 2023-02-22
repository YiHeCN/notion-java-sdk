package com._2lazy2name.notion.entity.common.richText;

import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com._2lazy2name.notion.entity.enumeration.type.TextTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, property = "type")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextText.class, name = "text"),
        @JsonSubTypes.Type(value = EquationText.class, name = "equation"),
        @JsonSubTypes.Type(value = MentionText.class, name = "mention")
})
@ToString @Getter @Setter
public abstract class AbstractRichText {
    protected TextTypeEnum type;
    private Annotation annotations;
    private String plainText;
    private String href;

    @ToString @Getter @Setter
    public static class Annotation {
        private Boolean bold;
        private Boolean italic;
        private Boolean strikethrough;
        private Boolean underline;
        private Boolean code;
        private ColorEnum color;
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

//    public static MentionText buildUserMentionText(String userId) {
//        MentionText mention = new MentionText();
//        UserMention _mention = new UserMention();
//        User user = new User();
//        user.setId(userId);
//        _mention.setUser(user);
//        mention.setMention(_mention);
//        return mention;
//    }
//    public static MentionText buildPageMentionText(String pageId) {
//        MentionText mention = new MentionText();
//        PageMention _mention = new PageMention();
//        Page page = new Page();
//        page.setId(pageId);
//        _mention.setPage(page);
//        mention.setMention(_mention);
//        mention.setHref("https://www.notion.so/" + pageId);
//        return mention;
//    }
   
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
}
