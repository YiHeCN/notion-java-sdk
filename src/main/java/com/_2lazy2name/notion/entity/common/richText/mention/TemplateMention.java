package com._2lazy2name.notion.entity.common.richText.mention;

import com._2lazy2name.notion.entity.enumeration.TemplateMentionEnum;
import com._2lazy2name.notion.entity.enumeration.TemplateMentionValueEnum;
import com._2lazy2name.notion.entity.enumeration.type.MentionTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

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



    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class TemplateMentionDetail {
        private TemplateMentionEnum type;
        private TemplateMentionValueEnum templateMentionDate;
        private TemplateMentionValueEnum templateMentionUser;

        public TemplateMentionEnum getType() {
            return type;
        }

        public TemplateMentionDetail setType(TemplateMentionEnum type) {
            this.type = type;
            return this;
        }

        public TemplateMentionValueEnum getTemplateMentionDate() {
            return templateMentionDate;
        }

        public TemplateMentionDetail setTemplateMentionDate(TemplateMentionValueEnum templateMentionDate) {
            this.templateMentionDate = templateMentionDate;
            return this;
        }

        public TemplateMentionValueEnum getTemplateMentionUser() {
            return templateMentionUser;
        }

        public TemplateMentionDetail setTemplateMentionUser(TemplateMentionValueEnum templateMentionUser) {
            this.templateMentionUser = templateMentionUser;
            return this;
        }
    }

    public MentionTypeEnum getType() {
        return type;
    }

    public TemplateMentionDetail getTemplateMention() {
        return templateMention;
    }

    public TemplateMention setTemplateMention(TemplateMentionDetail templateMention) {
        this.templateMention = templateMention;
        return this;
    }
}
