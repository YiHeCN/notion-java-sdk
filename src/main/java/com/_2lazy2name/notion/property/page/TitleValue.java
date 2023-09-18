package com._2lazy2name.notion.property.page;

import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.common.richText.TextText;
import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#title">Title</a>
 */
public class TitleValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.TITLE;
    @JsonFormat(shape = JsonFormat.Shape.OBJECT, with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<AbstractRichText> title;

    private TitleValue() {
    }

    public TitleValue(List<AbstractRichText> title) {
        this.title = title;
    }

    public TitleValue(String title) {
        this.title = List.of(new TextText(title));
    }

    public TitleValue(AbstractRichText title) {
        this.title = List.of(title);
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    public List<AbstractRichText> getTitle() {
        return title;
    }

    public TitleValue setTitle(List<AbstractRichText> title) {
        this.title = title;
        return this;
    }
}
