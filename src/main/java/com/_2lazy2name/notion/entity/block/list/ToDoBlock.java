package com._2lazy2name.notion.entity.block.list;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.block.builder.impl.TextColorBuilder;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.common.richText.TextText;
import com._2lazy2name.notion.enumeration.ColorEnum;
import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author Chole
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/block#to-do-blocks">To Do Block</a>
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ToDoBlock extends AbstractBlock {
    private final static BlockTypeEnum type = BlockTypeEnum.TO_DO;
    private ToDo toDo;

    public static class Builder extends TextColorBuilder<Builder, ToDoBlock> {
        private Boolean checked;

        public Builder checked(Boolean checked) {
            this.checked = checked;
            return this;
        }

        public ToDoBlock build() {
            return new ToDoBlock(richText, color);
        }
    }

    @JsonIgnore
    public List<AbstractRichText> getRichText() {
        return this.toDo.richText;
    }

    public ToDoBlock setRichText(List<AbstractRichText> richText) {
        this.toDo.richText = richText;
        return this;
    }
    public ToDoBlock setRichText(AbstractRichText richText) {
        this.toDo.richText = List.of(richText);
        return this;
    }
    public ToDoBlock setRichText(String text) {
        this.toDo.richText = List.of(new TextText(text));
        return this;
    }

    @JsonIgnore
    public ColorEnum getColor() {
        return this.toDo.color;
    }

    public ToDoBlock setColor(ColorEnum color) {
        this.toDo.color = color;
        return this;
    }

    @JsonIgnore
    public List<AbstractBlock> getChildren() {
        return this.toDo.children;
    }

    private ToDoBlock setChildren(List<AbstractBlock> children) {
        this.toDo.children = children;
        return this;
    }

    public Boolean isChecked() {
        return this.toDo.checked;
    }

    @JsonIgnore
    public ToDoBlock setChecked(Boolean checked) {
        this.toDo.checked = checked;
        return this;
    }

    private ToDoBlock() {}

    private ToDoBlock(List<AbstractRichText> richText, ColorEnum color) {
        this.toDo = new ToDo();
        this.toDo.richText = richText;
        this.toDo.color = color;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class ToDo {
        private List<AbstractRichText> richText;
        private ColorEnum color;
        private List<AbstractBlock> children;
        private Boolean checked;

        private List<AbstractRichText> getRichText() {
            return richText;
        }

        private ToDo setRichText(List<AbstractRichText> richText) {
            this.richText = richText;
            return this;
        }

        private ColorEnum getColor() {
            return color;
        }

        private ToDo setColor(ColorEnum color) {
            this.color = color;
            return this;
        }

        private List<AbstractBlock> getChildren() {
            return children;
        }

        private ToDo setChildren(List<AbstractBlock> children) {
            this.children = children;
            return this;
        }

        private Boolean isChecked() {
            return checked;
        }

        private ToDo setChecked(Boolean checked) {
            this.checked = checked;
            return this;
        }
    }

    private ToDo getToDo() {
        return toDo;
    }

    private ToDoBlock setToDo(ToDo toDo) {
        this.toDo = toDo;
        return this;
    }
}
