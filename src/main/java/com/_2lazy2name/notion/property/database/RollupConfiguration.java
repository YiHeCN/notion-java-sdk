package com._2lazy2name.notion.property.database;

import com._2lazy2name.notion.enumeration.RollupFunctionEnum;
import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;


/***
 * Rollup is not supported by Notion API yet.
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#rollup-configuration">Rollup Configuration</a>
 */

public class RollupConfiguration extends AbstractDatabaseProperty{
    private final PropertyTypeEnum type = PropertyTypeEnum.ROLLUP;
    private Rollup rollup;

    private static class Rollup {
        private RollupFunctionEnum function;
        private String relationPropertyName;
        private String relationPropertyId;
        private String rollupPropertyName;
        private String rollupPropertyId;

        public RollupFunctionEnum getFunction() {
            return function;
        }

        public Rollup setFunction(RollupFunctionEnum function) {
            this.function = function;
            return this;
        }

        public String getRelationPropertyName() {
            return relationPropertyName;
        }

        public Rollup setRelationPropertyName(String relationPropertyName) {
            this.relationPropertyName = relationPropertyName;
            return this;
        }

        public String getRelationPropertyId() {
            return relationPropertyId;
        }

        public Rollup setRelationPropertyId(String relationPropertyId) {
            this.relationPropertyId = relationPropertyId;
            return this;
        }

        public String getRollupPropertyName() {
            return rollupPropertyName;
        }

        public Rollup setRollupPropertyName(String rollupPropertyName) {
            this.rollupPropertyName = rollupPropertyName;
            return this;
        }

        public String getRollupPropertyId() {
            return rollupPropertyId;
        }

        public Rollup setRollupPropertyId(String rollupPropertyId) {
            this.rollupPropertyId = rollupPropertyId;
            return this;
        }
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public Rollup getRollup() {
        return rollup;
    }

    public RollupConfiguration setRollup(Rollup rollup) {
        this.rollup = rollup;
        return this;
    }
}
