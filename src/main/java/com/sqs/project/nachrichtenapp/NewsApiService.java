package com.sqs.project.nachrichtenapp;

import org.apache.logging.log4j.util.Strings;
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


    public String fetchNews(String country,String date) {
        String key = country + ":" + date;
        String news = redisTemplate.opsForValue().get(key);
        if (news == null) {
            RestTemplate restTemplate = new RestTemplate();
            String URL = BASE_URL + country + "&pageSize=5&apiKey=" + API_KEY;
            ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
            news = response.getBody();
            saveNews(key, news);
        }
        return news;
    }
    public String fetchSpecificNews(String keyword, String pageSize) {
            RestTemplate restTemplate = new RestTemplate();
            String URL = "https://newsapi.org/v2/everything?q=" + keyword + "&pageSize=" + pageSize + "&apiKey=" + API_KEY;
            ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
        return response.getBody();
    }
    private void saveNews(String key, String newsData) {
        redisTemplate.opsForValue().set(key, newsData);
        redisTemplate.expire(key, 1, TimeUnit.HOURS);
    }

    public void deleteNews(String country, String date) {
        String key = country + ":" + date;
        redisTemplate.delete(key);
    }


}