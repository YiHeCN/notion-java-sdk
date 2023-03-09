package com._2lazy2name.notion.property.page;

import com._2lazy2name.notion.enumeration.type.RollupTypeEnum;
import com._2lazy2name.notion.enumeration.RollupFunctionEnum;
import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;

/***
 * This object cannot be updated.
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#rollup">Rollup</a>
 */
public class RollupValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.ROLLUP;
    private Rollup rollup;

    private static class Rollup {
        private RollupTypeEnum type;
        private RollupFunctionEnum function;
        private Object array;
        private Object date;
        private Object number;
        private Object incomplete;
        private Object unsupported;

        public RollupTypeEnum getType() {
            return type;
        }

        public Rollup setType(RollupTypeEnum type) {
            this.type = type;
            return this;
        }

        public RollupFunctionEnum getFunction() {
            return function;
        }

        public Rollup setFunction(RollupFunctionEnum function) {
            this.function = function;
            return this;
        }

        public Object getArray() {
            return array;
        }

        public Rollup setArray(Object array) {
            this.array = array;
            return this;
        }

        public Object getDate() {
            return date;
        }

        public Rollup setDate(Object date) {
            this.date = date;
            return this;
        }

        public Object getNumber() {
            return number;
        }

        public Rollup setNumber(Object number) {
            this.number = number;
            return this;
        }

        public Object getIncomplete() {
            return incomplete;
        }

        public Rollup setIncomplete(Object incomplete) {
            this.incomplete = incomplete;
            return this;
        }

        public Object getUnsupported() {
            return unsupported;
        }

        public Rollup setUnsupported(Object unsupported) {
            this.unsupported = unsupported;
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

    public RollupValue setRollup(Rollup rollup) {
        this.rollup = rollup;
        return this;
    }
}
