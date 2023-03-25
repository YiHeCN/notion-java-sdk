package com._2lazy2name.notion;

import com._2lazy2name.notion.entity.Comments;
import com._2lazy2name.notion.entity.Database;
import com._2lazy2name.notion.entity.Page;
import com._2lazy2name.notion.entity.User;
import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.common.Date;
import com._2lazy2name.notion.entity.common.PageOrDatabase;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.common.parent.AbstractParent;
import com._2lazy2name.notion.entity.common.parent.DatabaseParent;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.common.filter.AbstractFilter;
import com._2lazy2name.notion.entity.common.PaginationResult;
import com._2lazy2name.notion.entity.common.richText.TextText;
import com._2lazy2name.notion.property.database.*;
import com._2lazy2name.notion.property.page.AbstractPagePropertyValue;
import com._2lazy2name.notion.entity.common.sort.AbstractSort;
import com._2lazy2name.notion.entity.common.icon.AbstractIcon;
import com._2lazy2name.notion.property.page.TitleValue;
import com._2lazy2name.util.HttpUtil;
import com._2lazy2name.util.NotionHttpUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * The main class of the Notion API. Contains all the methods in the page.
 * Some methods are with more concrete names, such as {@link #updateDatabaseDescription(String, List)}, for convenience.
 * You could get the specific usage from {@link }.
 * @author Yi
 * @version 1.0
 * @since 2023-02-01
 * @see <a href="https://developers.notion.com/reference/intro">Notion API</a>
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Notion {
    private final static String API_VERSION = "2022-06-28";
    private final static String API_URL = "https://api.notion.com/v1/";
    private final static ObjectMapper objectMapper;
    private final NotionHttpUtil httpUtil;

    /**
     * Get pages contained in the database. Overloaded methods are provided for convenience.
     * @param databaseId The ID of the database to retrieve.
     * @param filter The filter to apply to the query.
     * @param sorts The sort to apply to the query.
     * @param pageSize The number of results to return per page. Set any number between 1 and 100.
     *                 <0 means no limit. >100 causes an exception.
     * @param startCursor The cursor to use to retrieve the next page of results.
     *                    At the first page, this should be set to null.
     * @return PaginationResult contains next cursor and pages.
     * @see <a href="https://developers.notion.com/reference/post-database-query">Query a database</a>
     */
    public PaginationResult<Page> queryDatabase(String databaseId, AbstractFilter filter, AbstractSort sorts,
                                                int pageSize, String startCursor) throws IOException {
        String queryDatabaseUrl = API_URL + "databases/" + databaseId + "/query";
        QueryDatabaseBodyParam bodyParams = new QueryDatabaseBodyParam();
        bodyParams.setFilter(filter).setSorts(sorts).setPageSize(pageSize).setStartCursor(startCursor);
        String body = objectMapper.writeValueAsString(bodyParams);
        String response = httpUtil.post(queryDatabaseUrl, body).getBody();
        return objectMapper.readValue(response, objectMapper.getTypeFactory().constructParametricType(PaginationResult.class, Page.class));
    }
    public PaginationResult<Page> queryDatabase(String databaseId) throws IOException {
        return queryDatabase(databaseId, null, null, -1, null);
    }
    public PaginationResult<Page> queryDatabase(String databaseId, AbstractFilter filter) throws IOException {
        return queryDatabase(databaseId, filter, null, -1, null);
    }
    public PaginationResult<Page> queryDatabase(String databaseId, AbstractSort sorts) throws IOException {
        return queryDatabase(databaseId, null, sorts, -1, null);
    }
    public PaginationResult<Page> queryDatabase(String databaseId, int pageSize, String startCursor) throws IOException {
        return queryDatabase(databaseId, null, null, pageSize, startCursor);
    }
    public PaginationResult<Page> queryDatabase(String databaseId, AbstractFilter filter, AbstractSort sorts) throws IOException {
        return queryDatabase(databaseId, filter, sorts, -1, null);
    }
    public PaginationResult<Page> queryDatabase(String databaseId, AbstractFilter filter, int pageSize, String startCursor) throws IOException {
        return queryDatabase(databaseId, filter, null, pageSize, startCursor);
    }
    public PaginationResult<Page> queryDatabase(String databaseId, AbstractSort sorts, int pageSize, String startCursor) throws IOException {
        return queryDatabase(databaseId, null, sorts, pageSize, startCursor);
    }

    /**
     * TODO: I'm not sure how to create an inline block database in a page. Find a way to do it.
     * Create Database. The database will appear as a new page. String parameter overload for title and description are provided for convenience.
     * @param parent The parent of the database.
     * @param titlePropertyName The name of the title property.
     * @param dataBaseTitle The title of the database.
     * @param properties The properties of the database.
     * @return database you created.
     * @see <a href="https://developers.notion.com/reference/create-a-database">Create a database</a>
     */
    public Database createDatabase(AbstractParent parent,
                                   String titlePropertyName,
                                   List<AbstractRichText> dataBaseTitle,
                                   Map<String, AbstractDatabaseProperty> properties) throws IOException {
        String createDatabaseUrl = API_URL + "databases";
        CreateDatabaseBodyParam bodyParams = new CreateDatabaseBodyParam();
        bodyParams.setParent(parent).setTitlePropertyName(titlePropertyName).setTitle(dataBaseTitle).setProperties(properties);
        String body = objectMapper.writeValueAsString(bodyParams);
        String response = httpUtil.post(createDatabaseUrl, body).getBody();
        return objectMapper.readValue(response, Database.class);
    }
    public Database createDatabase(AbstractParent parent,
                                   String titlePropertyName,
                                   String dataBaseTitle,
                                   Map<String, AbstractDatabaseProperty> properties) throws IOException {
        return createDatabase(parent, titlePropertyName, List.of(new TextText(dataBaseTitle)), properties);
    }

    /**
     * Update a database. For adding new property, the Map name is the property name, and the value is the property.
     * For renaming property, the Map name is the property ID, and the value is the new property name.
     * For deleting property, the Map name is the property ID, and the value is null.
     * @param databaseId The ID of the database to update.
     * @param title The title of the database.
     * @param description The description of the database.
     * @param properties The properties of the database.
     * @return database.
     * @see <a href="https://developers.notion.com/reference/update-a-databasee">Update a database</a>
     * @see <a href="https://developers.notion.com/reference/update-property-schema-object">Update property schema object</a>
     */

    public Database updateDatabase(String databaseId,
                                   List <AbstractRichText> title,
                                   List<AbstractRichText> description,
                                   Map<String, AbstractDatabaseProperty> properties) throws IOException {
        String patchDatabaseUrl = API_URL + "databases/" + databaseId;
        UpdateDatabaseBodyParam bodyParams = new UpdateDatabaseBodyParam();
        bodyParams.setTitle(title).setDescription(description).setProperties(properties);
        String body = objectMapper.writeValueAsString(bodyParams);
        String response = httpUtil.patch(patchDatabaseUrl, body).getBody();
        return objectMapper.readValue(response, Database.class);
    }
    public Database updateDatabaseTitle(String databaseId, List<AbstractRichText> title) throws IOException {
        return updateDatabase(databaseId, title, null, null);
    }
    public Database updateDatabaseTitle(String databaseId, String title) throws IOException {
        return updateDatabase(databaseId, List.of(new TextText(title)), null, null);
    }
    public Database updateDatabaseDescription(String databaseId, List<AbstractRichText> description) throws IOException {
        return updateDatabase(databaseId, null, description, null);
    }
    public Database updateDatabaseDescription(String databaseId, String description) throws IOException {
        return updateDatabase(databaseId, null, List.of(new TextText(description)), null);
    }
    public Database updateDatabaseProperties(String databaseId, Map<String, AbstractDatabaseProperty> properties) throws IOException {
        return updateDatabase(databaseId, null, null, properties);
    }
    public Database updateDatabaseProperty(String databaseId, String propertyName, AbstractDatabaseProperty property) throws IOException {
        return updateDatabaseProperties(databaseId, Map.of(propertyName, property));
    }
    public Database removeDatabaseProperty(String databaseId, String propertyIdOrName) throws IOException {
        Map<String, AbstractDatabaseProperty> properties = new HashMap<>();
        properties.put(propertyIdOrName, null);
        return updateDatabase(databaseId, null, null, properties);
    }
    public Database renameDatabaseProperty(String databaseId, String oldNameOrId, String newName) throws IOException {
        Map<String, AbstractDatabaseProperty> properties = new HashMap<>();
        properties.put(oldNameOrId, new RenamingProperty(newName));
        return updateDatabase(databaseId, null, null, properties);
    }

    /**
     * Get a database by ID.
     * @param databaseId The ID of the database to retrieve.
     * @return database.
     * @see <a href="https://developers.notion.com/reference/retrieve-a-database">Retrieve a database</a>
     */
    public Database retrieveDatabase(String databaseId) throws IOException {
        String retrieveDatabaseUrl = API_URL + "databases/" + databaseId;
        String response = httpUtil.get(retrieveDatabaseUrl).getBody();
        return objectMapper.readValue(response, Database.class);
    }

    /**
     * Get a page by ID.
     * @param pageId The ID of the page to retrieve.
     * @return page.
     * @see <a href="https://developers.notion.com/reference/retrieve-a-page">Retrieve a page</a>
     */
    public Page retrievePage(String pageId, List<String> propertiesId) throws IOException {
        String retrievePageUrl = API_URL + "pages/" + pageId;
        Map<String, String> queryParams = processRetrievePageQueryParam(propertiesId);
        String response = httpUtil.get(retrievePageUrl, queryParams).getBody();
        return objectMapper.readValue(response, Page.class);
    }

    /**
     * Create a page.
     * If creating a page with a database parent, It is necessary to make sure property provided are matched with the
     * database's property, both in name and type, case-sensitive.
     * @param parent The parent of the page.
     * @param properties The properties of the page.
     * @param children The children of the page.
     * @param icon The icon of the page.
     * @param cover The cover of the page.
     * @return page.
     * @see #checkIfSchemaMatch(Map, Map)
     * @see <a href="https://developers.notion.com/reference/post-page">Create a page</a>
     */
    public Page createPage(AbstractParent parent, String pageTitle,
                           Map<String, AbstractPagePropertyValue> properties, List<AbstractBlock> children,
                           AbstractIcon icon, AbstractFile cover
    ) throws IOException {
        if (pageTitle == null) {
            pageTitle = "Untitled";
        }
        Map<String, AbstractPagePropertyValue> _properties = new HashMap<>();
        _properties.put("title", new TitleValue(pageTitle));
        if (properties != null) {
            _properties.putAll(properties);
        }
        String createPageUrl = API_URL + "pages";
        CreatePageBodyParam bodyParams = new CreatePageBodyParam();
        bodyParams.setParent(parent).setProperties(_properties).setChildren(children).setIcon(icon).setCover(cover);
        String body = objectMapper.writeValueAsString(bodyParams);
        String response = httpUtil.post(createPageUrl, body).getBody();
        return objectMapper.readValue(response, Page.class);
    }
    public Page createPage(AbstractParent parent, String pageTitle, Map<String, AbstractPagePropertyValue> properties, List<AbstractBlock> children) throws IOException {
        return createPage(parent, pageTitle, properties, children, null, null);
    }
    public Page createPage(AbstractParent parent, String pageTitle, Map<String, AbstractPagePropertyValue> properties) throws IOException {
        return createPage(parent, pageTitle, properties, null, null, null);
    }
    public Page createPage(AbstractParent parent, String pageTitle) throws IOException {
        return createPage(parent, pageTitle, null, null, null, null);
    }
    public Page createPage(String databaseId, String pageTitle, Map<String, AbstractPagePropertyValue> properties, List<AbstractBlock> children) throws IOException {
        return createPage(new DatabaseParent(databaseId), pageTitle, properties, children, null, null);
    }
    public Page createPage(String databaseId, String pageTitle, Map<String, AbstractPagePropertyValue> properties) throws IOException {
        return createPage(new DatabaseParent(databaseId), pageTitle, properties, null, null, null);
    }
    public Page createPage(String databaseId, String pageTitle) throws IOException {
        return createPage(new DatabaseParent(databaseId), pageTitle, null, null, null, null);
    }

    /**
     * Check if the schema of the properties provided match the database's schema.
     * Normally, retrieve database and get properties, and then use this method to check your properties.
     * @param property The database's property.
     * @param propertyValues The page properties you want to check.
     * @return true if matched, false if not.
     */
    public static boolean checkIfSchemaMatch(Map<String, AbstractDatabaseProperty> property,
                                             Map<String, AbstractDatabaseProperty> propertyValues) {
        for (Map.Entry<String, AbstractDatabaseProperty> entry : property.entrySet()) {
            if (!propertyValues.containsKey(entry.getKey())) {
                return false;
            }
            if (!entry.getValue().getType().equals(propertyValues.get(entry.getKey()).getType())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Update a page. If you are looking for change in-page elements, go to {@link #updateBlock(String, AbstractBlock, Boolean)}}.
     * @param pageId The ID of the page to update.
     * @param properties The properties of the page.
     * @param archived Whether the page is archived.
     * @param icon The icon of the page.
     * @param cover The cover of the page.
     * @return page.
     * @see <a href="https://developers.notion.com/reference/patch-page">Update a page</a>
     */
    public Page updatePage(String pageId,
                           Map<String, AbstractPagePropertyValue> properties,
                           Boolean archived,
                           AbstractIcon icon, AbstractFile cover
    ) throws IOException {
        String updatePageUrl = API_URL + "pages/" + pageId;
        UpdatePageBodyParam bodyParams = new UpdatePageBodyParam();
        bodyParams.setProperties(properties).setArchived(archived).setIcon(icon).setCover(cover);
        String body = objectMapper.writeValueAsString(bodyParams);
        String response = httpUtil.patch(updatePageUrl, body).getBody();
        return objectMapper.readValue(response, Page.class);
    }
    public Page updatePageProperties(String pageId, Map<String, AbstractPagePropertyValue> properties) throws IOException {
        return updatePage(pageId, properties, null, null, null);
    }
    public Page updatePageArchived(String pageId, Boolean archived) throws IOException {
        return updatePage(pageId, null, archived, null, null);
    }
    public Page updatePageIcon(String pageId, AbstractIcon icon) throws IOException {
        return updatePage(pageId, null, null, icon, null);
    }
    public Page updatePageCover(String pageId, AbstractFile cover) throws IOException {
        return updatePage(pageId, null, null, null, cover);
    }

    /**
     * Retrieve a page property value.
     * TODO: There should be something I missed.
     * @param pageId The ID of the page to retrieve.
     * @param propertyId The ID of the property to retrieve.
     * @return page property.
     * @see <a href="https://developers.notion.com/reference/retrieve-a-page-property">Retrieve a page property</a>
     */
    public AbstractPagePropertyValue retrievePageProperty(String pageId, String propertyId) throws IOException {
        String retrievePagePropertyUrl = API_URL + "pages/" + pageId + "/properties/" + propertyId;
        String response = httpUtil.get(retrievePagePropertyUrl).getBody();
        return objectMapper.readValue(response, AbstractPagePropertyValue.class);
    }

    /**
     * Retrieves a Block object using the ID specified.
     * @param blockId The ID of the block to retrieve.
     * @return block.
     * @see <a href="https://developers.notion.com/reference/retrieve-a-block">Retrieve a block</a>
     */
    public AbstractBlock retrieveBlock(String blockId) throws IOException {
        String retrieveBlockUrl = API_URL + "blocks/" + blockId;
        return objectMapper.readValue(httpUtil.get(retrieveBlockUrl).getBody(), AbstractBlock.class);
    }

    /**
     * Update a block. If you are looking for change in-page elements,
     * Go to {@link #updatePage(String, Map, Boolean, AbstractIcon, AbstractFile)}}.
     * Similarly, go to {@link #updateDatabase(String, List, List, Map)} for inline database block.
     * @param blockId The ID of the block to update.
     * @param block The block to update.
     * @param archived Whether the block is archived.
     * @return block.
     * @see <a href="https://developers.notion.com/reference/update-a-block">Update a block</a>
     */
    public AbstractBlock updateBlock(String blockId, AbstractBlock block, Boolean archived) throws IOException {
        checkUpdateBlockParam(blockId, block, archived);
        AbstractBlock.clearUnmodifiableInfo(block);
        String updateBlockUrl = API_URL + "blocks/" + (blockId == null ? block.getId() : blockId);
        UpdateBlockBodyParam bodyParams = new UpdateBlockBodyParam();
        bodyParams.setBlock(block).setArchived(archived);
        String body = objectMapper.writeValueAsString(bodyParams);
        String response = httpUtil.patch(updateBlockUrl, body).getBody();
        return objectMapper.readValue(response, AbstractBlock.class);
    }
    public AbstractBlock updateBlock(String blockId, Boolean archived) throws IOException {
        return updateBlock(blockId, null, archived);
    }
    public AbstractBlock updateBlock(String blockId, AbstractBlock block) throws IOException {
        return updateBlock(blockId, block, null);
    }
    public AbstractBlock updateBlock(AbstractBlock block) throws IOException {
        return updateBlock(null, block, null);
    }
    private static void checkUpdateBlockParam(String blockId, AbstractBlock block, Boolean archived) {
        if (block == null && archived == null) {
            throw new IllegalArgumentException("block and archived cannot be null at the same time");
        }
        if (blockId == null) {
            if (block == null || block.getId() == null) {
                throw new IllegalArgumentException("blockId and block.id cannot be null at the same time");
            }
        }
    }

    /**
     * Retrieve a block children list.
     * @param blockId The ID of the block to retrieve.
     * @param pageSize The number of results to return.
     * @param startCursor The cursor to start from.
     * @return block children list.
     * @see <a href="https://developers.notion.com/reference/get-block-children">Retrieve block children</a>
     */
    public PaginationResult<AbstractBlock> retrieveBlockChildren(String blockId, int pageSize, String startCursor) throws IOException {
        String retrieveBlockChildrenUrl = API_URL + "blocks/" + blockId + "/children";
        PaginationParam queryParams = new PaginationParam();
        queryParams.setPageSize(pageSize).setStartCursor(startCursor);
        String response = httpUtil.get(retrieveBlockChildrenUrl, queryParams.getQueryParams()).getBody();
        return objectMapper.readValue(response, objectMapper.getTypeFactory().constructParametricType(PaginationResult.class, AbstractBlock.class));
    }
    public PaginationResult<AbstractBlock> retrieveBlockChildren(String blockId) throws IOException {
        return retrieveBlockChildren(blockId, -1, null);
    }

    /**
     * Append block children.
     * @param blockId The ID of the block to append.
     * @param children The children to append.
     * @return block children list.
     * @see <a href="https://developers.notion.com/reference/append-block-children">Append block children</a>
     */
    public PaginationResult<AbstractBlock> appendBlockChildren(String blockId, List<AbstractBlock> children) throws IOException {
        String appendBlockChildrenUrl = API_URL + "blocks/" + blockId + "/children";
        AppendBlockBodyParam params = new AppendBlockBodyParam();
        params.setChildren(children);
        String body = objectMapper.writeValueAsString(params);
        String response = httpUtil.patch(appendBlockChildrenUrl, body).getBody();
        return objectMapper.readValue(response, objectMapper.getTypeFactory().constructParametricType(PaginationResult.class, AbstractBlock.class));
    }
    public PaginationResult<AbstractBlock> appendBlockChild(String blockId, AbstractBlock child) throws IOException {
        return appendBlockChildren(blockId, Collections.singletonList(child));
    }

    /**
     * Delete a block.
     * @param blockId The ID of the block to delete.
     * @return block.
     * @see <a href="https://developers.notion.com/reference/delete-a-block">Delete a block</a>
     */
    public AbstractBlock deleteBlock(String blockId) throws IOException {
        if (blockId == null || blockId.isEmpty()) {
            throw new IllegalArgumentException("blockId cannot be null or empty");
        }
        String deleteBlockUrl = API_URL + "blocks/" + blockId;
        return objectMapper.readValue(httpUtil.delete(deleteBlockUrl).getBody(), AbstractBlock.class);
    }
    public AbstractBlock deleteBlock(AbstractBlock block) throws IOException {
        if (block == null) {
            throw new IllegalArgumentException("block cannot be null");
        }
        return deleteBlock(block.getId());
    }

    /**
     * Retrieve a user
     * @param userId The ID of the user to retrieve.
     * @return The user object.
     * @see <a href="https://developers.notion.com/reference/get-user">Retrieve a user</a>
     */
    public User retrieveUser(String userId) throws IOException {
        String retrieveUserUrl = API_URL + "users/" + userId;
        String response = httpUtil.get(retrieveUserUrl).getBody();
        return objectMapper.readValue(response, User.class);
    }

    /**
     * List all users.
     * @return The list of user objects.
     */
    public List<User> listAllUsers() throws IOException {
        return listAllUsers(-1, null).getResults();
    }

    /**
     * List all users with pagination
     * @param startCursor The cursor to start from. If not provided, the endpoint will start from the beginning.
     * @param pageSize The number of results to return. It should not be greater than 100.
     * @return The pagination result of user objects.
     * @see <a href="https://developers.notion.com/reference/get-users">List all users</a>
     */
    public PaginationResult<User> listAllUsers(int pageSize, String startCursor) throws IOException {
        String listAllUsersUrl = API_URL + "users";
        PaginationParam paginationParams = new PaginationParam();
        paginationParams.setPageSize(pageSize).setStartCursor(startCursor);
        String response = httpUtil.get(listAllUsersUrl, paginationParams.getQueryParams()).getBody();
        return objectMapper.readValue(response, objectMapper.getTypeFactory().constructParametricType(PaginationResult.class, User.class));
    }

    /**
     * Retrieve the bot of the current token used.
     * @return bot.
     * @see <a href="https://developers.notion.com/reference/get-self">Retrieve your token's bot user</a>
     */
    public User retrieveBotInfo() throws IOException {
        String retrieveBotInfoUrl = API_URL + "users/me";
        String response = httpUtil.get(retrieveBotInfoUrl).getBody();
        return objectMapper.readValue(response, User.class);
    }

    /**
     * Search for pages or databases.
     * @param query The query to search for.
     * @param pageSize The number of results to return.
     * @param startCursor The cursor to start from.
     * @param filter The filter to apply to the search.
     * @param sort The sort to apply to the search.
     */
    public PaginationResult<PageOrDatabase> search(String query, int pageSize, String startCursor, AbstractFilter filter, AbstractSort sort) throws IOException {
        String searchUrl = API_URL + "search";
        SearchBodyParma searchParam = new SearchBodyParma();
        searchParam.setQuery(query).setPageSize(pageSize).setStartCursor(startCursor).setFilter(filter).setSort(sort);
        String response = httpUtil.post(searchUrl, objectMapper.writeValueAsString(searchParam)).getBody();
        return objectMapper.readValue(response, objectMapper.getTypeFactory().constructParametricType(PaginationResult.class, PageOrDatabase.class));
    }

    /**
     * Retrieve comments of given blockId.
     * @param blockId The ID of the block to retrieve comments.
     * @param pageSize The number of results to return.
     * @param startCursor The cursor to start from.
     * @return comments list.
     * @see <a href="https://developers.notion.com/reference/retrieve-a-comment">Retrieve comments</a>
     */
    public PaginationResult<Comments> retrieveComments(String blockId, int pageSize, String startCursor) throws IOException {
        String retrieveCommentsUrl = API_URL + "comments/";
        PaginationParam paginationParams = new PaginationParam();
        paginationParams.setPageSize(pageSize).setStartCursor(startCursor);
        Map<String, String> params = paginationParams.getQueryParams();
        params.put("block_id", blockId);
        String response = httpUtil.get(retrieveCommentsUrl, params).getBody();
        return objectMapper.readValue(response, objectMapper.getTypeFactory().constructParametricType(PaginationResult.class, Comments.class));
    }
    public PaginationResult<Comments> retrieveComments(String blockId) throws IOException {
        return retrieveComments(blockId, -1, null);
    }

    /**
     * Create a comment.
     * @param parent The parent of the comment.
     * @param richText The rich text content of the comment.
     * @return comment created.
     * @see <a href="https://developers.notion.com/reference/create-a-comment">Create comment</a>
     */
    public Comments createComment(AbstractParent parent, List<AbstractRichText> richText) throws IOException {
        String createCommentUrl = API_URL + "comments";
        CreateCommentBodyParam params = new CreateCommentBodyParam();
        params.setParent(parent).setRichText(richText);
        String body = objectMapper.writeValueAsString(params);
        String response = httpUtil.post(createCommentUrl, body).getBody();
        return objectMapper.readValue(response, Comments.class);
    }
    public Comments createComment(AbstractParent parent, String text) throws IOException {
        List<AbstractRichText> richText = new ArrayList<>();
        richText.add(new TextText(text));
        return createComment(parent, richText);
    }
    public Comments createComment(String discussionId, List<AbstractRichText> richText) throws IOException {
        String createCommentUrl = API_URL + "comments";
        CreateCommentBodyParam params = new CreateCommentBodyParam();
        params.setDiscussionId(discussionId).setRichText(richText);
        String body = objectMapper.writeValueAsString(params);
        String response = httpUtil.post(createCommentUrl, body).getBody();
        return objectMapper.readValue(response, Comments.class);
    }
    public Comments createComment(String discussionId, String text) throws IOException {
        List<AbstractRichText> richText = new ArrayList<>();
        richText.add(new TextText(text));
        return createComment(discussionId, richText);
    }

    /**
     * This is not an official notion endpoint.
     * Useful it when you work with {@link SelectOption}.
     * @param databaseId The ID of the database to retrieve.
     * @param selectPropertyName The name of the select property to retrieve.
     *                           <b>CAUTION:</b> This param is CASE-SENSITIVE. Fail to exactly match will cause {@link IOException}.
     * @return A map of select options.
     */
    public Map<String, SelectOption> getOptionsMap(String databaseId, String selectPropertyName) throws IOException {
        Database database = retrieveDatabase(databaseId);
        LinkedHashMap<String, AbstractDatabaseProperty> map = database.getProperties();
        AbstractDatabaseProperty property = map.get(selectPropertyName);
        List<SelectOption> options = null;
        if (property instanceof SelectConfiguration) {
            options = ((SelectConfiguration) property).getOptions();
        } else if (property instanceof MultiSelectConfiguration) {
            options = ((MultiSelectConfiguration) property).getOptions();
        } else {
            throw new IllegalArgumentException("The property is not a select property.");
        }
        return options.stream().collect(Collectors.toMap(SelectOption::getName, Function.identity()));
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class QueryDatabaseBodyParam {
        private AbstractFilter filter;
        private AbstractSort sorts;
        @JsonUnwrapped
        private final PaginationParam pagination = new PaginationParam();

        public PaginationParam getPagination() {
            return pagination;
        }

        public QueryDatabaseBodyParam setFilter(AbstractFilter filter) {
            this.filter = filter;
            return this;
        }

        public QueryDatabaseBodyParam setSorts(AbstractSort sorts) {
            this.sorts = sorts;
            return this;
        }

        public QueryDatabaseBodyParam setPageSize(int pageSize) {
            this.pagination.pageSize = processPageSize(pageSize);
            return this;
        }

        public QueryDatabaseBodyParam setStartCursor(String startCursor) {
            this.pagination.startCursor = startCursor;
            return this;
        }

        public AbstractFilter getFilter() {
            return filter;
        }

        public AbstractSort getSorts() {
            return sorts;
        }
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class CreateDatabaseBodyParam {
        private AbstractParent parent;
        private List<AbstractRichText> title;
        private Map<String, AbstractDatabaseProperty> properties;

        public CreateDatabaseBodyParam setTitlePropertyName(String titlePropertyName) {
            if (this.properties == null) {
                this.properties = new HashMap<>();
            }
            TitleConfiguration title = TitleConfiguration.getInstance();
            properties.put(titlePropertyName, title);
            return this;
        }

        public CreateDatabaseBodyParam setParent(AbstractParent parent) {
            this.parent = parent;
            return this;
        }

        public CreateDatabaseBodyParam setTitle(List<AbstractRichText> title) {
            this.title = title;
            return this;
        }

        public CreateDatabaseBodyParam setProperties(Map<String, AbstractDatabaseProperty> properties) {
            if (this.properties == null) {
                this.properties = properties;
            }
            this.properties.putAll(properties);
            return this;
        }

        public AbstractParent getParent() {
            return parent;
        }

        public List<AbstractRichText> getTitle() {
            return title;
        }

        public Map<String, AbstractDatabaseProperty> getProperties() {
            return properties;
        }
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class UpdateDatabaseBodyParam {
        private List<AbstractRichText> title;
        private List<AbstractRichText> description;
        private Map<String, AbstractDatabaseProperty> properties;

        public UpdateDatabaseBodyParam setTitle(List<AbstractRichText> title) {
            this.title = title;
            return this;
        }

        public UpdateDatabaseBodyParam setDescription(List<AbstractRichText> description) {
            this.description = description;
            return this;
        }

        public UpdateDatabaseBodyParam setProperties(Map<String, AbstractDatabaseProperty> properties) {
            this.properties = properties;
            return this;
        }

        public List<AbstractRichText> getTitle() {
            return title;
        }

        public List<AbstractRichText> getDescription() {
            return description;
        }

        public Map<String, AbstractDatabaseProperty> getProperties() {
            return properties;
        }
    }

    private static IdentityHashMap<String, String> processRetrievePageQueryParam(List<String> propertiesId) {
        return new IdentityHashMap<>() {{
            if (propertiesId != null && !propertiesId.isEmpty()) {
                propertiesId.forEach(property -> put("filter_properties", property));
            }
        }};
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class CreatePageBodyParam {
        private AbstractParent parent;
        private Map<String, AbstractPagePropertyValue> properties;
        private List<AbstractBlock> children;
        private AbstractIcon icon;
        private AbstractFile cover;

        public CreatePageBodyParam setParent(AbstractParent parent) {
            this.parent = parent;
            return this;
        }

        public CreatePageBodyParam setProperties(Map<String, AbstractPagePropertyValue> properties) {
            this.properties = properties;
            return this;
        }

        public CreatePageBodyParam setChildren(List<AbstractBlock> children) {
            this.children = children;
            return this;
        }

        public CreatePageBodyParam setIcon(AbstractIcon icon) {
            this.icon = icon;
            return this;
        }

        public CreatePageBodyParam setCover(AbstractFile cover) {
            this.cover = cover;
            return this;
        }

        public AbstractParent getParent() {
            return parent;
        }

        public Map<String, AbstractPagePropertyValue> getProperties() {
            return properties;
        }

        public List<AbstractBlock> getChildren() {
            return children;
        }

        public AbstractIcon getIcon() {
            return icon;
        }

        public AbstractFile getCover() {
            return cover;
        }
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class UpdatePageBodyParam {
        private Map<String, AbstractPagePropertyValue> properties;
        private Boolean archived;
        private AbstractIcon icon;
        private AbstractFile cover;

        public UpdatePageBodyParam setProperties(Map<String, AbstractPagePropertyValue> properties) {
            this.properties = properties;
            return this;
        }

        public UpdatePageBodyParam setArchived(Boolean archived) {
            this.archived = archived;
            return this;
        }

        public UpdatePageBodyParam setIcon(AbstractIcon icon) {
            this.icon = icon;
            return this;
        }

        public UpdatePageBodyParam setCover(AbstractFile cover) {
            this.cover = cover;
            return this;
        }

        public Map<String, AbstractPagePropertyValue> getProperties() {
            return properties;
        }

        public Boolean getArchived() {
            return archived;
        }

        public AbstractIcon getIcon() {
            return icon;
        }

        public AbstractFile getCover() {
            return cover;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class UpdateBlockBodyParam {
        @JsonUnwrapped
        private AbstractBlock block;
        private Boolean archived;

        public UpdateBlockBodyParam setBlock(AbstractBlock block) {
            this.block = block;
            return this;
        }

        public UpdateBlockBodyParam setArchived(Boolean archived) {
            this.archived = archived;
            return this;
        }

        public AbstractBlock getBlock() {
            return block;
        }

        public Boolean getArchived() {
            return archived;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class AppendBlockBodyParam {
        private List<AbstractBlock> children;

        public AppendBlockBodyParam setChildren(List<AbstractBlock> children) {
            this.children = children;
            return this;
        }

        public List<AbstractBlock> getChildren() {
            return children;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class SearchBodyParma {
        private String query;
        private AbstractFilter filter;
        private AbstractSort sort;
        private String startCursor;
        private Integer pageSize;

        public SearchBodyParma setQuery(String query) {
            this.query = query;
            return this;
        }

        public SearchBodyParma setFilter(AbstractFilter filter) {
            this.filter = filter;
            return this;
        }

        public SearchBodyParma setSort(AbstractSort sort) {
            this.sort = sort;
            return this;
        }

        public SearchBodyParma setStartCursor(String startCursor) {
            this.startCursor = startCursor;
            return this;
        }

        public SearchBodyParma setPageSize(int pageSize) {
            this.pageSize = processPageSize(pageSize);
            return this;
        }

        public String getQuery() {
            return query;
        }

        public AbstractFilter getFilter() {
            return filter;
        }

        public AbstractSort getSort() {
            return sort;
        }

        public String getStartCursor() {
            return startCursor;
        }

        public Integer getPageSize() {
            return pageSize;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class CreateCommentBodyParam {
        private AbstractParent parent;
        private String discussionId;
        private List<AbstractRichText> richText;

        public CreateCommentBodyParam setParent(AbstractParent parent) {
            this.parent = parent;
            this.discussionId = null;
            return this;
        }

        public CreateCommentBodyParam setDiscussionId(String discussionId) {
            this.discussionId = discussionId;
            this.parent = null;
            return this;
        }

        public CreateCommentBodyParam setRichText(List<AbstractRichText> richText) {
            this.richText = richText;
            return this;
        }

        public AbstractParent getParent() {
            return parent;
        }

        public String getDiscussionId() {
            return discussionId;
        }

        public List<AbstractRichText> getRichText() {
            return richText;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class PaginationParam {
        private Integer pageSize;
        private String startCursor;

        public PaginationParam setPageSize(int pageSize) {
            this.pageSize = processPageSize(pageSize);
            return this;
        }

        public PaginationParam setStartCursor(String startCursor) {
            this.startCursor = startCursor;
            return this;
        }

        @JsonIgnore
        public IdentityHashMap<String, String> getQueryParams() {
            return new IdentityHashMap<>() {{
                if (pageSize != null) {
                    put("page_size", pageSize.toString());
                }
                if (startCursor != null) {
                    put("start_cursor", startCursor);
                }
            }};
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public String getStartCursor() {
            return startCursor;
        }
    }

    private static Integer processPageSize(Integer pageSize) {
        if (pageSize == null) {
            return null;
        }
        if (pageSize < 1) {
            return null;
        }
        if (pageSize > 100) {
            throw new IllegalArgumentException("The page size cannot be greater than 100. SEE: https://developers.notion.com/reference/get-users");
        }
        return pageSize;
    }

    public Notion(String token) {
        this.httpUtil = createHttp(token);
    }

    private NotionHttpUtil createHttp(String token) {
        NotionHttpUtil httpUtil = new NotionHttpUtil();
        httpUtil.addDefaultHeader("Authorization", "Bearer " + token);
        httpUtil.addDefaultHeader("Notion-Version", API_VERSION);
        return httpUtil;
    }

    private static ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        objectMapper.setDateFormat(Date.DATE_FORMAT);
        objectMapper.configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, false);
        return objectMapper;
    }

    public HttpUtil getHttpUtil() {
        return httpUtil;
    }

    static {
        objectMapper = createObjectMapper();
    }
}
