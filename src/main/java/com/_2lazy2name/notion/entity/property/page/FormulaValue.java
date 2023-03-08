package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.enumeration.type.FormulaTypeEnum;
import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object cannot be updated, I guess.
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#formula">Formula</a>
 */
public class FormulaValue extends AbstractPagePropertyValue {
    private PropertyTypeEnum type = PropertyTypeEnum.FORMULA;
    private Formula formula;

    @JsonSubTypes({
            @JsonSubTypes.Type(value = NumberFormula.class, name = "number"),
            @JsonSubTypes.Type(value = BooleanFormula.class, name = "boolean"),
            @JsonSubTypes.Type(value = DateFormula.class, name = "date"),
            @JsonSubTypes.Type(value = StringFormula.class, name = "string")
    })
    @JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, property = "type", visible = true)
    public abstract static class Formula {
        private FormulaTypeEnum type;

        public FormulaTypeEnum getType() {
            return type;
        }

        public Formula setType(FormulaTypeEnum type) {
            this.type = type;
            return this;
        }
    }

    public static class NumberFormula extends Formula {
        private FormulaTypeEnum type = FormulaTypeEnum.NUMBER;
        private Double number;

        @Override
        public FormulaTypeEnum getType() {
            return type;
        }

        @Override
        public NumberFormula setType(FormulaTypeEnum type) {
            this.type = type;
            return this;
        }

        public Double getNumber() {
            return number;
        }

        public NumberFormula setNumber(Double number) {
            this.number = number;
            return this;
        }
    }

    public static class BooleanFormula extends Formula {
        private final FormulaTypeEnum type = FormulaTypeEnum.BOOLEAN;
        @JsonProperty("boolean")
        private Boolean booleanVal;

        @Override
        public FormulaTypeEnum getType() {
            return type;
        }

        public Boolean getBooleanVal() {
            return booleanVal;
        }

        public BooleanFormula setBooleanVal(Boolean booleanVal) {
            this.booleanVal = booleanVal;
            return this;
        }
    }

    public static class DateFormula extends Formula {
        private FormulaTypeEnum type = FormulaTypeEnum.DATE;
        private String date;

        @Override
        public FormulaTypeEnum getType() {
            return type;
        }

        @Override
        public DateFormula setType(FormulaTypeEnum type) {
            this.type = type;
            return this;
        }

        public String getDate() {
            return date;
        }

        public DateFormula setDate(String date) {
            this.date = date;
            return this;
        }
    }

    public static class StringFormula extends Formula {
        private FormulaTypeEnum type = FormulaTypeEnum.STRING;
        private String string;

        @Override
        public FormulaTypeEnum getType() {
            return type;
        }

        @Override
        public StringFormula setType(FormulaTypeEnum type) {
            this.type = type;
            return this;
        }

        public String getString() {
            return string;
        }

        public StringFormula setString(String string) {
            this.string = string;
            return this;
        }
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    @Override
    public FormulaValue setType(PropertyTypeEnum type) {
        this.type = type;
        return this;
    }

    public Formula getFormula() {
        return formula;
    }

    public FormulaValue setFormula(Formula formula) {
        this.formula = formula;
        return this;
    }
}
