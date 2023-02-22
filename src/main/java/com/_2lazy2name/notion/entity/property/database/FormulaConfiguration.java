package com._2lazy2name.notion.entity.property.database;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * TODO: Not work
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/property-object#formula-configuration">Formula Configuration</a>
 */
@Getter
@Setter
@ToString
public class FormulaConfiguration extends AbstractDatabaseProperty {
    private final PropertyTypeEnum type = PropertyTypeEnum.FORMULA;
    private Formula formula;

    @Getter @Setter
    private static class Formula {
        private String expression;
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
}
