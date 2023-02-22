package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
public class EquationBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.EQUATION;
    private String expression;

    private EquationBlock() {}

    private EquationBlock(String expression) {
        this.expression = expression;
    }

    public static EquationBlock ofExpression(@NonNull String expression) {
        return new EquationBlock(expression);
    }
}
