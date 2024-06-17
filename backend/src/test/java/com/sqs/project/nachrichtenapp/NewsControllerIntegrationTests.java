package com.sqs.project.nachrichtenapp;


import com.sqs.project.nachrichtenapp.NewsController;
import com.sqs.project.nachrichtenapp.NewsResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NewsControllerIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetNews() {
        String url = "/api/news";
        ResponseEntity<NewsResponse> response = restTemplate.getForEntity(url, NewsResponse.class);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        // Additional assertions to verify the content of the response body
    }
}
