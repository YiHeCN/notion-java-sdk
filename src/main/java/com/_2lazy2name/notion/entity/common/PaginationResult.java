package com._2lazy2name.notion.entity.common;

import com._2lazy2name.notion.entity.enumeration.ObjectEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
}
