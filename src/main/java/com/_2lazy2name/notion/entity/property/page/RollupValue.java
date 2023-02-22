package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.enumeration.type.RollupTypeEnum;
import com._2lazy2name.notion.entity.enumeration.RollupFunctionEnum;
import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * This object cannot be updated.
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#rollup">Rollup</a>
 */
@Getter @Setter @ToString
public class RollupValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.ROLLUP;
    private Rollup rollup;

    @Getter @Setter @ToString
    private static class Rollup {
        private RollupTypeEnum type;
        private RollupFunctionEnum function;
        private Object array;
        private Object date;
        private Object number;
        private Object incomplete;
        private Object unsupported;
    }
}
