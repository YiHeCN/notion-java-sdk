package com._2lazy2name.notion.entity.common.parent;

import com._2lazy2name.notion.enumeration.type.ParentTypeEnum;
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

    public static WorkSpaceParent buildWorkSpaceParent() {
        return WorkSpaceParent.getInstance();
    }

    protected ParentTypeEnum getType() {
        return type;
    }
}
