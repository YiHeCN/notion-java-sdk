package com._2lazy2name.notion.entity.property.database;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.property.database.relation.AbstractRelation;


/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#relation">Relaiton</a>
 */

public class RelationConfiguration extends AbstractDatabaseProperty {
    private final PropertyTypeEnum type = PropertyTypeEnum.RELATION;
    private AbstractRelation relation;

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public AbstractRelation getRelation() {
        return relation;
    }

    public RelationConfiguration setRelation(AbstractRelation relation) {
        this.relation = relation;
        return this;
    }
}
