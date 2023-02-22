package com._2lazy2name.notion.entity.block.table;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString @Getter @Setter
public class TableBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.TABLE;
    Integer tableWidth;
    Boolean hasColumnHeader;
    Boolean hasRowHeader;
    List<TableRow> children;


}
