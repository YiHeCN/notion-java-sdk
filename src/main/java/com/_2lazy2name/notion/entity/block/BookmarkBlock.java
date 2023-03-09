package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.common.richText.TextText;
import com._2lazy2name.notion.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author Chole
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/block#bookmark">Bookmark Block</a>
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BookmarkBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.BOOKMARK;
    private Bookmark bookmark;

    public static class Builder {
        private String url;
        private List<AbstractRichText> caption;

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder caption(String caption) {
            this.caption = List.of(new TextText(caption));
            return this;
        }

        public Builder caption(List<AbstractRichText> caption) {
            this.caption = caption;
            return this;
        }

        public BookmarkBlock build() {
            return new BookmarkBlock(url, caption);
        }
    }

    @JsonIgnore
    public String getUrl() {
        return this.bookmark.url;
    }
    public BookmarkBlock setUrl(String bookmark) {
        this.bookmark.url = bookmark;
        return this;
    }

    @JsonIgnore
    public List<AbstractRichText> getCaption() {
        return this.bookmark.caption;
    }
    public BookmarkBlock setCaption(List<AbstractRichText> caption) {
        this.bookmark.caption = caption;
        return this;
    }
    public BookmarkBlock setCaption(String caption) {
        this.bookmark.caption = List.of(new TextText(caption));
        return this;
    }

    @Override
    public BlockTypeEnum getType() { return type; }

    private BookmarkBlock() {}
    private BookmarkBlock(String url, List<AbstractRichText> caption) {
        this.bookmark = new Bookmark();
        this.bookmark.url = url;
        this.bookmark.caption = caption;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class Bookmark {
        private String url;
        private List<AbstractRichText> caption;

        private String getUrl() {
            return url;
        }

        private Bookmark setUrl(String url) {
            this.url = url;
            return this;
        }

        private List<AbstractRichText> getCaption() {
            return caption;
        }

        private Bookmark setCaption(List<AbstractRichText> caption) {
            this.caption = caption;
            return this;
        }
    }

    private Bookmark getBookmark() {
        return this.bookmark;
    }
    private BookmarkBlock setBookmark(Bookmark bookmark) {
        this.bookmark = bookmark;
        return this;
    }
}
