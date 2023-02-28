package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LinkToPageBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.LINK_TO_PAGE;
    private LinkToPage linkToPage;

    public static LinkToPageBlock toPage(String pageId) {
        LinkToPageBlock linkToPageBlock = new LinkToPageBlock();
        linkToPageBlock.linkToPage = new LinkToPage();
        linkToPageBlock.linkToPage.type = "page_id";
        linkToPageBlock.linkToPage.databaseId = pageId;
        return linkToPageBlock;
    }
    public static LinkToPageBlock toDatabase(String databaseId) {
        LinkToPageBlock linkToPageBlock = new LinkToPageBlock();
        linkToPageBlock.linkToPage = new LinkToPage();
        linkToPageBlock.linkToPage.type = "database_id";
        linkToPageBlock.linkToPage.databaseId = databaseId;
        return linkToPageBlock;
    }

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private LinkToPageBlock() {}

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class LinkToPage {
        private String type;
        private String pageId;
        private String databaseId;

        private String getType() {
            return type;
        }

        private LinkToPage setType(String type) {
            this.type = type;
            return this;
        }

        private String getPageId() {
            return pageId;
        }

        private LinkToPage setPageId(String pageId) {
            this.pageId = pageId;
            return this;
        }

        private String getDatabaseId() {
            return databaseId;
        }

        private LinkToPage setDatabaseId(String databaseId) {
            this.databaseId = databaseId;
            return this;
        }
    }

    private LinkToPage getLinkToPage() {
        return linkToPage;
    }

    private LinkToPageBlock setLinkToPage(LinkToPage linkToPage) {
        this.linkToPage = linkToPage;
        return this;
    }
}
