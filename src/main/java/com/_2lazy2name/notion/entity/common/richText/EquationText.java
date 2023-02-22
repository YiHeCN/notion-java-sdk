package com._2lazy2name.notion.entity.common.richText;

import com._2lazy2name.notion.entity.enumeration.type.TextTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true) @Getter @Setter
public class EquationText extends AbstractRichText {
    private final static TextTypeEnum type = TextTypeEnum.EQUATION;
    private Equation equation;

    @ToString @Getter @Setter
    public static class Equation {
        private String expression;
    }
}
