package com._2lazy2name.notion.entity.property.database.relation;

import com._2lazy2name.notion.entity.enumeration.type.RelationTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class DualPropertyRelation extends AbstractRelation {
    private RelationTypeEnum type = RelationTypeEnum.DUAL_PROPERTY;
    private DualProperty dualProperty;

    @Getter @Setter @ToString
    private static class DualProperty {
        private String syncedPropertyName;
        private String syncedPropertyId;
    }
}
