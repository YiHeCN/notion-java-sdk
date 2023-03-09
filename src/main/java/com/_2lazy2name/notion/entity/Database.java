package com._2lazy2name.notion.entity;

import com._2lazy2name.notion.entity.common.PageOrDatabase;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.common.parent.AbstractParent;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.enumeration.ObjectEnum;
import com._2lazy2name.notion.property.database.AbstractDatabaseProperty;
import com._2lazy2name.notion.entity.common.icon.AbstractIcon;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Database extends PageOrDatabase {
    private final ObjectEnum object = ObjectEnum.DATABASE;
    private String id;
    private Date createdTime;
    private User createdBy;
    private Date lastEditedTime;
    private User lastEditedBy;
    private List<AbstractRichText> title;
    private List<AbstractRichText> description;
    private AbstractIcon icon;
    private AbstractFile cover;
    private LinkedHashMap<String, AbstractDatabaseProperty> properties;
    private AbstractParent parent;
    private String url;
    private Boolean archived;
    private Boolean isInline;
    private String nextCursor;
    private Boolean hasMore;

    private Database() {}

    public ObjectEnum getObject() {
        return object;
    }

    public String getId() {
        return id;
    }

    public Database setId(String id) {
        this.id = id;
        return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Database setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Database setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Date getLastEditedTime() {
        return lastEditedTime;
    }

    public Database setLastEditedTime(Date lastEditedTime) {
        this.lastEditedTime = lastEditedTime;
        return this;
    }

    public User getLastEditedBy() {
        return lastEditedBy;
    }

    public Database setLastEditedBy(User lastEditedBy) {
        this.lastEditedBy = lastEditedBy;
        return this;
    }

    public List<AbstractRichText> getTitle() {
        return title;
    }

    public Database setTitle(List<AbstractRichText> title) {
        this.title = title;
        return this;
    }

    public List<AbstractRichText> getDescription() {
        return description;
    }

    public Database setDescription(List<AbstractRichText> description) {
        this.description = description;
        return this;
    }

    public AbstractIcon getIcon() {
        return icon;
    }

    public Database setIcon(AbstractIcon icon) {
        this.icon = icon;
        return this;
    }

    public AbstractFile getCover() {
        return cover;
    }

    public Database setCover(AbstractFile cover) {
        this.cover = cover;
        return this;
    }

    public LinkedHashMap<String, AbstractDatabaseProperty> getProperties() {
        return properties;
    }

    public Database setProperties(LinkedHashMap<String, AbstractDatabaseProperty> properties) {
        this.properties = properties;
        return this;
    }

    public AbstractParent getParent() {
        return parent;
    }

    public Database setParent(AbstractParent parent) {
        this.parent = parent;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Database setUrl(String url) {
        this.url = url;
        return this;
    }

    public Boolean getArchived() {
        return archived;
    }

    public Database setArchived(Boolean archived) {
        this.archived = archived;
        return this;
    }

    public Boolean getInline() {
        return isInline;
    }

    public Database setInline(Boolean inline) {
        isInline = inline;
        return this;
    }

    public String getNextCursor() {
        return nextCursor;
    }

    public Database setNextCursor(String nextCursor) {
        this.nextCursor = nextCursor;
        return this;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public Database setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
        return this;
    }
}
