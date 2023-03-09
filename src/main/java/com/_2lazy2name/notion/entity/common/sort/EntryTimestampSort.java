package com._2lazy2name.notion.entity.common.sort;

import com._2lazy2name.notion.enumeration.SortDirectionEnum;
import com._2lazy2name.notion.enumeration.TimeStampEnum;


/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/post-database-query-sort#entry-timestamp-sort">Entry Timestamp Sort</a>
 */
public class EntryTimestampSort extends AbstractSort {
    private TimeStampEnum timestamp;

    private EntryTimestampSort() {
    }

    public EntryTimestampSort(TimeStampEnum timestamp, SortDirectionEnum direction) {
        EntryTimestampSort entryTimestampSort = new EntryTimestampSort();
        entryTimestampSort.setTimestamp(timestamp);
        entryTimestampSort.setDirection(direction);
    }

    public TimeStampEnum getTimestamp() {
        return timestamp;
    }

    public EntryTimestampSort setTimestamp(TimeStampEnum timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}
