package com._2lazy2name.notion.entity.property.database.relation;

import com._2lazy2name.notion.entity.enumeration.type.RelationTypeEnum;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/***
 * TODO: Implement this class.
 * This is an update in version 2022-06-28 and can be found in the "Versioning - Changes by version" section.
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/changes-by-version">Changes by version</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SinglePropertyRelation.class, name = "single_property"),
        @JsonSubTypes.Type(value = DualPropertyRelation.class, name = "dual_property")
})
public abstract class AbstractRelation {
    protected RelationTypeEnum type;
    private String databaseId;

    public RelationTypeEnum getType() {
        return type;
    }

    public String getDatabaseId() {
        return databaseId;
    }
}
