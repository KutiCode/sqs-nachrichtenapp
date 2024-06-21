package com.sqs.project.nachrichtenapp.service;

import com.sqs.project.nachrichtenapp.api.ApiService;
import com.sqs.project.nachrichtenapp.database.RedisService;
import com.sqs.project.nachrichtenapp.model.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class NewsService {

    private final ApiService apiService;
    private final RedisService redisService;

    @Autowired
    public NewsService(ApiService apiService, RedisService redisService) {
        this.apiService = apiService;
        this.redisService = redisService;
    }

    public NewsResponse fetchNews(String country, String date) throws IOException {
        String key = country + ":" + date;
        NewsResponse news = redisService.getNewsData(key);
        if (news == null) {
            news = apiService.fetchNewsFromApi(country, date);

            redisService.saveNewsData(key, news);
        }

        return news;
    }

    public NewsResponse fetchNewsByKeyword(String keyword) throws IOException {
        return apiService.fetchNewsByKeyword(keyword);
    }
}
