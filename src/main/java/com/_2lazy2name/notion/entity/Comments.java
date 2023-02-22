package com._2lazy2name.notion.entity;

import com._2lazy2name.notion.entity.common.parent.AbstractParent;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ObjectEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString @Getter @Setter
public class Comments {
    private final static ObjectEnum objectEnum = ObjectEnum.COMMENTS;
    private String id;
    private AbstractParent parent;
    private String discussionId;
    private Date createdTime;
    private Date lastEditedTime;
    private User createdBy;
    private User lastEditedBy;
    private List<AbstractRichText> richText;

    private Comments() {}
    public Comments(AbstractParent parent, List<AbstractRichText> richText) {
        this.parent = parent;
        this.richText = richText;
    }
    public Comments(AbstractParent parent, String text) {
        this.parent = parent;
        this.richText = List.of(AbstractRichText.buildPlainText(text));
    }

    public Comments(String discussionId, List<AbstractRichText> richText) {
        this.discussionId = discussionId;
        this.richText = richText;
    }
    public Comments(String discussionId, String text) {
        this.discussionId = discussionId;
        this.richText = List.of(AbstractRichText.buildPlainText(text));
    }
}
