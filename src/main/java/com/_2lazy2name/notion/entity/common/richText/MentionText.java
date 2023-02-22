package com._2lazy2name.notion.entity.common.richText;

import com._2lazy2name.notion.entity.common.richText.mention.AbstractMention;
import com._2lazy2name.notion.entity.enumeration.type.TextTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class MentionText extends AbstractRichText {
    private TextTypeEnum type = TextTypeEnum.MENTION;
    private AbstractMention mention;
}
