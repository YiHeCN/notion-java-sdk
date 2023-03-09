package com._2lazy2name.notion.entity.common;

import com._2lazy2name.notion.entity.Database;
import com._2lazy2name.notion.entity.Page;
import com._2lazy2name.notion.enumeration.ObjectEnum;
import com.fasterxml.jackson.annotation.JsonSubTypes;

/**
 * This class is created and only for search method.
 * @author Yi
 * @since 2023-02-01
 * @version 1.0
 */
@JsonSubTypes({
        @JsonSubTypes.Type(value = Database.class, name = "database"),
        @JsonSubTypes.Type(value = Page.class, name = "page"),
})
public class PageOrDatabase {
    protected ObjectEnum object;
    protected PageOrDatabase() {}

    public boolean isDatabase() {
        return object == ObjectEnum.DATABASE;
    }
    public boolean isPage() {
        return object == ObjectEnum.PAGE;
    }
}
