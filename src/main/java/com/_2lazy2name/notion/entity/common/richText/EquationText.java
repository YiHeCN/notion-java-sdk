package com._2lazy2name.notion.entity.common.richText;

import com._2lazy2name.notion.enumeration.type.TextTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EquationText extends AbstractRichText {
    private final static TextTypeEnum type = TextTypeEnum.EQUATION;
    private Equation equation;

    private EquationText() {
    }

    public EquationText(String equation) {
        this.equation = new Equation();
        this.equation.setExpression(equation);
    }

    @JsonIgnore
    public String getExpression() {
        return equation.getExpression();
    }

    public EquationText setExpression(String expression) {
        equation.setExpression(expression);
        return this;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class Equation {
        private String expression;

        private String getExpression() {
            return expression;
        }

        private Equation setExpression(String expression) {
            this.expression = expression;
            return this;
        }
    }

    @Override
    public TextTypeEnum getType() {
        return type;
    }

    private Equation getEquation() {
        return equation;
    }

    private EquationText setEquation(Equation equation) {
        this.equation = equation;
        return this;
    }
}
