package com._2lazy2name.notion.entity.common.richText.mention;

import com._2lazy2name.notion.entity.common.Date;
import com._2lazy2name.notion.entity.enumeration.type.MentionTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
public class DateMention extends AbstractMention {
    private final MentionTypeEnum type = MentionTypeEnum.DATE;
    private Date date;

    private DateMention() {
    }

    public DateMention(Date date) {
        this.date = date;
    }
}
