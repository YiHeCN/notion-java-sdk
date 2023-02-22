package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.enumeration.type.FormulaTypeEnum;
import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This object cannot be updated, I guess.
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#formula">Formula</a>
 */
@Getter
@Setter
@ToString
public class FormulaValue extends AbstractPagePropertyValue {
    private PropertyTypeEnum type = PropertyTypeEnum.FORMULA;
    private Formula formula;

    @Getter @Setter @ToString
    @JsonSubTypes({
            @JsonSubTypes.Type(value = NumberFormula.class, name = "number"),
            @JsonSubTypes.Type(value = BooleanFormula.class, name = "boolean"),
            @JsonSubTypes.Type(value = DateFormula.class, name = "date"),
            @JsonSubTypes.Type(value = StringFormula.class, name = "string")
    })
    @JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, property = "type", visible = true)
    public abstract static class Formula {
        private FormulaTypeEnum type;
    }

    @Getter @Setter @ToString
    public static class NumberFormula extends Formula {
        private FormulaTypeEnum type = FormulaTypeEnum.NUMBER;
        private Double number;
    }

    @Getter @Setter @ToString
    public static class BooleanFormula extends Formula {
        private final FormulaTypeEnum type = FormulaTypeEnum.BOOLEAN;
        @JsonProperty("boolean")
        private Boolean booleanVal;
    }

    @Getter @Setter @ToString
    public static class DateFormula extends Formula {
        private FormulaTypeEnum type = FormulaTypeEnum.DATE;
        private String date;
    }

    @Getter @Setter @ToString
    public static class StringFormula extends Formula {
        private FormulaTypeEnum type = FormulaTypeEnum.STRING;
        private String string;
    }
}
