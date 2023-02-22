package com._2lazy2name.notion.entity;

import com._2lazy2name.notion.entity.common.PageOrDatabase;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.common.icon.AbstractIcon;
import com._2lazy2name.notion.entity.common.parent.AbstractParent;
import com._2lazy2name.notion.entity.property.page.AbstractPagePropertyValue;
import com._2lazy2name.notion.entity.enumeration.ObjectEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString @Getter @Setter
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
}
