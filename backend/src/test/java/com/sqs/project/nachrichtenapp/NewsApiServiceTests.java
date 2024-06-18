package com.sqs.project.nachrichtenapp;


import com.sqs.project.nachrichtenapp.Article;
import com.sqs.project.nachrichtenapp.NewsResponse;
import com.sqs.project.nachrichtenapp.NewsApiService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

        NewsResponse newsResponse = newsApiService.fetchTrendNews("us", "2024-06-17");
        assertNotNull(newsResponse);
    }

    @Test
    void testSaveAndRetrieveArticle() {
        String key = "us:2024-06-16";
        NewsResponse mockResponse = new NewsResponse();
        // Initialize article with sample data
        Article article = mockResponse.getArticles().get(0);
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
        when(valueOperations.get(key)).thenReturn(article);

        newsApiService.saveNews(key, mockResponse);
        Article retrievedArticle = redisTemplate.opsForValue().get(key);

        assertNotNull(retrievedArticle);
        assertEquals(article, retrievedArticle);
    }
}

