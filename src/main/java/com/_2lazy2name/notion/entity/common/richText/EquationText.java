package com._2lazy2name.notion.entity.common.richText;

import com._2lazy2name.notion.entity.enumeration.type.TextTypeEnum;

public class EquationText extends AbstractRichText {
    private final static TextTypeEnum type = TextTypeEnum.EQUATION;
    private Equation equation;

    public static class Equation {
        private String expression;

        public String getExpression() {
            return expression;
        }

        public Equation setExpression(String expression) {
            this.expression = expression;
            return this;
        }
    }

    public Equation getEquation() {
        return equation;
    }

    public EquationText setEquation(Equation equation) {
        this.equation = equation;
        return this;
    }


}
