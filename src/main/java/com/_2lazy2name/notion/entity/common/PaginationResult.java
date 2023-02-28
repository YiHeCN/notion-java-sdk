package com._2lazy2name.notion.entity.common;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.enumeration.ObjectEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Iterator;
import java.util.List;

/**
 * TODO: Potential bug: The type object is not included in this class.
 * @author Yi
 * @since 2021/7/19
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter @ToString
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
}
