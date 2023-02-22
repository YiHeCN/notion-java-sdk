package com._2lazy2name.notion.entity.property.database;

import com._2lazy2name.notion.entity.enumeration.RollupFunctionEnum;
import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * Rollup is not supported by Notion API yet.
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#rollup-configuration">Rollup Configuration</a>
 */
@Getter
@Setter
@ToString
public class RollupConfiguration extends AbstractDatabaseProperty{
    private final PropertyTypeEnum type = PropertyTypeEnum.ROLLUP;
    private Rollup rollup;

    @Getter @Setter @ToString
    private static class Rollup {
        private RollupFunctionEnum function;
        private String relationPropertyName;
        private String relationPropertyId;
        private String rollupPropertyName;
        private String rollupPropertyId;
    }

}
