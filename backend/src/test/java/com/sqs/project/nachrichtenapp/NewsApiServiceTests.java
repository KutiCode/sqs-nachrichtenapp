package com.sqs.project.nachrichtenapp;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class NewsApiServiceTests {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private RedisTemplate<String, Article> redisTemplate;

    @Mock
    private ValueOperations<String, Article> valueOperations;

    @InjectMocks
    private NewsApiService newsApiService;

    @Test
    void testGetNews() throws IOException {
        String url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=YOUR_API_KEY";
        NewsResponse mockResponse = new NewsResponse();
        // Initialize mockResponse with sample data

        when(restTemplate.getForObject(url, NewsResponse.class)).thenReturn(mockResponse);

        // Set up the mock behavior for RedisTemplate and ValueOperations
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
        when(valueOperations.get(anyString())).thenReturn(new Article());

        NewsResponse newsResponse = newsApiService.fetchTrendNews("us", "2024-06-17");
        assertNotNull(newsResponse);
    }

    @Test
    void testSaveAndRetrieveArticle() {
        String key = "us:2024-06-16";
        NewsResponse mockResponse = new NewsResponse();
        // Initialize articles list with sample data
        List<Article> articles = new ArrayList<>();
        articles.add(new Article());
        mockResponse.setArticles(articles);

        Article article = mockResponse.getArticles().get(0);
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
        when(valueOperations.get(key)).thenReturn(article);

        newsApiService.saveNews(key, mockResponse);
        Article retrievedArticle = redisTemplate.opsForValue().get(key);

        assertNotNull(retrievedArticle);
        assertEquals(article, retrievedArticle);
    }
}