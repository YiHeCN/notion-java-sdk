package com._2lazy2name.notion.entity.common.filter.typeSpecific;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.common.filter.PropertyFilter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class FormulaFilter extends PropertyFilter {
    private final PropertyTypeEnum type = PropertyTypeEnum.FORMULA;
    private FormulaFilterMethodEnum method;

    public FormulaFilter(String property, FormulaFilterMethodEnum method, Object value) {
        this.property = property;
        this.method = method;
        this.value = value;
    }

    public FormulaFilter on(String property) {
        this.property = property;
        return this;
    }

    public FormulaFilter string(TextFilter value) {
        this.method = FormulaFilterMethodEnum.STRING;
        this.value = value;
        return this;
    }

    public FormulaFilter checkbox(CheckboxFilter value) {
        this.method = FormulaFilterMethodEnum.CHECKBOX;
        this.value = value;
        return this;
    }

    public FormulaFilter number(NumberFilter value) {
        this.method = FormulaFilterMethodEnum.NUMBER;
        this.value = value;
        return this;
    }

    public FormulaFilter date(DateFilter value) {
        this.method = FormulaFilterMethodEnum.DATE;
        this.value = value;
        return this;
    }

    @Getter
    public enum FormulaFilterMethodEnum implements IFilterMethod {
        STRING("string", FILTER_OBJECT),
        CHECKBOX("checkbox", FILTER_OBJECT),
        NUMBER("number", FILTER_OBJECT),
        DATE("date", FILTER_OBJECT);


        private final String method;
        private final int valueType;

        FormulaFilterMethodEnum (String method, int valueType) {
            this.method = method;
            this.valueType = valueType;
        }
    }
}
