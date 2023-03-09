package com._2lazy2name.notion.entity.common;

import com._2lazy2name.notion.enumeration.ObjectEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.List;

/**
 * TODO: Potential bug: The type object is not included in this class.
 * @author Yi
 * @since 2021/7/19
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaginationResult<T> {
    private ObjectEnum object;
    // Can be ObjectEnum or PropertyTypeEnum
    // For queryDatabase, it is ObjectEnum
    // For retrievePageProperties, it is PropertyTypeEnum
    private String type;
    private List<T> results;
    private String nextCursor;
    private boolean hasMore;

    @JsonIgnore
    public T getResult() {
        if (results == null || results.isEmpty()) {
            return null;
        }
        if (results.size() > 1) {
            System.err.println("Warning: More than one result is returned.");
        }
        return results.get(0);
    }

    public ObjectEnum getObject() {
        return object;
    }

    public PaginationResult<T> setObject(ObjectEnum object) {
        this.object = object;
        return this;
    }

    public String getType() {
        return type;
    }

    public PaginationResult<T> setType(String type) {
        this.type = type;
        return this;
    }

    public List<T> getResults() {
        return results;
    }

    public PaginationResult<T> setResults(List<T> results) {
        this.results = results;
        return this;
    }

    public String getNextCursor() {
        return nextCursor;
    }

    public PaginationResult<T> setNextCursor(String nextCursor) {
        this.nextCursor = nextCursor;
        return this;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public PaginationResult<T> setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
        return this;
    }
}
