package com._2lazy2name.notion.entity.common.richText.mention;

import com._2lazy2name.notion.enumeration.type.MentionTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Validate Id.
public class UserMention extends AbstractMention {
    private final MentionTypeEnum type = MentionTypeEnum.USER;
    private UserId user;

    @JsonIgnore
    public String getUserId() {
        return user == null ? null : user.getId();
    }

    public void setUserId(String userId) {
        if (this.user == null) this.user = new UserMention.UserId();
        this.user.id = userId;
    }

    private UserMention() {}

    public UserMention(String userId) {
        this.user = new UserMention.UserId();
        this.user.id = userId;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class UserId {
        private String id;

        private String getId() {
            return id;
        }

        private UserMention.UserId setId(String id) {
            this.id = id;
            return this;
        }
    }

    @Override
    public MentionTypeEnum getType() {
        return type;
    }

    private UserMention.UserId getUser() {
        return user;
    }

    private UserMention setUser(UserMention.UserId user) {
        this.user = user;
        return this;
    }
}
