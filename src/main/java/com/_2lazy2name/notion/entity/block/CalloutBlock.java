package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.block.builder.impl.TextColorBuilder;
import com._2lazy2name.notion.entity.common.icon.AbstractIcon;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.common.richText.TextText;
import com._2lazy2name.notion.enumeration.ColorEnum;
import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CalloutBlock extends AbstractBlock {
    private final static BlockTypeEnum type = BlockTypeEnum.CALLOUT;
    private Callout callout;

    public static class Builder extends TextColorBuilder<Builder, CalloutBlock> {
        private AbstractIcon icon;

        public Builder icon(AbstractIcon icon) {
            this.icon = icon;
            return this;
        }

        public CalloutBlock build() {
            return new CalloutBlock(richText, icon, color);
        }
    }

    @JsonIgnore
    public AbstractIcon getIcon() {
        return this.callout.icon;
    }
    public void setIcon(AbstractIcon icon) {
        this.callout.icon = icon;
    }

    @JsonIgnore
    public ColorEnum getColor() {
        return this.callout.color;
    }
    public CalloutBlock setColor(ColorEnum color) {
        this.callout.color = color;
        return this;
    }

    @JsonIgnore
    public List<AbstractRichText> getRichText() {
        return this.callout.richText;
    }
    public CalloutBlock setRichText(List<AbstractRichText> richText) {
        this.callout.richText = richText;
        return this;
    }
    public CalloutBlock setRichText(AbstractRichText richText) {
        this.callout.richText = List.of(richText);
        return this;
    }
    public CalloutBlock setRichText(String text) {
        this.callout.richText = List.of(new TextText(text));
        return this;
    }

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private CalloutBlock() {}

    private CalloutBlock(List<AbstractRichText> richText, AbstractIcon icon, ColorEnum color) {
        this.callout = new Callout();
        this.callout.richText = richText;
        this.callout.icon = icon;
        this.callout.color = color;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class Callout extends TextColorBuilder<Builder, CalloutBlock> {
        private AbstractIcon icon;
        private ColorEnum color;
        private List<AbstractRichText> richText;

        private AbstractIcon getIcon() {
            return icon;
        }

        private Callout setIcon(AbstractIcon icon) {
            this.icon = icon;
            return this;
        }

        @Override
        public CalloutBlock build() {
            return new CalloutBlock(richText, icon, color);
        }
    }

    private Callout getCallout() {
        return callout;
    }

    private CalloutBlock setCallout(Callout callout) {
        this.callout = callout;
        return this;
    }


}
