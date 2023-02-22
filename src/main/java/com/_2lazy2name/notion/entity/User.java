package com._2lazy2name.notion.entity;

import com._2lazy2name.notion.entity.enumeration.ObjectEnum;
import com._2lazy2name.notion.entity.enumeration.type.UserTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
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

    @Getter @Setter @ToString
    private static class Person {
        private String email;
    }

    @Getter @Setter @ToString
    private static class Bot {
        private String workspaceName;
        private Object owner;
    }
}
