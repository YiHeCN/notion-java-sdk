package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.common.parent.PageParent;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ChildPageBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.CHILD_PAGE;
    private ChildPage childPage;

    @JsonIgnore
    public String getTitle() {
        return childPage.title;
    }
    private ChildPageBlock setTitle(String title) {
        childPage.title = title;
        return this;
    }

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private ChildPageBlock() {}

    private ChildPageBlock(String title) {
        this.childPage = new ChildPage();
        this.childPage.title = title;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class ChildPage {
        private String title;

        public String getTitle() {
            return title;
        }

        public ChildPage setTitle(String title) {
            this.title = title;
            return this;
        }
    }

    private ChildPage getPage() {
        return this.childPage;
    }

    private ChildPageBlock setPage(ChildPage childPage) {
        this.childPage = childPage;
        return this;
    }
}
