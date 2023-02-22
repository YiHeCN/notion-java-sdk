package com._2lazy2name.notion.entity.common.filter.typeSpecific;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.common.filter.PropertyFilter;
import lombok.*;

@Getter @Setter @NoArgsConstructor
public class RelationFilter extends PropertyFilter {
    private final PropertyTypeEnum type = PropertyTypeEnum.RELATION;
    private RelationFilterMethodEnum method;

    public RelationFilter(String property, RelationFilterMethodEnum method, Object value) {
        this.property = property;
        this.method = method;
        this.value = value;
    }

    public RelationFilter on(String property) {
        this.property = property;
        return this;
    }

    public RelationFilter contains(String value) {
        this.method = RelationFilterMethodEnum.CONTAINS;
        this.value = value;
        return this;
    }

    public RelationFilter doesNotContain(String value) {
        this.method = RelationFilterMethodEnum.DOES_NOT_CONTAIN;
        this.value = value;
        return this;
    }

    public RelationFilter isEmpty() {
        this.method = RelationFilterMethodEnum.IS_EMPTY;
        this.value = true;
        return this;
    }

    public RelationFilter isNotEmpty() {
        this.method = RelationFilterMethodEnum.IS_NOT_EMPTY;
        this.value = true;
        return this;
    }

    @Getter
    public enum RelationFilterMethodEnum implements IFilterMethod {
        CONTAINS("contains", STRING),
        DOES_NOT_CONTAIN("does_not_contain", STRING),
        IS_EMPTY("is_empty", BOOLEAN_ONLY_TRUE),
        IS_NOT_EMPTY("is_not_empty", BOOLEAN_ONLY_TRUE);

        private final String method;
        private final int valueType;

        RelationFilterMethodEnum(String method, int valueType) {
            this.method = method;
            this.valueType = valueType;
        }
    }
}
