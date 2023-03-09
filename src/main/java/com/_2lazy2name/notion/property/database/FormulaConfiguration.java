package com._2lazy2name.notion.property.database;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

/***
 * TODO: Not work
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#formula-configuration">Formula Configuration</a>
 */
public class FormulaConfiguration extends AbstractDatabaseProperty {
    private final PropertyTypeEnum type = PropertyTypeEnum.FORMULA;
    private Formula formula;


    private static class Formula {
        private String expression;

        public String getExpression() {
            return expression;
        }

        public Formula setExpression(String expression) {
            this.expression = expression;
            return this;
        }
    }

    private FormulaConfiguration() {
    }

    public FormulaConfiguration(String expression) {
        this.formula = new Formula();
        this.formula.setExpression(expression);
    }

    @JsonIgnore
    public String getExpression() {
        return this.formula.getExpression();
    }

    public void setExpression(String expression) {
        this.formula.setExpression(expression);
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public Formula getFormula() {
        return formula;
    }

    public FormulaConfiguration setFormula(Formula formula) {
        this.formula = formula;
        return this;
    }
}
