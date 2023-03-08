package com._2lazy2name.notion.entity.common.parent;

import com._2lazy2name.notion.entity.enumeration.type.ParentTypeEnum;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, property = "type")
@JsonSubTypes(
    {
        @JsonSubTypes.Type(value = BlockParent.class, name = "block_id"),
        @JsonSubTypes.Type(value = DatabaseParent.class, name = "database_id"),
        @JsonSubTypes.Type(value = PageParent.class, name = "page_id"),
        @JsonSubTypes.Type(value = WorkSpaceParent.class, name = "workspace")
    }
)
public abstract class AbstractParent {
    protected ParentTypeEnum type;

    public static BlockParent buildBlockParent(String blockId) {
        BlockParent blockParent = new BlockParent();
        blockParent.setBlockId(blockId);
        return blockParent;
    }

    public static DatabaseParent buildDatabaseParent(String databaseId) {
        DatabaseParent databaseParent = new DatabaseParent();
        databaseParent.setDatabaseId(databaseId);
        return databaseParent;
    }

    public static PageParent buildPageParent(String pageId) {
        PageParent pageParent = new PageParent();
        pageParent.setPageId(pageId);
        return pageParent;
    }

    public static WorkSpaceParent buildWorkSpaceParent() {
        return WorkSpaceParent.getInstance();
    }

    public ParentTypeEnum getType() {
        return type;
    }

    public AbstractParent setType(ParentTypeEnum type) {
        this.type = type;
        return this;
    }
}
