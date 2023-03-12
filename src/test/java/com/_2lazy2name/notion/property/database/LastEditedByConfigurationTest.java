package com._2lazy2name.notion.property.database;

import com._2lazy2name.notion.NotionTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

class LastEditedByConfigurationTest extends NotionTest {
    @Test
    public void test() throws JsonProcessingException {
        LastEditedByConfiguration configuration = LastEditedByConfiguration.getInstance();
        System.out.println(objectMapper.writeValueAsString(configuration));
    }
}