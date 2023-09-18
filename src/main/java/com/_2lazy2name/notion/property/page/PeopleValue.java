package com._2lazy2name.notion.property.page;

import com._2lazy2name.notion.entity.User;
import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#people">People</a>
 */
public class PeopleValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.PEOPLE;
    @JsonFormat(shape = JsonFormat.Shape.OBJECT, with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<User> people;

    private PeopleValue() {
    }

    public PeopleValue(List<User> people) {
        this.people = people;
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public List<User> getPeople() {
        return people;
    }

    public PeopleValue setPeople(List<User> people) {
        this.people = people;
        return this;
    }
}
