package com.sqs.project.nachrichtenapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sqs.project.nachrichtenapp.model.NewsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class ApiService {

    private final RestTemplate restTemplate;
    @Value("${news.api.key}")
    private String newsApiKey;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public NewsResponse fetchNewsFromApi(String country, String date) throws IOException {
        String url = "https://newsapi.org/v2/top-headlines?country=" + country + "&apiKey="+ newsApiKey;
        String jsnResponse = restTemplate.getForObject(url, String.class);
        return objectMapper.readValue(jsnResponse, NewsResponse.class);
    }

    public NewsResponse fetchNewsByKeyword(String keyword) throws IOException {
        String url = "https://newsapi.org/v2/everything?q=" + keyword + "&apiKey=" + newsApiKey;
        String jsnResponse = restTemplate.getForObject(url, String.class);
        return objectMapper.readValue(jsnResponse, NewsResponse.class);
    }
}