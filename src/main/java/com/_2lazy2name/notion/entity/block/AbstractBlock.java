package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.User;
import com._2lazy2name.notion.entity.block.fileRelated.FileBlock;
import com._2lazy2name.notion.entity.block.fileRelated.ImageBlock;
import com._2lazy2name.notion.entity.block.fileRelated.PdfBlock;
import com._2lazy2name.notion.entity.block.fileRelated.VideoBlock;
import com._2lazy2name.notion.entity.block.heading.HeadingOneBlock;
import com._2lazy2name.notion.entity.block.heading.HeadingThreeBlock;
import com._2lazy2name.notion.entity.block.heading.HeadingTwoBlock;
import com._2lazy2name.notion.entity.block.list.BulletedListItemBlock;
import com._2lazy2name.notion.entity.block.list.NumberedListItemBlock;
import com._2lazy2name.notion.entity.block.list.ToDoBlock;
import com._2lazy2name.notion.entity.block.table.TableBlock;
import com._2lazy2name.notion.entity.block.table.TableRow;
import com._2lazy2name.notion.entity.common.parent.AbstractParent;
import com._2lazy2name.notion.enumeration.ObjectEnum;
import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.*;

import java.util.Date;


/**
 * @author Yi
 * @version 1.0.0
 * @since 1.0.0
 * @see <a href="https://developers.notion.com/reference/block">Block object</a>
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TableRow.class, name = "table_row"),
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
        @JsonSubTypes.Type(value = ColumnBlock.class, name = "column"),
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
        @JsonSubTypes.Type(value = EmbedBlock.class, name = "embed"),
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

    public static void clearUnmodifiableInfo(AbstractBlock block) {
        if (block == null) return;
        block.createdTime = null;
        block.createdBy = null;
        block.lastEditedTime = null;
        block.lastEditedBy = null;
        block.hasChildren = null;
    }

    @JsonIgnore
    public ObjectEnum getObject() {
        return object;
    }

    public String getId() {
        return id;
    }

    public AbstractBlock setId(String id) {
        this.id = id;
        return this;
    }

    public AbstractParent getParent() {
        return parent;
    }

    public AbstractBlock setParent(AbstractParent parent) {
        this.parent = parent;
        return this;
    }

    public BlockTypeEnum getType() {
        return type;
    }

    public AbstractBlock setType(BlockTypeEnum type) {
        this.type = type;
        return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public AbstractBlock setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public AbstractBlock setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Date getLastEditedTime() {
        return lastEditedTime;
    }

    public AbstractBlock setLastEditedTime(Date lastEditedTime) {
        this.lastEditedTime = lastEditedTime;
        return this;
    }

    public User getLastEditedBy() {
        return lastEditedBy;
    }

    public AbstractBlock setLastEditedBy(User lastEditedBy) {
        this.lastEditedBy = lastEditedBy;
        return this;
    }

    public Boolean getArchived() {
        return archived;
    }

    public AbstractBlock setArchived(Boolean archived) {
        this.archived = archived;
        return this;
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public AbstractBlock setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
        return this;
    }
}
    