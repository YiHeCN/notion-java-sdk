package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.entity.enumeration.type.BlockTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EmbedBlock extends AbstractBlock {
    private static final BlockTypeEnum type = BlockTypeEnum.EMBED;
    private Embed embed;

    public static EmbedBlock ofUrl(String url) {
        return new EmbedBlock(url);
    }

    @JsonIgnore
    public String getUrl() {
        return this.embed.url;
    }
    private EmbedBlock setUrl(String url) {
        this.embed.url = url;
        return this;
    }

    @Override
    public BlockTypeEnum getType() {
        return type;
    }

    private EmbedBlock() {}

    private EmbedBlock(String url) {
        this.embed = new Embed();
        this.embed.url = url;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class Embed {
        private String url;

        private String getUrl() {
            return url;
        }

        private Embed setUrl(String url) {
            this.url = url;
            return this;
        }
    }

    private Embed getEmbed() {
        return embed;
    }

    private EmbedBlock setEmbed(Embed embed) {
        this.embed = embed;
        return this;
    }

}
