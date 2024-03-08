package com._2lazy2name.notion.property.page;

import com._2lazy2name.notion.NotionTest;
import com._2lazy2name.notion.entity.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;

class CreatedByValueTest extends NotionTest {

    String json = """
            {
                "object": "page",
                "id": "62008259-e0fa-4f45-bdd0-eb0ea3920cc5",
                "created_time": "2023-04-06T16:03:00.000Z",
                "last_edited_time": "2023-04-06T16:03:00.000Z",
                "created_by": {
                    "object": "user",
                    "id": "a943b83f-a892-4886-93c8-8391161c58c4"
                },
                "last_edited_by": {
                    "object": "user",
                    "id": "a943b83f-a892-4886-93c8-8391161c58c4"
                },
                "cover": null,
                "icon": null,
                "parent": {
                    "type": "database_id",
                    "database_id": "d4916ab4-f18b-488c-b780-4fea423afd85"
                }
            }
            """;
    @Test
    public void test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
        System.out.println(objectMapper.readValue(json, Page.class));
    }
}