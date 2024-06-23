package com.sqs.project.nachrichtenapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sqs.project.nachrichtenapp.service.ApiService;
import com.sqs.project.nachrichtenapp.model.NewsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class ApiServiceTest {

    @InjectMocks
    private ApiService apiService;

    @Mock
    private RestTemplate restTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFetchNewsFromApi() throws IOException {
        String mockResponse = "{\"status\":\"ok\",\"totalResults\":1,\"articles\":[{\"title\":\"Test Title\",\"description\":\"Test Description\"}]}";
        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(mockResponse);

        NewsResponse response = apiService.fetchNewsFromApi("us", "2024-06-19");
        assertNotNull(response);
        assertEquals("ok", response.getStatus());
        assertEquals(1, response.getTotalResults());
        assertNotNull(response.getArticles());
        assertEquals(1, response.getArticles().size());
        assertEquals("Test Title", response.getArticles().get(0).getTitle());
        assertEquals("Test Description", response.getArticles().get(0).getDescription());
    }
    @Test
    void testSpecificNewsFromApi() throws IOException {
        String mockResponse = "{\"status\":\"ok\",\"totalResults\":1,\"articles\":[{\"title\":\"Test Title\",\"description\":\"Test Description\"}]}";
        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(mockResponse);

        NewsResponse response = apiService.fetchNewsByKeyword("bitcoin");
        assertNotNull(response);
        assertEquals("ok", response.getStatus());
        assertEquals(1, response.getTotalResults());
        assertNotNull(response.getArticles());
        assertEquals(1, response.getArticles().size());
        assertEquals("Test Title", response.getArticles().get(0).getTitle());
        assertEquals("Test Description", response.getArticles().get(0).getDescription());
    }
}
