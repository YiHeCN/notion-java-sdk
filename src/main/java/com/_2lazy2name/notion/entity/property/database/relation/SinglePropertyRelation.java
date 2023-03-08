package com._2lazy2name.notion.entity.property.database.relation;

import com._2lazy2name.notion.entity.enumeration.type.RelationTypeEnum;
public class SinglePropertyRelation extends AbstractRelation {

    private RelationTypeEnum type = RelationTypeEnum.SINGLE_PROPERTY;
    // This Object is always null.
    private final Object singleProperty = null;

    @Override
    public RelationTypeEnum getType() {
        return type;
    }

    public SinglePropertyRelation setType(RelationTypeEnum type) {
        this.type = type;
        return this;
    }

    public Object getSingleProperty() {
        return singleProperty;
    }
}
