package com._2lazy2name.notion.entity.enumeration.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BlockTypeEnum {
    PARAGRAPH("paragraph"),
    BULLETED_LIST_ITEM("bulleted_list_item"),
    NUMBERED_LIST_ITEM("numbered_list_item"),
    TOGGLE("toggle"),
    TO_DO("to_do"),
    QUOTE("quote"),
    CALLOUT("callout"),
    SYNCED_BLOCK("synced_block"),
    TEMPLATE("template"),
    COLUMN("column"),
    CODE("code"),
    CHILD_PAGE("child_page"),
    CHILD_DATABASE("child_database"),
    TABLE("table"),
    HEADING_1("heading_1"),
    HEADING_2("heading_2"),
    HEADING_3("heading_3"),
    EMBED("embed"),
    IMAGE("image"),
    VIDEO("video"),
    FILE("file"),
    PDF("pdf"),
    BOOKMARK("bookmark"),
    LINK("link"),
    EQUATION("equation"),
    DIVIDER("divider"),
    TABLE_OF_CONTENTS("table_of_contents"),
    BREADCRUMB("breadcrumb"),
    COLUMN_LIST("column_list"),
    LINK_PREVIEW("link_preview"),
    LINK_TO_PAGE("link_to_page"),
    TABLE_ROW("table_row"),
    TABLE_CELL("table_cell");

    final String type;

    @JsonCreator
    BlockTypeEnum(String type) {
        this.type = type;
    }

    @Override
    @JsonValue
    public String toString() {
        return type;
    }
}
