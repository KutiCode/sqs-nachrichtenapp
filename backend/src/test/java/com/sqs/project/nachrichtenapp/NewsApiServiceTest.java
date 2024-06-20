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
        newsApiService = new NewsApiService(redisTemplate);
        newsApiService.setRestTemplate(restTemplate);
        newsApiService.setNewsApiKey("bd07d53bf22d404bbc22dbefe92997e0");
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
    }


    @Test
    public void testFetchTrendNews_NotCached() throws IOException {
        String key = "us:2023-06-20";
        String url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=bd07d53bf22d404bbc22dbefe92997e0";
        NewsResponse newsResponse = new NewsResponse();

        when(valueOperations.get(key)).thenReturn(null);
        when(restTemplate.getForObject(url, NewsResponse.class)).thenReturn(newsResponse);

        NewsResponse news = newsApiService.fetchTrendNews("us", "2023-06-20");
        assertNotNull(news);
    }

    @Test
    public void testFetchSpecificNews() {
        String keyword = "bitcoin";
        String url = "https://newsapi.org/v2/everything?q=bitcoin&apiKey=bd07d53bf22d404bbc22dbefe92997e0";
        NewsResponse newsResponse = new NewsResponse();

        when(restTemplate.getForObject(url, NewsResponse.class)).thenReturn(newsResponse);

        NewsResponse news = newsApiService.fetchSpecificNews(keyword);
        assertNotNull(news);
    }

}