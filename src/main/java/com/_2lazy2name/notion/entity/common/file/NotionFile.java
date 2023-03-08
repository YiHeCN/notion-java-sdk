package com._2lazy2name.notion.entity.common.file;

import com._2lazy2name.notion.entity.enumeration.type.FileTypeEnum;


import java.util.Date;


public class NotionFile extends AbstractFile {
    private final FileTypeEnum type = FileTypeEnum.FILE;
    private File file;


    public static class File {
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

    public NotionFile(String name, String url, Date expiryTime) {
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

    public File getFile() {
        return file;
    }

    public NotionFile setFile(File file) {
        this.file = file;
        return this;
    }

    public NotionFile() {
    }
}
