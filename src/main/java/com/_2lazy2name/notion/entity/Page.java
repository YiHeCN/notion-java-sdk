package com._2lazy2name.notion.entity;

import com._2lazy2name.notion.entity.common.PageOrDatabase;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.common.icon.AbstractIcon;
import com._2lazy2name.notion.entity.common.parent.AbstractParent;
import com._2lazy2name.notion.entity.property.page.AbstractPagePropertyValue;
import com._2lazy2name.notion.entity.enumeration.ObjectEnum;
import com.fasterxml.jackson.annotation.JsonInclude;


import java.util.Date;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Page extends PageOrDatabase {
    private final ObjectEnum object = ObjectEnum.PAGE;
    private String id;
    private Date createdTime;
    private Date lastEditedTime;
    private User createdBy;
    private User lastEditedBy;
    private Boolean archived;
    private AbstractIcon icon;
    private AbstractFile cover;
    private Map<String, AbstractPagePropertyValue> properties;
    private AbstractParent parent;
    private String url;
    private String nextCursor;
    private Boolean hasMore;

    private Page() {}

    public ObjectEnum getObject() {
        return object;
    }

    public String getId() {
        return id;
    }

    public Page setId(String id) {
        this.id = id;
        return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Page setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public Date getLastEditedTime() {
        return lastEditedTime;
    }

    public Page setLastEditedTime(Date lastEditedTime) {
        this.lastEditedTime = lastEditedTime;
        return this;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Page setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public User getLastEditedBy() {
        return lastEditedBy;
    }

    public Page setLastEditedBy(User lastEditedBy) {
        this.lastEditedBy = lastEditedBy;
        return this;
    }

    public Boolean getArchived() {
        return archived;
    }

    public Page setArchived(Boolean archived) {
        this.archived = archived;
        return this;
    }

    public AbstractIcon getIcon() {
        return icon;
    }

    public Page setIcon(AbstractIcon icon) {
        this.icon = icon;
        return this;
    }

    public AbstractFile getCover() {
        return cover;
    }

    public Page setCover(AbstractFile cover) {
        this.cover = cover;
        return this;
    }

    public Map<String, AbstractPagePropertyValue> getProperties() {
        return properties;
    }

    public Page setProperties(Map<String, AbstractPagePropertyValue> properties) {
        this.properties = properties;
        return this;
    }

    public AbstractParent getParent() {
        return parent;
    }

    public Page setParent(AbstractParent parent) {
        this.parent = parent;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Page setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getNextCursor() {
        return nextCursor;
    }

    public Page setNextCursor(String nextCursor) {
        this.nextCursor = nextCursor;
        return this;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public Page setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
        return this;
    }
}
