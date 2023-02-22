package com._2lazy2name.notion.entity.common.sort;

import com._2lazy2name.notion.entity.enumeration.SortDirectionEnum;
import com._2lazy2name.notion.entity.enumeration.TimeStampEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/post-database-query-sort">Sort</a>
 */
@ToString @Getter @Setter
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

}
