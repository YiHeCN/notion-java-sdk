# Notion Java SDK

![https://img.shields.io/badge/license-MIT-blue](https://img.shields.io/badge/license-MIT-blue)
![https://img.shields.io/github/commit-activity/m/YiHeCN/notion-java-sdk](https://img.shields.io/github/commit-activity/m/YiHeCN/notion-java-sdk)
![https://img.shields.io/badge/Maven-0.0.1--SNAPSHOT-lightgrey](https://img.shields.io/badge/Maven-0.0.1--SNAPSHOT-lightgrey)
![https://img.shields.io/github/forks/YiHeCN/notion-java-sdk?style=social](https://img.shields.io/github/forks/YiHeCN/notion-java-sdk?style=social)
![https://img.shields.io/github/stars/YiHeCN/notion-java-sdk?style=social](https://img.shields.io/github/stars/YiHeCN/notion-java-sdk?style=social)

Notion-java-sdk is a java version of [Notion API](https://developers.notion.com/).

It provides:
1. Basic packaging of Notion objects (`com._2lazy2name.notion.entity`)
2. Basic API request (`com._2lazy2name.notion.Notion`)

## Things to Aware

Basic entities and API requests are checked, but not guaranteed safe to use.

The API is based on the API Version of ***2022-06-28***, which is the latest version on Feb 19, 2023. Future updates are **NOT** guaranteed, which also means Notion Version in headers is not configurable before a new release.

## Compatibility

The project is written on the source level of **Java 17**. Since enhanced switch blocks are used somewhere, the minimum version accepted is **Java 14**. All you need to change to make it compatible with Java 8 is two switch blocks in `FilterSerializer`.

# How to use it?

1. Add dependency in `pom.xml`

```xml
<dependency>
  <groupId>com.2lazy2name</groupId>
  <artifactId>notion-java-sdk</artifactId>
  <version>v0.1.0-SNAPSHOT</version>
</dependency>
```

1. Instantiated `Notion.class`
    1. If you are using Spring-Framework:

        ```java
        @Bean
        Notion notion() {
            Notion notion = new Notion(NOTION_TOKEN);
            return notion;
        }
        ```

    2. If you are using vanilla Java, Simply use the constructor:

        ```java
        Notion notion = new Notion(NOTION_TOKEN);
        ```

2. All the official endpoints are provided in `Notion.class` as methods. There are properly annotated and linked to official notion documents.
3. If you believe there is an error with this project:
    1. For `IOException`: use `notion.setDebugEnabled(true)` , and attach Http request details in the issue.
    2. For `JsonParsingException` : provide the fields value of the object type that you are dealing with in the issue.

# Lib used

[Jackson](https://github.com/FasterXML/jackson) and [Apache Http Client5](https://github.com/apache/httpcomponents-client).

# Future Plan
1. Make it compatible to Java 8.
2. Add more tests. (Well, maybe when I encounter some bugs.)
3. Update to the latest version of Notion API.

# Issue and Contact

I don’t check GitHub very often. For any issues or commit, there are some ways to quicker notices and solutions:

1.  E-mail **yi@2lazy2name.com**
2. [Notion Page](https://www.notion.so/Notion-java-sdk-bc362b42ae3f40179962425be015962f) - Check the test cases for usage.
3.  [Telegram Group](https://t.me/+35eZF98AgogxMjJl)

Suggestions in code styles and implementation with optimization advice are highly welcomed.

# Disclaimer

This Repository is **NOT** provided by Notion and **NOT** endorsed by Notion. There are also some potential bugs and performance issues. **THINK whether you are OK for the risk before you really use it.**