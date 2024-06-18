package com.sqs.project.nachrichtenapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class NewsApiService {


    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper objectMapper;

    public NewsApiService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = new ObjectMapper();
    }
    @Value("${news.api.key}")
    private String newsApiKey;


    private final String BASE_URL = "https://newsapi.org/v2/top-headlines?country=";


    public NewsResponse fetchTrendNews(String country, String date) throws IOException {
        String key = country + ":" + date;
        String newsJson = redisTemplate.opsForValue().get(key);
        NewsResponse news = null;
        if (newsJson != null) {
            try {
                news = objectMapper.readValue(newsJson, NewsResponse.class);
            } catch (JsonProcessingException e) {
               throw new IOException("Error parsing news data");
            }
        } else {
            RestTemplate restTemplate = new RestTemplate();
            String URL = BASE_URL + country + "&apiKey=" + newsApiKey;
            news = restTemplate.getForObject(URL, NewsResponse.class);
            saveNews(key, news);
        }
        return news;
    }
    public NewsResponse fetchSpecificNews(String keyword) {
        RestTemplate restTemplate = new RestTemplate();
        String URL = "https://newsapi.org/v2/everything?q=" + keyword + "&apiKey=" + newsApiKey;
        NewsResponse response = restTemplate.getForObject(URL, NewsResponse.class);
        return response;
    }
    void saveNews(String key, NewsResponse newsData) throws RedisConnectionFailureException {
        try {
            String newsJson = objectMapper.writeValueAsString(newsData);
            redisTemplate.opsForValue().set(key, newsJson);
        } catch (JsonProcessingException e) {
            throw new RedisConnectionFailureException("Error saving news data");
        }
        redisTemplate.expire(key, 1, TimeUnit.HOURS);
    }

}