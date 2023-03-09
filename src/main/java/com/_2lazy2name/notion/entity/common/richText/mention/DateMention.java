package com._2lazy2name.notion.entity.common.richText.mention;

import com._2lazy2name.notion.entity.common.Date;
import com._2lazy2name.notion.enumeration.type.MentionTypeEnum;

public class DateMention extends AbstractMention {
    private final MentionTypeEnum type = MentionTypeEnum.DATE;
    private Date date;

    private DateMention() {
    }

    public DateMention(Date date) {
        this.date = date;
    }

    public MentionTypeEnum getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public DateMention setDate(Date date) {
        this.date = date;
        return this;
    }
}
