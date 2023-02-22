package com._2lazy2name.notion.entity.common.sort;

import com._2lazy2name.notion.entity.enumeration.SortDirectionEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/post-database-query-sort#property-value-sort">Property Value Sort</a>
 */
@ToString @Getter @Setter
public class PropertyValueSort extends AbstractSort {
    private String property;

    private PropertyValueSort() {
    }

    public PropertyValueSort(String property, SortDirectionEnum direction) {
        PropertyValueSort propertyValueSort = new PropertyValueSort();
        propertyValueSort.setProperty(property);
        propertyValueSort.setDirection(direction);
    }
}
