package com._2lazy2name.notion;

import com._2lazy2name.notion.entity.Database;
import com._2lazy2name.notion.entity.Page;
import com._2lazy2name.notion.entity.common.parent.AbstractParent;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.ColorEnum;
import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.common.filter.typeSpecific.TextFilter;
import com._2lazy2name.notion.entity.common.PaginationResult;
import com._2lazy2name.notion.entity.property.database.AbstractDatabaseProperty;
import com._2lazy2name.notion.entity.property.database.SelectOption;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.*;

class NotionDatabaseTest extends NotionTest {
    private final static String userId = "";
    private final static String databaseId = "c302f709af294024b8c4aeba6641913b";
    private final static String pageId = "997f8953ebc144199dd08fbefe8c09a2";

    @Test @SneakyThrows
    void queryDatabase() {
        PaginationResult<Page> result = notion.queryDatabase(databaseId);
        System.out.println(result);
    }

    @Test @SneakyThrows
    void queryDatabaseWithFilter() {
        TextFilter filter = new TextFilter();
        filter.on(PropertyTypeEnum.TITLE, "title").contains("test");
        PaginationResult<Page> result = notion.queryDatabase(databaseId, filter);
        System.out.println(result);
    }

    @Test @SneakyThrows
    void queryDatabaseWithPagination() {
        PaginationResult<Page> result;
        String nextCursor = null;
        int pageSize = 1;
        do {
            result = notion.queryDatabase(databaseId, pageSize, nextCursor);
            nextCursor = result.getNextCursor();
            System.out.println(result);
        } while (result.isHasMore());
    }


    @Test @SneakyThrows
    public void createDatabase() {
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

    @Test @SneakyThrows
    public void updateDatabaseTitle() {
        notion.updateDatabaseTitle(databaseId, "new title");
    }

    @Test @SneakyThrows
    public void updateDatabaseDescription() {
        notion.updateDatabaseDescription(databaseId, "new description");
    }

    @Test @SneakyThrows
    public void updateDatabaseProperties() {
        notion.updateDatabaseProperties(databaseId, Map.of("testTwootherUrl", AbstractDatabaseProperty.buildUrlProperty()));
    }

    @Test @SneakyThrows
    public void removeDatabaseProperty() {
        notion.removeDatabaseProperty(databaseId, "testTwootherUrl");
    }

    @Test @SneakyThrows
    public void renameDatabaseProperty() {
        notion.renameDatabaseProperty(databaseId, "url", "url");
    }

    @Test @SneakyThrows
    public void retrieveDatabase() {
        Database database = notion.retrieveDatabase(databaseId);
        System.out.println(database);
    }
}