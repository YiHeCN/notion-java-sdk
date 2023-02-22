package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#title">Title</a>
 */
@Getter
@Setter
@ToString
public class TitleValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.TITLE;
    private List<AbstractRichText> title;

    private TitleValue() {
    }

    public TitleValue(List<AbstractRichText> title) {
        this.title = title;
    }
}
