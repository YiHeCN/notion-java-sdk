package com._2lazy2name.notion.entity.common.richText.mention;

import com._2lazy2name.notion.entity.enumeration.TemplateMentionEnum;
import com._2lazy2name.notion.entity.enumeration.TemplateMentionValueEnum;
import com._2lazy2name.notion.entity.enumeration.type.MentionTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class TemplateMention extends AbstractMention {
    private final MentionTypeEnum type = MentionTypeEnum.TEMPLATE_MENTION;
    private TemplateMentionDetail templateMention;

    private TemplateMention() {
    }

    public TemplateMention(TemplateMentionValueEnum templateMentionValueEnum) {
        this.templateMention = new TemplateMentionDetail();
        if (templateMentionValueEnum == TemplateMentionValueEnum.TODAY
                || templateMentionValueEnum == TemplateMentionValueEnum.NOW) {
            this.templateMention.setType(TemplateMentionEnum.DATE);
            this.templateMention.setTemplateMentionDate(templateMentionValueEnum);
        }

        if (templateMentionValueEnum == TemplateMentionValueEnum.ME) {
            this.templateMention.setType(TemplateMentionEnum.USER);
            this.templateMention.setTemplateMentionUser(templateMentionValueEnum);
        }
    }



    @Getter @Setter @ToString
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class TemplateMentionDetail {
        private TemplateMentionEnum type;
        private TemplateMentionValueEnum templateMentionDate;
        private TemplateMentionValueEnum templateMentionUser;
    }

}
