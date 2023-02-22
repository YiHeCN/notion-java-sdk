package com._2lazy2name.notion.entity.property.database;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/***
 * TODO: find out whether this class is able to modify.
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#status-configuration">Status Configuration</a>
 */
@Getter
@Setter
@ToString
public class StatusConfiguration extends AbstractDatabaseProperty {
    private final PropertyTypeEnum type = PropertyTypeEnum.STATUS;
    private Status status;

    @Getter @Setter
    private static class Status {
        private List<SelectOption> options = new ArrayList<>();
        private List<StatusGroup> groups = new ArrayList<>();
    }
}
