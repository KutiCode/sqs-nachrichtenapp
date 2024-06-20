package com.sqs.project.nachrichtenapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class NewsApiServiceTests {

    @Mock
    private RedisTemplate<String, String> redisTemplate;

    @Mock
    private ValueOperations<String, String> valueOperations;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private NewsApiService newsApiService;

    @Value("${news.api.key}")
    private String newsApiKey = "test-api-key";

    private static final String BASEURL = "https://newsapi.org/v2/top-headlines?country=";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
        newsApiService.setRestTemplate(restTemplate); // Ensure the service uses the mocked RestTemplate
        newsApiService.setNewsApiKey(newsApiKey); // Ensure the service uses the test API key
    }

    @Test
    public void testFetchTrendNewsFromAPI() throws IOException {
        String country = "de";
        String date = LocalDate.now().toString();
        String key = country + "_" + date;
        String apiResponse = "{\"status\":\"ok\",\"articles\":[{\"title\":\"Test Article\"}]}";

        when(valueOperations.get(key)).thenReturn(null);
        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(apiResponse);

        NewsResponse newsResponse = newsApiService.fetchTrendNews(country, date);

        assertNotNull(newsResponse);
        assertEquals("ok", newsResponse.getStatus());
        assertEquals(1, newsResponse.getArticles().size());
        assertEquals("Test Article", newsResponse.getArticles().get(0).getTitle());

        verify(valueOperations, times(1)).set(key, apiResponse);
    }

    @Test
    public void testSaveNews() throws JsonProcessingException {
        String key = "test_key";
        NewsResponse newsResponse = new NewsResponse();
        newsResponse.setStatus("ok");

        String jsonString = "{\"status\":\"ok\",\"totalResults\":0,\"articles\":null}";
        when(objectMapper.writeValueAsString(newsResponse)).thenReturn(jsonString);

        newsApiService.saveNews(key, newsResponse);

        verify(valueOperations, times(1)).set(key, jsonString);
        verify(redisTemplate, times(1)).expire(key, 1, TimeUnit.HOURS);
    }

    @Test
    public void testFetchNewsFromRedis() throws JsonProcessingException {
        String key = "test_key";
        String json = "{\"status\":\"ok\",\"articles\":[{\"title\":\"Test Article\"}]}";
        NewsResponse expectedResponse = new NewsResponse();
        expectedResponse.setStatus("ok");
        expectedResponse.setArticles(new ArrayList<>());

        when(valueOperations.get(key)).thenReturn(json);
        when(objectMapper.readValue(json, NewsResponse.class)).thenReturn(expectedResponse);

        NewsResponse newsResponse = newsApiService.fetchNewsFromRedis(key);

        assertNotNull(newsResponse);
        assertEquals("ok", newsResponse.getStatus());
    }

    @Test
    public void testFetchSpecificNews() {
        String keyword = "test";
        String apiResponse = "{\"status\":\"ok\",\"articles\":[{\"title\":\"Test Article\"}]}";

        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(apiResponse);

        NewsResponse newsResponse = newsApiService.fetchSpecificNews(keyword);

        assertNotNull(newsResponse);
        assertEquals("ok", newsResponse.getStatus());
        assertEquals(1, newsResponse.getArticles().size());
        assertEquals("Test Article", newsResponse.getArticles().get(0).getTitle());
    }

    @Test
    public void testErrorHandlingInFetchTrendNews() throws IOException {
        String country = "de";
        String date = LocalDate.now().toString();
        String key = country + "_" + date;

        when(valueOperations.get(key)).thenReturn(null);
        when(restTemplate.getForObject(anyString(), eq(String.class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.UNAUTHORIZED));

        assertThrows(HttpClientErrorException.Unauthorized.class, () -> newsApiService.fetchTrendNews(country, date));
    }
}
