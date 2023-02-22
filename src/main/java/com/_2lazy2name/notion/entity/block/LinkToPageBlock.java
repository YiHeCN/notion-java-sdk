package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
public class LinkToPageBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.LINK_TO_PAGE;
    private LinkToPage linkToPage;

    @ToString @Getter @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class LinkToPage {
        private String type;
        private String pageId;
        private String databaseId;
    }

    private LinkToPageBlock() {}

    public static LinkToPageBlock toPage(String pageId) {
        LinkToPageBlock linkToPageBlock = new LinkToPageBlock();
        LinkToPage linkToPage = new LinkToPage();
        linkToPage.type = "page";
        linkToPage.pageId = pageId;
        linkToPageBlock.linkToPage = linkToPage;
        return linkToPageBlock;
    }
    public static LinkToPageBlock toDatabase(String databaseId) {
        LinkToPageBlock linkToPageBlock = new LinkToPageBlock();
        LinkToPage linkToPage = new LinkToPage();
        linkToPage.type = "database";
        linkToPage.databaseId = databaseId;
        linkToPageBlock.linkToPage = linkToPage;
        return linkToPageBlock;
    }


}
