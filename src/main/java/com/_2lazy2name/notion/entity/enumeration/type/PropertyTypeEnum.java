package com._2lazy2name.notion.entity.enumeration.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PropertyTypeEnum {
    RICH_TEXT("rich_text"),
    NUMBER("number"),
    SELECT("select"),
    MULTI_SELECT("multi_select"),
    STATUS("status"),
    DATE("date"),
    FORMULA("formula"),
    RELATION("relation"),
    ROLLUP("rollup"),
    TITLE("title"),
    PEOPLE("people"),
    FILES("files"),
    CHECKBOX("checkbox"),
    URL("url"),
    EMAIL("email"),
    PHONE_NUMBER("phone_number"),
    CREATED_TIME("created_time"),
    CREATED_BY("created_by"),
    LAST_EDITED_TIME("last_edited_time"),
    LAST_EDITED_BY("last_edited_by");

    final String type;

    @JsonCreator
    PropertyTypeEnum(String type) {
        this.type = type;
    }

    @JsonValue
    public String toString() {
        return type;
    }
}
