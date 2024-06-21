package com.sqs.project.nachrichtenapp;

import com.sqs.project.nachrichtenapp.api.ApiService;
import com.sqs.project.nachrichtenapp.database.RedisService;
import com.sqs.project.nachrichtenapp.model.NewsResponse;
import com.sqs.project.nachrichtenapp.service.NewsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class NewsServiceTest {

    @Mock
    private ApiService apiService;

    @Mock
    private RedisService redisService;

    @InjectMocks
    private NewsService newsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFetchNews() throws IOException {
        NewsResponse mockResponse = new NewsResponse();
        mockResponse.setStatus("ok");
        mockResponse.setTotalResults(1);

        when(redisService.getNewsData(anyString())).thenReturn(null);
        when(apiService.fetchNewsFromApi(anyString(), anyString())).thenReturn(mockResponse);

        NewsResponse response = newsService.fetchNews("us", "2024-06-19");

        assertNotNull(response);
        assertEquals("ok", response.getStatus());
        assertEquals(1, response.getTotalResults());
        verify(redisService, times(1)).getNewsData("us:2024-06-19");
        verify(apiService, times(1)).fetchNewsFromApi("us", "2024-06-19");
        verify(redisService, times(1)).saveNewsData("us:2024-06-19", mockResponse);
    }

    @Test
    public void testFetchNewsByKeyword() throws IOException {
        NewsResponse mockResponse = new NewsResponse();
        mockResponse.setStatus("ok");
        mockResponse.setTotalResults(1);

        when(apiService.fetchNewsByKeyword(anyString())).thenReturn(mockResponse);

        NewsResponse response = newsService.fetchNewsByKeyword("test");

        assertNotNull(response);
        assertEquals("ok", response.getStatus());
        assertEquals(1, response.getTotalResults());
        verify(apiService, times(1)).fetchNewsByKeyword("test");
    }
}
