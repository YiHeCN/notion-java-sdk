package com._2lazy2name.notion.entity.common.richText.mention;

import com._2lazy2name.notion.entity.User;
import com._2lazy2name.notion.enumeration.type.MentionTypeEnum;

public class UserMention extends AbstractMention {
    private final MentionTypeEnum type = MentionTypeEnum.USER;
    private User user;

    private UserMention() {
    }

    public UserMention(User user) {
        this.user = user;
    }

    public UserMention(String userId) {
        this.user = new User(userId);
    }

    public MentionTypeEnum getType() {
        return type;
    }

    public User getUser() {
        return user;
    }

    public UserMention setUser(User user) {
        this.user = user;
        return this;
    }
}
