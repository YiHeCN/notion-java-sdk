package com._2lazy2name.notion.entity.common.file;

import com._2lazy2name.notion.enumeration.type.FileTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.Date;

/**
 * @author Chole
 * @since 1.0
 * @version 1.0
 * @see <a href="https://developers.notion.com/reference/file-object#notion-hosted-files">NotionFile</a>
 */
public class NotionHostedFile extends AbstractFile {
    private final FileTypeEnum type = FileTypeEnum.FILE;
    private File file;

    @JsonIgnore
    public Date getExpiryTime() {
        return this.file.getExpiryTime();
    }

    @JsonIgnore
    public String getUrl() {
        return this.file.getUrl();
    }

    private static class File {
        private String url;
        private Date expiryTime;

        public String getUrl() {
            return url;
        }

        public File setUrl(String url) {
            this.url = url;
            return this;
        }

        public Date getExpiryTime() {
            return expiryTime;
        }

        public File setExpiryTime(Date expiryTime) {
            this.expiryTime = expiryTime;
            return this;
        }
    }

    private NotionHostedFile(String name, String url, Date expiryTime) {
        super();
        this.name = name;
        this.file = new File();
        this.file.setUrl(url);
        this.file.setExpiryTime(expiryTime);
    }

    @Override
    public FileTypeEnum getType() {
        return type;
    }

    private File getFile() {
        return file;
    }

    private NotionHostedFile setFile(File file) {
        this.file = file;
        return this;
    }

    private NotionHostedFile() {
    }
}
