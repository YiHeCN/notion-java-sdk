package com._2lazy2name.notion.entity.common.file;

import com._2lazy2name.notion.entity.enumeration.type.FileTypeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter @ToString
@NoArgsConstructor
public class NotionFile extends AbstractFile {
    private final FileTypeEnum type = FileTypeEnum.FILE;
    private File file;

    @ToString @Getter @Setter
    public static class File {
        private String url;
        private Date expiryTime;
    }

    public NotionFile(String name, String url, Date expiryTime) {
        super();
        this.name = name;
        this.file = new File();
        this.file.setUrl(url);
        this.file.setExpiryTime(expiryTime);
    }
}
