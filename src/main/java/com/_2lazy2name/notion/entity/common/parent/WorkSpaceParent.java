package com._2lazy2name.notion.entity.common.parent;

import com._2lazy2name.notion.entity.enumeration.type.ParentTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class WorkSpaceParent extends AbstractParent {
    private final ParentTypeEnum type = ParentTypeEnum.WORKSPACE;
    private final boolean workspace = true;
    private static final WorkSpaceParent INSTANCE = new WorkSpaceParent();

    private WorkSpaceParent() {
    }

    public static WorkSpaceParent getInstance() {
        return INSTANCE;
    }
}
