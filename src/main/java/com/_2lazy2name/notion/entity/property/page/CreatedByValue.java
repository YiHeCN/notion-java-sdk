package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.User;
import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This object cannot be updated.
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#created-by">Created By</a>
 */
@Getter
@Setter
@ToString
public class CreatedByValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.CREATED_BY;
    private User createdBy;

    @JsonIgnore
    private CreatedByValue() {
    }

}
