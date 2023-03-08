package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.User;
import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;

import java.util.List;

/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#people">People</a>
 */
public class PeopleValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.PEOPLE;
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
