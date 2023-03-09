package com._2lazy2name.notion.entity.common.parent;

import com._2lazy2name.notion.enumeration.type.ParentTypeEnum;

public class DatabaseParent extends AbstractParent {
    private final ParentTypeEnum type = ParentTypeEnum.DATABASE_ID;
    private String databaseId;

    private DatabaseParent() {
    }

    public DatabaseParent(String databaseId) {
        this.databaseId = databaseId;
    }

    @Override
    public ParentTypeEnum getType() {
        return type;
    }

    public String getDatabaseId() {
        return databaseId;
    }

    public DatabaseParent setDatabaseId(String databaseId) {
        this.databaseId = databaseId;
        return this;
    }
}
