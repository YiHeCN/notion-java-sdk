package com._2lazy2name.notion.property.database;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;


import java.util.ArrayList;
import java.util.List;

/***
 * TODO: find out whether this class is able to modify.
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#status-configuration">Status Configuration</a>
 */

public class StatusConfiguration extends AbstractDatabaseProperty {
    private final PropertyTypeEnum type = PropertyTypeEnum.STATUS;
    private Status status;


    private static class Status {
        private List<SelectOption> options = new ArrayList<>();
        private List<StatusGroup> groups = new ArrayList<>();

        public List<SelectOption> getOptions() {
            return options;
        }

        public Status setOptions(List<SelectOption> options) {
            this.options = options;
            return this;
        }

        public List<StatusGroup> getGroups() {
            return groups;
        }

        public Status setGroups(List<StatusGroup> groups) {
            this.groups = groups;
            return this;
        }
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    public StatusConfiguration setStatus(Status status) {
        this.status = status;
        return this;
    }
}
