package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.User;
import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This object cannot be updated.
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#last-edited-by">Last Edited By</a>
 */
@Getter
@Setter
@ToString
public class LastEditedByValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.LAST_EDITED_BY;
    private User lastEditedBy;
}
