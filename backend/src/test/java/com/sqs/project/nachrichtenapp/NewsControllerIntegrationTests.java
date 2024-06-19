package com.sqs.project.nachrichtenapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sqs.project.nachrichtenapp.NewsController;
import com.sqs.project.nachrichtenapp.NewsResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NewsControllerIntegrationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetNews() throws Exception {
        String url = "http://localhost:8080/news/us/2024-06-18";
        NewsResponse mockResponse = new NewsResponse();
        // Set properties of mockResponse as needed

        String mockResponseJson = objectMapper.writeValueAsString(mockResponse);

        MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);
        mockServer.expect(requestTo(url))
                .andRespond(withSuccess(mockResponseJson, MediaType.APPLICATION_JSON));

        ResponseEntity<NewsResponse> response = restTemplate.getForEntity(url, NewsResponse.class);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        // Additional assertions to verify the content of the response body
    }
}