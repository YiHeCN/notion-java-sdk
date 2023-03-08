package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;

import java.util.List;

/**
 * This object cannot be updated.
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#relation">Relation</a>
 */
public class RelationValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.RELATION;
    private Boolean hasMore;
    private List<PageReference> relation;

    public static class PageReference {
        private String id;

        public String getId() {
            return id;
        }

        public PageReference setId(String id) {
            this.id = id;
            return this;
        }
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public RelationValue setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
        return this;
    }

    public List<PageReference> getRelation() {
        return relation;
    }

    public RelationValue setRelation(List<PageReference> relation) {
        this.relation = relation;
        return this;
    }
}
