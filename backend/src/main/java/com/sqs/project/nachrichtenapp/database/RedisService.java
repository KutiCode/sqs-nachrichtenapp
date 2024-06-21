package com.sqs.project.nachrichtenapp.database;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sqs.project.nachrichtenapp.model.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService{

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public RedisService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveNewsData(String key, NewsResponse newsData) {
        try {
            String newsJson = objectMapper.writeValueAsString(newsData);
            redisTemplate.opsForValue().set(key, newsJson);
            redisTemplate.expire(key, 1, TimeUnit.HOURS);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error saving news data", e);

        }
    }

    public NewsResponse getNewsData(String key) throws JsonProcessingException {
        String newsJson = redisTemplate.opsForValue().get(key);
        if (newsJson != null) {
            return objectMapper.readValue(newsJson, NewsResponse.class);
        }else {
            return null;
        }
    }

}
