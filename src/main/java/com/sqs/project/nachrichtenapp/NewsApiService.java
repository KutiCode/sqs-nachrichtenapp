package com.sqs.project.nachrichtenapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.TimeUnit;

@Service
public class NewsApiService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    private final String API_KEY = "bd07d53bf22d404bbc22dbefe92997e0";
    private final String BASE_URL = "https://newsapi.org/v2/top-headlines?country=";


    public NewsResponse fetchTrendNews(String country, String date) {
        String key = country + ":" + date;
        String newsJson = redisTemplate.opsForValue().get(key);
        NewsResponse news = null;
        if (newsJson != null) {
            try {
                news = objectMapper.readValue(newsJson, NewsResponse.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } else {
            RestTemplate restTemplate = new RestTemplate();
            String URL = BASE_URL + country + "&apiKey=" + API_KEY;
            news = restTemplate.getForObject(URL, NewsResponse.class);
            saveNews(key, news);
        }
        return news;
    }
    public NewsResponse fetchSpecificNews(String keyword) {
        RestTemplate restTemplate = new RestTemplate();
        String URL = "https://newsapi.org/v2/everything?q=" + keyword + "&apiKey=" + API_KEY;
        NewsResponse response = restTemplate.getForObject(URL, NewsResponse.class);
        return response;
    }
    private void saveNews(String key, NewsResponse newsData) {
        try {
            String newsJson = objectMapper.writeValueAsString(newsData);
            redisTemplate.opsForValue().set(key, newsJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        redisTemplate.expire(key, 1, TimeUnit.HOURS);
    }

}