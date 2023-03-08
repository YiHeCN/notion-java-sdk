package com._2lazy2name.notion.entity.common.richText.mention;

import com._2lazy2name.notion.entity.Database;
import com._2lazy2name.notion.entity.enumeration.type.MentionTypeEnum;

public class DatabaseMention extends AbstractMention {
    private final MentionTypeEnum type = MentionTypeEnum.DATABASE;
    private Database database;

    private DatabaseMention() {
    }

    public DatabaseMention(Database database) {
        this.database = database;
    }

    public MentionTypeEnum getType() {
        return type;
    }

    public Database getDatabase() {
        return database;
    }

    public DatabaseMention setDatabase(Database database) {
        this.database = database;
        return this;
    }
}
