package com.sqs.project.nachrichtenapp;

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

    private final String API_KEY = "bd07d53bf22d404bbc22dbefe92997e0";
    private final String BASE_URL = "https://newsapi.org/v2/top-headlines?country=";


    public String fetchNews(String country, String pageSize) {
        String newsData = redisTemplate.opsForValue().get("newsData");
        if (newsData == null) {
            RestTemplate restTemplate = new RestTemplate();
            String URL = BASE_URL + country + "&pageSize=" + pageSize + "&apiKey=" + API_KEY;
            ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
            newsData = response.getBody();
            saveNewsData(newsData);
        }
        return newsData;
    }

    private void saveNewsData(String newsData) {
        redisTemplate.opsForValue().set("newsData", newsData);
        redisTemplate.expire("newsData", 1, TimeUnit.HOURS);
    }
}