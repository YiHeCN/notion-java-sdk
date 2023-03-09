package com._2lazy2name.notion.property.database.relation;

import com._2lazy2name.notion.enumeration.type.RelationTypeEnum;

public class DualPropertyRelation extends AbstractRelation {
    private RelationTypeEnum type = RelationTypeEnum.DUAL_PROPERTY;
    private DualProperty dualProperty;

    private static class DualProperty {
        private String syncedPropertyName;
        private String syncedPropertyId;

        public String getSyncedPropertyName() {
            return syncedPropertyName;
        }

        public DualProperty setSyncedPropertyName(String syncedPropertyName) {
            this.syncedPropertyName = syncedPropertyName;
            return this;
        }

        public String getSyncedPropertyId() {
            return syncedPropertyId;
        }

        public DualProperty setSyncedPropertyId(String syncedPropertyId) {
            this.syncedPropertyId = syncedPropertyId;
            return this;
        }
    }

    @Override
    public RelationTypeEnum getType() {
        return type;
    }

    public DualPropertyRelation setType(RelationTypeEnum type) {
        this.type = type;
        return this;
    }

    public DualProperty getDualProperty() {
        return dualProperty;
    }

    public DualPropertyRelation setDualProperty(DualProperty dualProperty) {
        this.dualProperty = dualProperty;
        return this;
    }
}
