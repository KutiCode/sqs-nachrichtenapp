package com.sqs.project.nachrichtenapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

@Service
public class NewsApiService {

    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper objectMapper;
    private RestTemplate restTemplate;

    @Value("${news.api.key}")
    private String newsApiKey;

    private static final String BASEURL = "https://newsapi.org/v2/top-headlines?country=";

    public NewsApiService(RedisTemplate<String, String> redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
        this.restTemplate = new RestTemplate(); // Default RestTemplate
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setNewsApiKey(String newsApiKey) {
        this.newsApiKey = newsApiKey;
    }

    public NewsResponse fetchTrendNews(String country, String date) throws IOException {
        String key = country + ":" + date;
        String newsJson = redisTemplate.opsForValue().get(key);
        NewsResponse news;

        if (newsJson != null) {
            try {
                news = objectMapper.readValue(newsJson, NewsResponse.class);
            } catch (JsonProcessingException e) {
                throw new IOException("Error parsing news data", e);
            }
        } else {
            String url = BASEURL + country + "&apiKey=" + newsApiKey;
            news = restTemplate.getForObject(url, NewsResponse.class);
            saveNews(key, news);
        }
        return news;
    }

    public NewsResponse fetchSpecificNews(String keyword) {
        String url = "https://newsapi.org/v2/everything?q=" + keyword + "&apiKey=" + newsApiKey;
        return restTemplate.getForObject(url, NewsResponse.class);
    }

    public void saveNews(String key, NewsResponse newsData) {
        try {
            String newsJson = objectMapper.writeValueAsString(newsData);
            redisTemplate.opsForValue().set(key, newsJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error saving news data", e);
        }
        redisTemplate.expire(key, 1, TimeUnit.HOURS);
    }

    public NewsResponse fetchNewsFromRedis(String key) throws JsonProcessingException {
        String json = redisTemplate.opsForValue().get(key);
        if (json == null) {
            return null;
        }
        return objectMapper.readValue(json, NewsResponse.class);
    }
}
