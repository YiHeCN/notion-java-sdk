package com._2lazy2name.notion.entity.common.parent;

import com._2lazy2name.notion.entity.enumeration.type.ParentTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PageParent extends AbstractParent {
    private final ParentTypeEnum type = ParentTypeEnum.PAGE_ID;
    private String pageId;
}
