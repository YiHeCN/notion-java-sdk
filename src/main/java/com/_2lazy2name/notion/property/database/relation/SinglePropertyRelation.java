package com._2lazy2name.notion.property.database.relation;

import com._2lazy2name.notion.enumeration.type.RelationTypeEnum;
import com._2lazy2name.notion.serializer.NullToEmptyObjectSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SinglePropertyRelation extends AbstractRelation {
    private RelationTypeEnum type = RelationTypeEnum.SINGLE_PROPERTY;
    @JsonSerialize(nullsUsing = NullToEmptyObjectSerializer.class)
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
