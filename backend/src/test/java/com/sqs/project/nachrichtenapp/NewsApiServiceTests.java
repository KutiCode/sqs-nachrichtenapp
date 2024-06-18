package com.sqs.project.nachrichtenapp;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
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
    void testApiConnection() {
        String url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=bd07d53bf22d404bbc22dbefe92997e0";

        // Stellen Sie sicher, dass restTemplate.getForObject eine nicht-null Antwort zurückgibt
        when(restTemplate.getForObject(url, NewsResponse.class)).thenReturn(new NewsResponse());

        NewsResponse response = restTemplate.getForObject(url, NewsResponse.class);

        assertNotNull(response, "Die Verbindung zur API war nicht erfolgreich");
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

    @Test
    void testRedisTimeout() throws InterruptedException {
        // Definieren Sie den Schlüssel und den erwarteten Wert
        String key = "testKey";
        NewsResponse expectedResponse = new NewsResponse();
        expectedResponse.setStatus("Test Value");

        // Set up the behavior for redisTemplate.opsForValue()
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);

        // Rufen Sie die Methode saveNews auf
        newsApiService.saveNews(key, expectedResponse);

        // Warten Sie länger als das Ablaufdatum
        Thread.sleep(TimeUnit.SECONDS.toMillis(10));

        // Rufen Sie die Methode get auf und überprüfen Sie, ob der Wert null ist
        Article actualValue = redisTemplate.opsForValue().get(key);
        assertNull(actualValue, "Der Wert sollte nach dem Ablaufdatum null sein");
    }
}