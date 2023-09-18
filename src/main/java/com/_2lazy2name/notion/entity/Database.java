package com._2lazy2name.notion.entity;

import com._2lazy2name.notion.entity.common.PageOrDatabase;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.common.parent.AbstractParent;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.enumeration.ObjectEnum;
import com._2lazy2name.notion.property.database.AbstractDatabaseProperty;
import com._2lazy2name.notion.entity.common.icon.AbstractIcon;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
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
    private String publicUrl;

    private Database() {}

    public ObjectEnum getObject() {
        return object;
    }

    public String getId() {
        return id;
    }

    private Database setId(String id) {
        this.id = id;
        return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    private Database setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    private Database setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Date getLastEditedTime() {
        return lastEditedTime;
    }

    private Database setLastEditedTime(Date lastEditedTime) {
        this.lastEditedTime = lastEditedTime;
        return this;
    }

    public User getLastEditedBy() {
        return lastEditedBy;
    }

    private Database setLastEditedBy(User lastEditedBy) {
        this.lastEditedBy = lastEditedBy;
        return this;
    }

    public List<AbstractRichText> getTitle() {
        return title;
    }

    private Database setTitle(List<AbstractRichText> title) {
        this.title = title;
        return this;
    }

    public List<AbstractRichText> getDescription() {
        return description;
    }

    private Database setDescription(List<AbstractRichText> description) {
        this.description = description;
        return this;
    }

    public AbstractIcon getIcon() {
        return icon;
    }

    private Database setIcon(AbstractIcon icon) {
        this.icon = icon;
        return this;
    }

    public AbstractFile getCover() {
        return cover;
    }

    private Database setCover(AbstractFile cover) {
        this.cover = cover;
        return this;
    }

    public LinkedHashMap<String, AbstractDatabaseProperty> getProperties() {
        return properties;
    }

    private Database setProperties(LinkedHashMap<String, AbstractDatabaseProperty> properties) {
        this.properties = properties;
        return this;
    }

    public AbstractParent getParent() {
        return parent;
    }

    private Database setParent(AbstractParent parent) {
        this.parent = parent;
        return this;
    }

    public String getUrl() {
        return url;
    }

    private Database setUrl(String url) {
        this.url = url;
        return this;
    }

    public Boolean getArchived() {
        return archived;
    }

    private Database setArchived(Boolean archived) {
        this.archived = archived;
        return this;
    }

    public Boolean isInline() {
        return isInline;
    }

    public Database setIsInline(Boolean inline) {
        isInline = inline;
        return this;
    }

    public String getNextCursor() {
        return nextCursor;
    }

    private Database setNextCursor(String nextCursor) {
        this.nextCursor = nextCursor;
        return this;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    private Database setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
        return this;
    }

    public String getPublicUrl() {
        return publicUrl;
    }

    public Database setPublicUrl(String publicUrl) {
        this.publicUrl = publicUrl;
        return this;
    }
}
