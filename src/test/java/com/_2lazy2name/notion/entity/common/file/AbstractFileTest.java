package com._2lazy2name.notion.entity.common.file;

import com._2lazy2name.notion.NotionTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AbstractFileTest extends NotionTest {

    private final String externalFileJson = """
            {
              "type": "external",
              "external": {
                "url": "https://images.unsplash.com/photo-1525310072745-f49212b5ac6d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1065&q=80"
              }
            }
            """;
    private final String externalFileUrl = "https://images.unsplash.com/photo-1525310072745-f49212b5ac6d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1065&q=80";

    private final String notionHostedFileJson = """
            {
              "type": "file",
              "file": {
                "url": "https://s3.us-west-2.amazonaws.com/secure.notion-static.com/7b8b0713-dbd4-4962-b38b-955b6c49a573/My_test_image.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221024%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221024T205211Z&X-Amz-Expires=3600&X-Amz-Signature=208aa971577ff05e75e68354e8a9488697288ff3fb3879c2d599433a7625bf90&X-Amz-SignedHeaders=host&x-id=GetObject",
                "expiry_time": "2022-10-24T22:49:22.765Z"
              }
            }
            """;

    private final String notionHostedFileUrl = "https://s3.us-west-2.amazonaws.com/secure.notion-static.com/7b8b0713-dbd4-4962-b38b-955b6c49a573/My_test_image.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221024%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221024T205211Z&X-Amz-Expires=3600&X-Amz-Signature=208aa971577ff05e75e68354e8a9488697288ff3fb3879c2d599433a7625bf90&X-Amz-SignedHeaders=host&x-id=GetObject";
    private final String notionHostedFileExpiryTime = "2022-10-24T22:49:22.765Z";

    @Test
    public void testExternalFile() throws JsonProcessingException {
        AbstractFile file = new ExternalFile(externalFileUrl);
        Assertions.assertTrue(isEquals(objectMapper.writeValueAsString(file), externalFileJson));
    }

    @Test
    public void testNotionHostedFile() throws JsonProcessingException {
        NotionHostedFile file =  objectMapper.readValue(notionHostedFileJson, NotionHostedFile.class);
        Assertions.assertEquals(notionHostedFileUrl, file.getUrl());
        Assertions.assertEquals(formatDate(notionHostedFileExpiryTime), file.getExpiryTime());
    }



}