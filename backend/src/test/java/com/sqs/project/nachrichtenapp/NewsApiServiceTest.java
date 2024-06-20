package com.sqs.project.nachrichtenapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NewsApiServiceTest {

    @Mock
    private RedisTemplate<String, String> redisTemplate;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ValueOperations<String, String> valueOperations;

    @InjectMocks
    private NewsApiService newsApiService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Mock RedisTemplate and its operations
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);

        // Ensure RedisTemplate mock is properly configured
        doNothing().when(redisTemplate).setKeySerializer(any(StringRedisSerializer.class));
        doNothing().when(redisTemplate).setValueSerializer(any(StringRedisSerializer.class));
        doNothing().when(redisTemplate).setConnectionFactory(any(JedisConnectionFactory.class));
    }

    @Test
    public void testFetchTrendNews_NotCached() throws IOException {
        String country = "us";
        String date = "2023-06-20";
        String key = country + ":" + date;
        String url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=bd07d53bf22d404bbc22dbefe92997e0";
        NewsResponse newsResponse = new NewsResponse();

        when(valueOperations.get(key)).thenReturn(null);
        when(restTemplate.getForObject(url, NewsResponse.class)).thenReturn(newsResponse);

        NewsResponse news = newsApiService.fetchTrendNews(country, date);

        assertNotNull(news);
        verify(valueOperations, times(1)).get(key);
        verify(restTemplate, times(1)).getForObject(url, NewsResponse.class);
        verify(valueOperations, times(1)).set(eq(key), anyString());
        verify(redisTemplate, times(1)).expire(key, 1, TimeUnit.HOURS);
    }

    @Test
    public void testFetchSpecificNews() {
        String keyword = "technology";
        String url = "https://newsapi.org/v2/everything?q=technology&apiKey=bd07d53bf22d404bbc22dbefe92997e0";
        NewsResponse newsResponse = new NewsResponse();

        System.out.println("Setting up mock for RestTemplate");
        when(restTemplate.getForObject(url, NewsResponse.class)).thenReturn(newsResponse);

        System.out.println("Calling fetchSpecificNews");
        NewsResponse news = newsApiService.fetchSpecificNews(keyword);

        System.out.println("Asserting the news response is not null");
        assertNotNull("The news response should not be null", news);
        verify(restTemplate, times(1)).getForObject(url, NewsResponse.class);
    }

    @Test
    public void testSaveNews() throws JsonProcessingException {
        String key = "us:2023-06-20";
        NewsResponse newsResponse = new NewsResponse();
        String newsJson = "{\"status\":\"ok\",\"totalResults\":10,\"articles\":[]}";

        System.out.println("Setting up mock for ObjectMapper");
        when(objectMapper.writeValueAsString(newsResponse)).thenReturn(newsJson);

        System.out.println("Calling saveNews");
        newsApiService.saveNews(key, newsResponse);

        System.out.println("Verifying interactions with valueOperations and redisTemplate");
        verify(valueOperations, times(1)).set(eq(key), eq(newsJson));
        verify(redisTemplate, times(1)).expire(key, 1, TimeUnit.HOURS);
    }
}
