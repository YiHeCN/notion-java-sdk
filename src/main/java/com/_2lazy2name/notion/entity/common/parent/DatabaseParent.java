package com._2lazy2name.notion.entity.common.parent;

import com._2lazy2name.notion.entity.enumeration.type.ParentTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class DatabaseParent extends AbstractParent {
    private final ParentTypeEnum type = ParentTypeEnum.DATABASE_ID;
    private String databaseId;
}
