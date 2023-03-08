package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.block.builder.impl.TextBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TemplateBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.TEMPLATE;
    private Template template;

    public static class Builder extends TextBuilder<Builder, TemplateBlock> {
        public TemplateBlock build() {
            return new TemplateBlock(richText);
        }
    }

    @JsonIgnore
    public List<AbstractRichText> getRichText() {
        return this.template.richText;
    }

    public TemplateBlock setRichText(List<AbstractRichText> richText) {
        this.template.richText = richText;
        return this;
    }

    @JsonIgnore
    public List<AbstractBlock> getChildren() {
        return this.template.children;
    }

    private TemplateBlock setChildren(List<AbstractBlock> children) {
        this.template.children = children;
        return this;
    }

    @Override
    public BlockTypeEnum getType() {
        return type;
    }


    private TemplateBlock() {}
    private TemplateBlock(List<AbstractRichText> richText) {
        this.template = new Template();
        this.template.richText = richText;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class Template {
        private List<AbstractBlock> children;
        private List<AbstractRichText> richText;

        public List<AbstractBlock> getChildren() {
            return children;
        }

        public Template setChildren(List<AbstractBlock> children) {
            this.children = children;
            return this;
        }

        public List<AbstractRichText> getRichText() {
            return richText;
        }

        public Template setRichText(List<AbstractRichText> richText) {
            this.richText = richText;
            return this;
        }
    }

    public Template getTemplate() {
        return template;
    }

    public TemplateBlock setTemplate(Template template) {
        this.template = template;
        return this;
    }
}
