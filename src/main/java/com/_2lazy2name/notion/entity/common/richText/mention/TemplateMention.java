package com._2lazy2name.notion.entity.common.richText.mention;

import com._2lazy2name.notion.enumeration.TemplateMentionEnum;
import com._2lazy2name.notion.enumeration.TemplateMentionValueEnum;
import com._2lazy2name.notion.enumeration.type.MentionTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TemplateMention extends AbstractMention {
    private final MentionTypeEnum type = MentionTypeEnum.TEMPLATE_MENTION;
    private TemplateMentionDetail templateMention;

    private TemplateMention() {
    }

    public TemplateMention(TemplateMentionValueEnum templateMentionValueEnum) {
        this.templateMention = new TemplateMentionDetail();
        if (isDateMention(templateMentionValueEnum)) {
            this.templateMention.setType(TemplateMentionEnum.DATE);
            this.templateMention.setTemplateMentionDate(templateMentionValueEnum);
        } else {
            this.templateMention.setType(TemplateMentionEnum.USER);
            this.templateMention.setTemplateMentionUser(templateMentionValueEnum);
        }
    }

    // Rude ;(
    public TemplateMention setTemplateMention(TemplateMentionValueEnum templateMentionValueEnum) {
        return new TemplateMention(templateMentionValueEnum);
    }

    public TemplateMentionValueEnum getTemplateMentionValue() {
        return isDateMention() ? this.templateMention.getTemplateMentionDate() : this.templateMention.getTemplateMentionUser();
    }

    public boolean isDateMention() {
        return this.templateMention.getType() == TemplateMentionEnum.DATE;
    }

    private static boolean isDateMention(TemplateMentionValueEnum templateMentionValueEnum) {
        return templateMentionValueEnum == TemplateMentionValueEnum.TODAY
                || templateMentionValueEnum == TemplateMentionValueEnum.NOW;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class TemplateMentionDetail {
        private TemplateMentionEnum type;
        private TemplateMentionValueEnum templateMentionDate;
        private TemplateMentionValueEnum templateMentionUser;

        private TemplateMentionEnum getType() {
            return type;
        }

        private TemplateMentionDetail setType(TemplateMentionEnum type) {
            this.type = type;
            return this;
        }

        private TemplateMentionValueEnum getTemplateMentionDate() {
            return templateMentionDate;
        }

        private TemplateMentionDetail setTemplateMentionDate(TemplateMentionValueEnum templateMentionDate) {
            this.templateMentionDate = templateMentionDate;
            return this;
        }

        private TemplateMentionValueEnum getTemplateMentionUser() {
            return templateMentionUser;
        }

        private TemplateMentionDetail setTemplateMentionUser(TemplateMentionValueEnum templateMentionUser) {
            this.templateMentionUser = templateMentionUser;
            return this;
        }
    }

    @Override
    public MentionTypeEnum getType() {
        return type;
    }

    private TemplateMentionDetail getTemplateMention() {
        return templateMention;
    }

    private TemplateMention setTemplateMention(TemplateMentionDetail templateMention) {
        this.templateMention = templateMention;
        return this;
    }
}
