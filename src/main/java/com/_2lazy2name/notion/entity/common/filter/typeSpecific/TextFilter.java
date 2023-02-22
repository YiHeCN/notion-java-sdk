package com._2lazy2name.notion.entity.common.filter.typeSpecific;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.common.filter.PropertyFilter;
import lombok.*;

@Getter @Setter @NoArgsConstructor
public class TextFilter extends PropertyFilter {
    private TextFilterMethodEnum method;

    public TextFilter(PropertyTypeEnum type, String property, TextFilterMethodEnum method, String value) {
        checkIfSupported(type);
        this.type = type;
        this.property = property;
        this.method = method;
        this.value = value;
    }

    public static void checkIfSupported(PropertyTypeEnum type) {
        if (type != PropertyTypeEnum.TITLE && type != PropertyTypeEnum.RICH_TEXT && type != PropertyTypeEnum.URL &&
                type != PropertyTypeEnum.EMAIL && type != PropertyTypeEnum.PHONE_NUMBER) {
            throw new IllegalArgumentException("TextFilter is not supported for type " + type + ". SEE: https://developers.notion.com/reference/post-database-query-filter#text-filter-condition");
        }
    }

    public TextFilter on(PropertyTypeEnum type, String property) {
        this.type = type;
        this.property = property;
        return this;
    }

    public TextFilter asField(PropertyTypeEnum propertyTypeEnum) {
        checkIfSupported(propertyTypeEnum);
        this.type = propertyTypeEnum;
        this.property = null;
        return this;
    }

    public TextFilter equals(String value) {
        this.method = TextFilterMethodEnum.EQUALS;
        this.value = value;
        return this;
    }

    public TextFilter doesNotEqual(String value) {
        this.method = TextFilterMethodEnum.DOES_NOT_EQUAL;
        this.value = value;
        return this;
    }

    public TextFilter contains(String value) {
        this.method = TextFilterMethodEnum.CONTAINS;
        this.value = value;
        return this;
    }

    public TextFilter doesNotContain(String value) {
        this.method = TextFilterMethodEnum.DOES_NOT_CONTAIN;
        this.value = value;
        return this;
    }

    public TextFilter startsWith(String value) {
        this.method = TextFilterMethodEnum.STARTS_WITH;
        this.value = value;
        return this;
    }

    public TextFilter endsWith(String value) {
        this.method = TextFilterMethodEnum.ENDS_WITH;
        this.value = value;
        return this;
    }

    public TextFilter isEmpty() {
        this.method = TextFilterMethodEnum.IS_EMPTY;
        this.value = null;
        return this;
    }

    public TextFilter isNotEmpty() {
        this.method = TextFilterMethodEnum.IS_NOT_EMPTY;
        this.value = null;
        return this;
    }

    @Getter
    public enum TextFilterMethodEnum implements IFilterMethod {
        EQUALS("equals", STRING),
        DOES_NOT_EQUAL("does_not_equal", STRING),
        CONTAINS("contains", STRING),
        DOES_NOT_CONTAIN("does_not_contain", STRING),
        STARTS_WITH("starts_with", STRING),
        ENDS_WITH("ends_with", STRING),
        IS_EMPTY("is_empty", BOOLEAN_ONLY_TRUE),
        IS_NOT_EMPTY("is_not_empty", BOOLEAN_ONLY_TRUE);

        private final String method;
        private final int valueType;

        TextFilterMethodEnum(String method, int valueType) {
            this.method = method;
            this.valueType = valueType;
        }
    }
}