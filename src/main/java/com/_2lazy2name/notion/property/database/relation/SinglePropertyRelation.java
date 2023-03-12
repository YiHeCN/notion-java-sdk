package com._2lazy2name.notion.property.database.relation;

import com._2lazy2name.notion.enumeration.type.RelationTypeEnum;
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

    private Object getSingleProperty() {
        return null;
    }
}
