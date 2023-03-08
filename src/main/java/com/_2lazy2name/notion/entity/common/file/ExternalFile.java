package com._2lazy2name.notion.entity.common.file;

import com._2lazy2name.notion.entity.enumeration.type.FileTypeEnum;



public class ExternalFile extends AbstractFile {
    private FileTypeEnum type = FileTypeEnum.EXTERNAL;
    private External external;

    private static class External {
        private String url;

        public String getUrl() {
            return url;
        }

        public External setUrl(String url) {
            this.url = url;
            return this;
        }
    }

    private ExternalFile() {
    }

    public ExternalFile(String url) {
        this.external = new External();
        this.external.url = url;
    }

    public ExternalFile(String name, String url) {
        this.name = name;
        this.external = new External();
        this.external.url = url;
    }

    @Override
    public FileTypeEnum getType() {
        return type;
    }

    @Override
    public ExternalFile setType(FileTypeEnum type) {
        this.type = type;
        return this;
    }

    public External getExternal() {
        return external;
    }

    public ExternalFile setExternal(External external) {
        this.external = external;
        return this;
    }
}
