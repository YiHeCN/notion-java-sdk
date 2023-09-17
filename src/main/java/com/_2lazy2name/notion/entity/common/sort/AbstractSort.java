package com._2lazy2name.notion.entity.common.sort;

import com._2lazy2name.notion.enumeration.SortDirectionEnum;
import com._2lazy2name.notion.enumeration.TimeStampEnum;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/post-database-query-sort">Sort</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = EntryTimestampSort.class, name = "created_time"),
        @JsonSubTypes.Type(value = PropertyValueSort.class, name = "property")
})
public abstract class AbstractSort {
    protected SortDirectionEnum direction;

    protected AbstractSort() {
    }

    public static EntryTimestampSort buildEntryTimestampSort(TimeStampEnum timestamp, SortDirectionEnum direction) {
        return new EntryTimestampSort(timestamp, direction);
    }
    public static PropertyValueSort buildPropertyValueSort(String property, SortDirectionEnum direction) {
        return new PropertyValueSort(property, direction);
    }

    public SortDirectionEnum getDirection() {
        return direction;
    }

    public AbstractSort setDirection(SortDirectionEnum direction) {
        this.direction = direction;
        return this;
    }
}
