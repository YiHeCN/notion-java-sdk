package com._2lazy2name.notion.entity.common.richText.mention;

import com._2lazy2name.notion.enumeration.type.MentionTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Validate Constructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class DatabaseMention extends AbstractMention {
    private final MentionTypeEnum type = MentionTypeEnum.DATABASE;
    private DatabaseId database;

    @JsonIgnore
    public String getDatabaseId() {
        return database == null ? null : database.getId();
    }

    public void setDatabaseId(String databaseId) {
        if (this.database == null) this.database = new DatabaseId();
        this.database.id = databaseId;
    }

    private DatabaseMention() {}

    public DatabaseMention(String databaseId) {
        this.database = new DatabaseId();
        this.database.id = databaseId;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class DatabaseId {
        private String id;

        private String getId() {
            return id;
        }

        private DatabaseId setId(String id) {
            this.id = id;
            return this;
        }
    }

    @Override
    public MentionTypeEnum getType() {
        return type;
    }

    private DatabaseId getDatabase() {
        return database;
    }

    private DatabaseMention setDatabase(DatabaseId database) {
        this.database = database;
        return this;
    }
}
