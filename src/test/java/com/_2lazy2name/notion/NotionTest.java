package com._2lazy2name.notion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.junit.jupiter.api.AfterAll;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;

public class NotionTest {
    public static final ObjectMapper objectMapper;
    protected final static Notion notion ;
    protected static final ArrayList<String> createdBlock = new ArrayList<>();
    protected static final boolean AUTO_DELETE = true;
    protected final static int SLEEP_TIME = 2000;


    static  {
        objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
        Properties properties = new Properties();
        try {
            properties.load(NotionTest.class.getClassLoader().getResourceAsStream("test.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String token = properties.getProperty("token");
        notion = new Notion(token);
    }

    @AfterAll
    public static void deleteAll() throws InterruptedException, IOException {
        Thread.sleep(SLEEP_TIME);
        if (AUTO_DELETE) {
            for (String s : createdBlock) {
                if (s != null) {
                    notion.deleteBlock(s);
                }
            }
        }
        createdBlock.clear();
    }
}
