package com._2lazy2name.notion.entity;

import com._2lazy2name.notion.enumeration.ObjectEnum;
import com._2lazy2name.notion.enumeration.type.UserTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private final ObjectEnum object = ObjectEnum.USER;
    private String id;
    private String name;
    private String avatarUrl;
    private UserTypeEnum type;
    private Person person;
    private Bot bot;

    private User() {}

    public User(String id) {
        this.id = id;
    }

    /**
     * Provide access to private field person.email.
     * @return person.email
     */
    @JsonIgnore
    public String getEmail() {
        return person.getEmail();
    }

    private static class Person {
        private String email;

        public String getEmail() {
            return email;
        }

        public Person setEmail(String email) {
            this.email = email;
            return this;
        }
    }


    private static class Bot {
        private String workspaceName;
        private Object owner;

        public String getWorkspaceName() {
            return workspaceName;
        }

        public Bot setWorkspaceName(String workspaceName) {
            this.workspaceName = workspaceName;
            return this;
        }

        public Object getOwner() {
            return owner;
        }

        public Bot setOwner(Object owner) {
            this.owner = owner;
            return this;
        }
    }

    public ObjectEnum getObject() {
        return object;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public User setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public UserTypeEnum getType() {
        return type;
    }

    public User setType(UserTypeEnum type) {
        this.type = type;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public User setPerson(Person person) {
        this.person = person;
        return this;
    }

    public Bot getBot() {
        return bot;
    }

    public User setBot(Bot bot) {
        this.bot = bot;
        return this;
    }
}
