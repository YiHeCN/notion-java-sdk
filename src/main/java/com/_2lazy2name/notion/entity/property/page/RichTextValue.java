package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#rich-text">Rich Text</a>
 */
@Getter
@Setter
@ToString
public class RichTextValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.RICH_TEXT;
    private List<AbstractRichText> richText;

    private RichTextValue() {
    }

    public RichTextValue(List<AbstractRichText> richText) {
        this.richText = richText;
    }
}
