package com._2lazy2name.notion;

import com._2lazy2name.notion.entity.common.PaginationResult;
import com._2lazy2name.notion.entity.common.PropertyItemResult;
import com._2lazy2name.notion.entity.common.parent.DatabaseParent;
import com._2lazy2name.notion.entity.common.parent.PageParent;
import com._2lazy2name.notion.property.page.AbstractPagePropertyValue;
import com._2lazy2name.notion.property.page.CheckboxValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

class NotionPageTest extends NotionTest {
    private final static String userId = "";
    private final static String databaseId = "c302f709af294024b8c4aeba6641913b";
    private final static String pageId = "11b5edb7-fdc6-4a44-9a9f-a1e61c1ba52e";
    public static final String createdPageId = "5871f556ff2f4090b100a238555431ae";
    public static final String propertyId = "@mrQ";

    @Test
    public void createPageWithPageParent() throws IOException  {
        PageParent parent = new PageParent(createdPageId);
        System.out.println(notion.createPage(parent, "Test Page"));
    }

    @Test
    public void createPageWithDatabaseParent() throws IOException {
        DatabaseParent parent = new DatabaseParent(databaseId);
        AbstractPagePropertyValue select = new CheckboxValue(true);
        System.out.println(notion.createPage(parent, "Test Page", Map.of("Tags", select), null, null, null));
    }

    @Test
    public void retrievePagePropertyValue() throws IOException {
        System.out.println(notion.retrievePageProperty(pageId, propertyId));
    }

    @Test
    public void des() throws IOException {
        String s = """
                {
                    "object": "list",
                    "results": [
                        {
                            "object": "property_item",
                            "type": "relation",
                            "id": "%40mrQ",
                            "relation": {
                                "id": "3ab936cc-9846-4b06-ad71-8bfc786a3b08"
                            }
                        },
                        {
                            "object": "property_item",
                            "type": "relation",
                            "id": "%40mrQ",
                            "relation": {
                                "id": "fdd34885-2986-40e2-86d0-fec4e5333df1"
                            }
                        }
                    ],
                    "next_cursor": null,
                    "has_more": false,
                    "type": "property_item",
                    "property_item": {
                        "id": "%40mrQ",
                        "next_url": null,
                        "type": "relation",
                        "relation": {
                        
                        }
                    },
                    "developer_survey": "https://notionup.typeform.com/to/bllBsoI4?utm_source=postman"
                }
                """;
        objectMapper.readValue(s, objectMapper.getTypeFactory().constructParametricType(PropertyItemResult.class, AbstractPagePropertyValue.class));
    }
}