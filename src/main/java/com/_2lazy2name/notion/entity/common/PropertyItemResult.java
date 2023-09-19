package com._2lazy2name.notion.entity.common;

import com._2lazy2name.notion.enumeration.ObjectEnum;
import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * @author Yi
 * @since 2023/9/18
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyItemResult<T> {
    private ObjectEnum object;
    private String type;
    private List<T> results;
    private String nextCursor;
    private boolean hasMore;
    private PropertyItem propertyItem;

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

    public PropertyItemResult<T> setObject(ObjectEnum object) {
        this.object = object;
        return this;
    }

    public String getType() {
        return type;
    }

    public PropertyItemResult<T> setType(String type) {
        this.type = type;
        return this;
    }

    public List<T> getResults() {
        return results;
    }

    public PropertyItemResult<T> setResults(List<T> results) {
        this.results = results;
        return this;
    }

    public String getNextCursor() {
        return nextCursor;
    }

    public PropertyItemResult<T> setNextCursor(String nextCursor) {
        this.nextCursor = nextCursor;
        return this;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public PropertyItemResult<T> setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
        return this;
    }

    public PropertyItem getPropertyItem() {
        return propertyItem;
    }

    public PropertyItemResult<T> setPropertyItem(PropertyItem propertyItem) {
        this.propertyItem = propertyItem;
        return this;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PropertyItem {
        private String id;
        private PropertyTypeEnum type;

        public String getId() {
            return id;
        }

        public PropertyItem setId(String id) {
            this.id = id;
            return this;
        }

        public PropertyTypeEnum getType() {
            return type;
        }

        public PropertyItem setType(PropertyTypeEnum type) {
            this.type = type;
            return this;
        }
    }
}
