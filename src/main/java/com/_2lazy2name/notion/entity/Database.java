package com._2lazy2name.notion.entity;

import com._2lazy2name.notion.entity.common.PageOrDatabase;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.common.parent.AbstractParent;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ObjectEnum;
import com._2lazy2name.notion.entity.property.database.AbstractDatabaseProperty;
import com._2lazy2name.notion.entity.common.icon.AbstractIcon;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter @ToString
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
}
