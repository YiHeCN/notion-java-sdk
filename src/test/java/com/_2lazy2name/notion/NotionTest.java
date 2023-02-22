package com._2lazy2name.notion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class NotionTest {
    public static final ObjectMapper objectMapper;
    protected final static Notion notion ;


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
}
