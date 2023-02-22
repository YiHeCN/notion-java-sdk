package com._2lazy2name.notion.entity.block.table;

import com._2lazy2name.notion.entity.block.AbstractBlock;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class TableRow extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.TABLE_ROW;
    List<TableCell> children;
}
