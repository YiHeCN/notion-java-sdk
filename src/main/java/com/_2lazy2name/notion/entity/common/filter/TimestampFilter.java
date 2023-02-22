package com._2lazy2name.notion.entity.common.filter;

import com._2lazy2name.notion.entity.enumeration.DateFilterMethodEnum;
import com._2lazy2name.notion.entity.enumeration.TimeStampEnum;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString @Getter @Setter @NoArgsConstructor
@JsonSerialize(using = FilterSerializer.class)
public class TimestampFilter implements AbstractFilter {
    private TimeStampEnum timestamp;
    private DateFilterMethodEnum method;
    private Object value;

    public TimestampFilter(TimeStampEnum timestamp, DateFilterMethodEnum method, Object value) {
        this.timestamp = timestamp;
        this.value = value;
        this.method = method;
    }

    public TimestampFilter on(TimeStampEnum timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public TimestampFilter equals(Date value) {
        this.method = DateFilterMethodEnum.EQUALS;
        this.value = value;
        return this;
    }

    public TimestampFilter before(Date value) {
        this.method = DateFilterMethodEnum.BEFORE;
        this.value = value;
        return this;
    }

    public TimestampFilter after(Date value) {
        this.method = DateFilterMethodEnum.AFTER;
        this.value = value;
        return this;
    }

    public TimestampFilter onOrBefore(Date value) {
        this.method = DateFilterMethodEnum.ON_OR_BEFORE;
        this.value = value;
        return this;
    }

    public TimestampFilter onOrAfter(Date value) {
        this.method = DateFilterMethodEnum.ON_OR_AFTER;
        this.value = value;
        return this;
    }

    public TimestampFilter isEmpty() {
        this.method = DateFilterMethodEnum.IS_EMPTY;
        this.value = null;
        return this;
    }

    public TimestampFilter isNotEmpty() {
        this.method = DateFilterMethodEnum.IS_NOT_EMPTY;
        this.value = null;
        return this;
    }

    public TimestampFilter pastWeek() {
        this.method = DateFilterMethodEnum.PAST_WEEK;
        this.value = null;
        return this;
    }

    public TimestampFilter pastMonth() {
        this.method = DateFilterMethodEnum.PAST_MONTH;
        this.value = null;
        return this;
    }

    public TimestampFilter pastYear() {
        this.method = DateFilterMethodEnum.PAST_YEAR;
        this.value = null;
        return this;
    }

    public TimestampFilter thisWeek() {
        this.method = DateFilterMethodEnum.THIS_WEEK;
        this.value = null;
        return this;
    }

    public TimestampFilter nextWeek() {
        this.method = DateFilterMethodEnum.NEXT_WEEK;
        this.value = null;
        return this;
    }

    public TimestampFilter nextMonth() {
        this.method = DateFilterMethodEnum.NEXT_MONTH;
        this.value = null;
        return this;
    }

    public TimestampFilter nextYear() {
        this.method = DateFilterMethodEnum.NEXT_YEAR;
        this.value = null;
        return this;
    }
}
