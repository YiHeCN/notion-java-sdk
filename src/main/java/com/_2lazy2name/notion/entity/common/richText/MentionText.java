package com._2lazy2name.notion.entity.common.richText;

import com._2lazy2name.notion.entity.common.richText.mention.AbstractMention;
import com._2lazy2name.notion.enumeration.type.TextTypeEnum;

public class MentionText extends AbstractRichText {
    private final TextTypeEnum type = TextTypeEnum.MENTION;
    private AbstractMention mention;

    private MentionText() {
    }

    public MentionText(AbstractMention mention) {
        this.mention = mention;
    }

    public AbstractMention getMention() {
        return mention;
    }

    public MentionText setMention(AbstractMention mention) {
        this.mention = mention;
        return this;
    }

    @Override
    public TextTypeEnum getType() {
        return type;
    }
}
