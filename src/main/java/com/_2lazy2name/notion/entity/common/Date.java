package com._2lazy2name.notion.entity.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.text.SimpleDateFormat;

/**
 * TODO: The official doc does not mention how the TimeZone String should work. It seems this value stay null all the time.
 * @author Yi
 * @version 1.0
 * @since 2023-02-01
 * @see <a href="https://en.wikipedia.org/wiki/ISO_8601">ISO_8601</a>
 */
@Getter @Setter @ToString
public class Date {
    private String start;
    private String end;
    private String timeZone;
    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    private Date() {
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
}
