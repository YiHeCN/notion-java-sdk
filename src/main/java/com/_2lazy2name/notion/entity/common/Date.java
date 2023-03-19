package com._2lazy2name.notion.entity.common;



import com.fasterxml.jackson.annotation.JsonInclude;

import java.text.SimpleDateFormat;

/**
 * TODO: The official doc does not mention how the TimeZone String should work. It seems this value stay null all the time.
 * @author Yi
 * @version 1.0
 * @since 2023-02-01
 * @see <a href="https://en.wikipedia.org/wiki/ISO_8601">ISO_8601</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Date {
    private String start;
    private String end;
    private String timeZone;
    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    private Date() {
    }

    public Date(String start) {
        this.start = start;
    }

    public Date(java.util.Date start) {
        this.start = DATE_FORMAT.format(start);
    }

    public Date(String start, String end, String timeZone) {
        this.start = start;
        this.end = end;
        this.timeZone = timeZone;
    }

    public Date(java.util.Date start, java.util.Date end, String timeZone) {
        this.start = DATE_FORMAT.format(start);
        this.end = DATE_FORMAT.format(end);
        this.timeZone = timeZone;
    }

    public String getStart() {
        return start;
    }

    public Date setStart(String start) {
        this.start = start;
        return this;
    }

    public String getEnd() {
        return end;
    }

    public Date setEnd(String end) {
        this.end = end;
        return this;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public Date setTimeZone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    public static SimpleDateFormat getDateFormat() {
        return DATE_FORMAT;
    }

    public static void setDateFormat(SimpleDateFormat dateFormat) {
        DATE_FORMAT = dateFormat;
    }
}
