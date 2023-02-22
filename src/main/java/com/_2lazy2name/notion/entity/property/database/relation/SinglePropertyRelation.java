package com._2lazy2name.notion.entity.property.database.relation;

import com._2lazy2name.notion.entity.enumeration.type.RelationTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SinglePropertyRelation extends AbstractRelation {
    private RelationTypeEnum type = RelationTypeEnum.SINGLE_PROPERTY;
    // This Object is always null.
    private final Object singleProperty = null;
}
