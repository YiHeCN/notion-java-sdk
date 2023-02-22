package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * This object cannot be updated.
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#relation">Relation</a>
 */
@Getter
@Setter
@ToString
public class RelationValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.RELATION;
    private Boolean hasMore;
    private List<PageReference> relation;

    @Getter @Setter @ToString
    public static class PageReference {
        private String id;
    }
}
