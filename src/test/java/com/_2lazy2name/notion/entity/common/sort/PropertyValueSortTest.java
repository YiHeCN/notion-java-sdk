package com._2lazy2name.notion.entity.common.sort;

import com._2lazy2name.notion.NotionTest;
import com._2lazy2name.notion.enumeration.SortDirectionEnum;
import com.fasterxml.jackson.core.JsonProcessingException;

import static org.junit.jupiter.api.Assertions.*;

class PropertyValueSortTest extends NotionTest {

    @org.junit.jupiter.api.Test
    void getProperty() throws JsonProcessingException {
        PropertyValueSort sort = AbstractSort.buildPropertyValueSort("Created time", SortDirectionEnum.DESCENDING);
        String s = objectMapper.writeValueAsString(sort);
        System.out.println(s);

    }

    @org.junit.jupiter.api.Test
    void setProperty() {
    }
}