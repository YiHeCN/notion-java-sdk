package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EquationBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.EQUATION;
    private Equation equation;

    public static EquationBlock ofExpression(String expression) {
        return new EquationBlock(expression);
    }

    @JsonIgnore
    public String getExpression() {
        return this.equation.expression;
    }
    private EquationBlock setExpression(String expression) {
        this.equation.expression = expression;
        return this;
    }

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private EquationBlock() {}

    private EquationBlock(String expression) {
        this.equation = new Equation();
        this.equation.expression = expression;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
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

    private Equation getEquation() {
        return equation;
    }

    private EquationBlock setEquation(Equation equation) {
        this.equation = equation;
        return this;
    }


}
