package com._2lazy2name.notion.entity.common.filter.typeSpecific;

import com._2lazy2name.notion.entity.enumeration.DateFilterMethodEnum;
import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.common.filter.PropertyFilter;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class DateFilter extends PropertyFilter {
    private DateFilterMethodEnum method;

    public DateFilter(PropertyTypeEnum type, String property, DateFilterMethodEnum method, String value) {
        checkIfSupported(type);
        this.type = type;
        this.property = property;
        this.method = method;
        this.value = value;
    }

    public static void checkIfSupported(PropertyTypeEnum type) {
        if (type != PropertyTypeEnum.DATE && type != PropertyTypeEnum.LAST_EDITED_TIME && type != PropertyTypeEnum.CREATED_TIME) {
            throw new IllegalArgumentException("TextFilter is not supported for type " + type + ". SEE: https://developers.notion.com/reference/post-database-query-filter#date-filter-condition");
        }
    }

    public DateFilter on(PropertyTypeEnum type, String property) {
        checkIfSupported(type);
        this.type = type;
        this.property = property;
        return this;
    }

    public DateFilter equals(Date value) {
        this.method = DateFilterMethodEnum.EQUALS;
        this.value = value;
        return this;
    }

    public DateFilter before(Date value) {
        this.method = DateFilterMethodEnum.BEFORE;
        this.value = value;
        return this;
    }

    public DateFilter after(Date value) {
        this.method = DateFilterMethodEnum.AFTER;
        this.value = value;
        return this;
    }

    public DateFilter onOrBefore(Date value) {
        this.method = DateFilterMethodEnum.ON_OR_BEFORE;
        this.value = value;
        return this;
    }

    public DateFilter onOrAfter(Date value) {
        this.method = DateFilterMethodEnum.ON_OR_AFTER;
        this.value = value;
        return this;
    }

    public DateFilter isEmpty() {
        this.method = DateFilterMethodEnum.IS_EMPTY;
        this.value = null;
        return this;
    }

    public DateFilter isNotEmpty() {
        this.method = DateFilterMethodEnum.IS_NOT_EMPTY;
        this.value = null;
        return this;
    }

    public DateFilter pastWeek() {
        this.method = DateFilterMethodEnum.PAST_WEEK;
        this.value = null;
        return this;
    }

    public DateFilter pastMonth() {
        this.method = DateFilterMethodEnum.PAST_MONTH;
        this.value = null;
        return this;
    }

    public DateFilter pastYear() {
        this.method = DateFilterMethodEnum.PAST_YEAR;
        this.value = null;
        return this;
    }

    public DateFilter thisWeek() {
        this.method = DateFilterMethodEnum.THIS_WEEK;
        this.value = null;
        return this;
    }

    public DateFilter nextWeek() {
        this.method = DateFilterMethodEnum.NEXT_WEEK;
        this.value = null;
        return this;
    }

    public DateFilter nextMonth() {
        this.method = DateFilterMethodEnum.NEXT_MONTH;
        this.value = null;
        return this;
    }

    public DateFilter nextYear() {
        this.method = DateFilterMethodEnum.NEXT_YEAR;
        this.value = null;
        return this;
    }


}
