package com._2lazy2name.notion.property.page;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#relation">Relation</a>
 */
public class RelationValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.RELATION;
    private Boolean hasMore;
    private List<PageReference> relation;


    public RelationValue addRelation(String relatedToPageId) {
        this.relation.add(new PageReference().setId(relatedToPageId));
        return this;
    }

    public RelationValue addRelation(List<String> relatedToPageIds) {
        for (String relatedToPageId : relatedToPageIds) {
            this.relation.add(new PageReference().setId(relatedToPageId));
        }
        return this;
    }

    public RelationValue addRelation(String... relatedToPageIds) {
        for (String relatedToPageId : relatedToPageIds) {
            this.relation.add(new PageReference().setId(relatedToPageId));
        }
        return this;
    }

    public RelationValue removeRelation(String relatedToPageId) {
        for (PageReference pageReference : this.relation) {
            if (pageReference.getId().equals(relatedToPageId)) {
                this.relation.remove(pageReference);
                break;
            }
        }
        return this;
    }

    public RelationValue() {
        this.relation = new ArrayList<>();
    }

    public RelationValue(String relatedToPageId) {
        this();
        this.relation.add(new PageReference().setId(relatedToPageId));
    }

    public RelationValue(List<String> relatedToPageIds) {
        this();
        for (String relatedToPageId : relatedToPageIds) {
            this.relation.add(new PageReference().setId(relatedToPageId));
        }
    }

    public RelationValue(String... relatedToPageIds) {
        this();
        for (String relatedToPageId : relatedToPageIds) {
            this.relation.add(new PageReference().setId(relatedToPageId));
        }
    }

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
