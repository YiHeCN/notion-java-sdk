package com._2lazy2name.notion.entity.common.file;

import com._2lazy2name.notion.entity.enumeration.type.FileTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExternalFile extends AbstractFile {
    private FileTypeEnum type = FileTypeEnum.EXTERNAL;
    private External external;

    @Getter @Setter
    private static class External {
        private String url;
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
}
