package com._2lazy2name.notion;

import com._2lazy2name.notion.entity.Database;
import com._2lazy2name.notion.entity.Page;
import com._2lazy2name.notion.entity.common.parent.AbstractParent;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.enumeration.ColorEnum;
import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.common.filter.typeSpecific.TextFilter;
import com._2lazy2name.notion.entity.common.PaginationResult;
import com._2lazy2name.notion.property.database.AbstractDatabaseProperty;
import com._2lazy2name.notion.property.database.SelectOption;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

class NotionDatabaseTest extends NotionTest {
    private final static String userId = "";
    private final static String databaseId = "c302f709af294024b8c4aeba6641913b";
    private final static String pageId = "dbe879bb458844f5b8bfa17ca5374dfc";

    @Test
    void queryDatabase() throws IOException {
        PaginationResult<Page> result = notion.queryDatabase(databaseId);
        System.out.println(result);
    }

    @Test
    void queryDatabaseWithFilter() throws IOException {
        TextFilter filter = new TextFilter();
        filter.on(PropertyTypeEnum.TITLE, "title").contains("test");
        PaginationResult<Page> result = notion.queryDatabase(databaseId, filter);
        System.out.println(result);
    }

    @Test
    void queryDatabaseWithPagination() throws IOException {
        PaginationResult<Page> result;
        String nextCursor = null;
        int pageSize = 1;
        do {
            result = notion.queryDatabase(databaseId, pageSize, nextCursor);
            nextCursor = result.getNextCursor();
            System.out.println(result);
        } while (result.isHasMore());
    }


    @Test
    public void createDatabase() throws IOException {
        AbstractRichText text = AbstractRichText.buildPlainText("test");
        Map<String, AbstractDatabaseProperty> properties = new HashMap<>();
        properties.put("testUrl", AbstractDatabaseProperty.buildUrlProperty());
        properties.put("testFormula", AbstractDatabaseProperty.buildFormulaProperty("1+1"));
        properties.put("testCheckbox", AbstractDatabaseProperty.buildCheckboxProperty());
        List<SelectOption> options = new ArrayList<>() {{
            add(new SelectOption("test", ColorEnum.getRandomColor()));
            add(new SelectOption("test2", ColorEnum.getRandomColor()));
        }};
        properties.put("testSelect", AbstractDatabaseProperty.buildSelectProperty(options));
        AbstractParent parent = AbstractParent.buildPageParent(pageId);
        notion.createDatabase(parent, "title", List.of(text), properties);
    }

    @Test
    public void updateDatabaseTitle() throws IOException {
        notion.updateDatabaseTitle(databaseId, "new title");
    }

    @Test
    public void updateDatabaseDescription() throws IOException {
        notion.updateDatabaseDescription(databaseId, "new description");
    }

    @Test
    public void updateDatabaseProperties() throws IOException {
        notion.updateDatabaseProperties(databaseId, Map.of("testTwootherUrl", AbstractDatabaseProperty.buildUrlProperty()));
    }

    @Test
    public void removeDatabaseProperty() throws IOException {
        notion.removeDatabaseProperty(databaseId, "testTwootherUrl");
    }

    @Test
    public void renameDatabaseProperty() throws IOException {
        notion.renameDatabaseProperty(databaseId, "url", "url");
    }

    @Test
    public void retrieveDatabase() throws IOException {
        Database database = notion.retrieveDatabase(databaseId);
        System.out.println(database);
    }
}