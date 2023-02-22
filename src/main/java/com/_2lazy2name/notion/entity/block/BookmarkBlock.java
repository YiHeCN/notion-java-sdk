package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString @Getter @Setter
public class BookmarkBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.BOOKMARK;
    private String url;
    private List<AbstractRichText> caption;

    private BookmarkBlock() {}

    public BookmarkBlock(String url, List<AbstractRichText> caption) {
        this.url = url;
        this.caption = caption;
    }

    private static BookmarkBlock getInstance() {
        return new BookmarkBlock();
    }

    public static class Builder {
        private String url;
        private List<AbstractRichText> caption;

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder caption(String caption) {
            this.caption = List.of(AbstractRichText.buildPlainText(caption));
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
}
