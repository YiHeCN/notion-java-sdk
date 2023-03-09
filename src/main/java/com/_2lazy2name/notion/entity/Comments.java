package com._2lazy2name.notion.entity;

import com._2lazy2name.notion.entity.common.parent.AbstractParent;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.common.richText.TextText;
import com._2lazy2name.notion.enumeration.ObjectEnum;
import com.fasterxml.jackson.annotation.JsonInclude;


import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
        this.richText = List.of(new TextText(text));
    }

    public Comments(String discussionId, List<AbstractRichText> richText) {
        this.discussionId = discussionId;
        this.richText = richText;
    }
    public Comments(String discussionId, String text) {
        this.discussionId = discussionId;
        this.richText = List.of(new TextText(text));
    }

    public String getId() {
        return id;
    }

    private Comments setId(String id) {
        this.id = id;
        return this;
    }

    public AbstractParent getParent() {
        return parent;
    }

    private Comments setParent(AbstractParent parent) {
        this.parent = parent;
        return this;
    }

    public String getDiscussionId() {
        return discussionId;
    }

    private Comments setDiscussionId(String discussionId) {
        this.discussionId = discussionId;
        return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    private Comments setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public Date getLastEditedTime() {
        return lastEditedTime;
    }

    private Comments setLastEditedTime(Date lastEditedTime) {
        this.lastEditedTime = lastEditedTime;
        return this;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    private Comments setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public User getLastEditedBy() {
        return lastEditedBy;
    }

    private Comments setLastEditedBy(User lastEditedBy) {
        this.lastEditedBy = lastEditedBy;
        return this;
    }

    public List<AbstractRichText> getRichText() {
        return richText;
    }

    private Comments setRichText(List<AbstractRichText> richText) {
        this.richText = richText;
        return this;
    }
}
