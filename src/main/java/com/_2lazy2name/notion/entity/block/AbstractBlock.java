package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.User;
import com._2lazy2name.notion.entity.block.heading.HeadingOneBlock;
import com._2lazy2name.notion.entity.block.heading.HeadingThreeBlock;
import com._2lazy2name.notion.entity.block.heading.HeadingTwoBlock;
import com._2lazy2name.notion.entity.block.list.BulletedListItemBlock;
import com._2lazy2name.notion.entity.block.list.NumberedListItemBlock;
import com._2lazy2name.notion.entity.block.list.ToDoBlock;
import com._2lazy2name.notion.entity.block.table.TableBlock;
import com._2lazy2name.notion.entity.block.table.TableCell;
import com._2lazy2name.notion.entity.block.table.TableRow;
import com._2lazy2name.notion.entity.common.parent.AbstractParent;
import com._2lazy2name.notion.entity.enumeration.ObjectEnum;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


/**
 * @author Yi
 * @version 1.0.0
 * @since 1.0.0
 * @see <a href="https://developers.notion.com/reference/block">Block object</a>
 */
@Getter @Setter @ToString
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TableRow.class, name = "table_row"),
        @JsonSubTypes.Type(value = TableCell.class, name = "table_cell"),
        @JsonSubTypes.Type(value = HeadingOneBlock.class, name = "heading_1"),
        @JsonSubTypes.Type(value = HeadingTwoBlock.class, name = "heading_2"),
        @JsonSubTypes.Type(value = HeadingThreeBlock.class, name = "heading_3"),
        @JsonSubTypes.Type(value = BulletedListItemBlock.class, name = "bulleted_list_item"),
        @JsonSubTypes.Type(value = NumberedListItemBlock.class, name = "numbered_list_item"),
        @JsonSubTypes.Type(value = ToDoBlock.class, name = "to_do"),
        @JsonSubTypes.Type(value = BookmarkBlock.class, name = "bookmark"),
        @JsonSubTypes.Type(value = BreadcrumbBlock.class, name = "breadcrumb"),
        @JsonSubTypes.Type(value = CalloutBlock.class, name = "callout"),
        @JsonSubTypes.Type(value = ChildPageBlock.class, name = "child_page"),
        @JsonSubTypes.Type(value = CodeBlock.class, name = "code"),
        @JsonSubTypes.Type(value = ColumnListBlock.class, name = "column_list"),
        @JsonSubTypes.Type(value = DividerBlock.class, name = "divider"),
        @JsonSubTypes.Type(value = EquationBlock.class, name = "equation"),
        @JsonSubTypes.Type(value = FileBlock.class, name = "file"),
        @JsonSubTypes.Type(value = ImageBlock.class, name = "image"),
        @JsonSubTypes.Type(value = LinkPreviewBlock.class, name = "link_preview"),
        @JsonSubTypes.Type(value = LinkToPageBlock.class, name = "link_to_page"),
        @JsonSubTypes.Type(value = ParagraphBlock.class, name = "paragraph"),
        @JsonSubTypes.Type(value = PdfBlock.class, name = "pdf"),
        @JsonSubTypes.Type(value = QuoteBlock.class, name = "quote"),
        @JsonSubTypes.Type(value = SyncedBlockBlock.class, name = "synced_block"),
        @JsonSubTypes.Type(value = TableBlock.class, name = "table"),
        @JsonSubTypes.Type(value = TableOfContentsBlock.class, name = "table_of_contents"),
        @JsonSubTypes.Type(value = TemplateBlock.class, name = "template"),
        @JsonSubTypes.Type(value = ToggleBlock.class, name = "toggle"),
        @JsonSubTypes.Type(value = VideoBlock.class, name = "video"),
})
public abstract class AbstractBlock {
    private final ObjectEnum object = ObjectEnum.BLOCK;
    private String id;
    private AbstractParent parent;
    protected BlockTypeEnum type;
    private Date createdTime;
    private User createdBy;
    private Date lastEditedTime;
    private User lastEditedBy;
    private Boolean archived;
    private Boolean hasChildren;

    public void clearUnmodifiableInfo() {
        this.createdTime = null;
        this.createdBy = null;
        this.lastEditedTime = null;
        this.lastEditedBy = null;
        this.hasChildren = null;
    }
}
    