# README.md

# CAUTION

Until 2023-02-22, this Lib is still under testing.

# Introduction

Notion-java-sdk is a java version of [Notion API](https://developers.notion.com/).

It provides:

1. Basic packaging of Notion objects (`com._2lazy2name.notion.entity`)
2. Basic API request (`com._2lazy2name.notion.Notion`)

## Things to Aware

Basic entities and API requests are checked, but not guaranteed safe to use.

The API is based on the API Version of ***2022-06-28***, which is the latest version on Feb 19, 2023. Future updates are **NOT** guaranteed, which also means Notion Version in headers is not configurable before a new release.

## Compatibility

The project is written on the source level of **Java 17**. Since enhanced switch blocks are used somewhere, the minimum version accepted is **Java 14**. All you need to change to make it compatible with Java 8 is two switch blocks in `FilterSerializer`.

# Lib used

Jackson, Lombok, and Apache Http Client5.

# Issue and Contact

I don't check GitHub very often. For any issues or commit, there are some ways to quicker notices and solutions:

1. E-mail **yi@2lazy2name.com**
2. [Notion Page](https://www.notion.so/Notion-java-sdk-acbfd949a35646079264d0bb71a77f14) - Check the test cases for usage.
3. [Telegram Group](https://t.me/+35eZF98AgogxMjJl)

Suggestions in code styles and implementation with optimization advice are highly welcomed.

# Disclaimer

This Repository is **NOT** provided by Notion and **NOT** endorsed by Notion. There are also some potential bugs and performance issues. **THINK whether you are OK for the risk before you really use it.**