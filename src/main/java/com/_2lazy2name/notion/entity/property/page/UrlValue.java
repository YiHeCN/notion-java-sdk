package com._2lazy2name.notion.entity.property.page;

import com._2lazy2name.notion.entity.enumeration.type.PropertyTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * @author Yi
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/page-property-values#url">URL</a>
 */
@Getter
@Setter
@ToString
public class UrlValue extends AbstractPagePropertyValue {
    private final PropertyTypeEnum type = PropertyTypeEnum.URL;
    private String url;

    private UrlValue() {
    }

    public UrlValue(String url) {
        this.url = url;
    }
}
