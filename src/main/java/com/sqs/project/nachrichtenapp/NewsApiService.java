package com.sqs.project.nachrichtenapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsApiService {


    @Value("${newsapi.key}")
    private static String API_KEY;

    private static final String URL = "https://newsapi.org/v2/top-headlines?country=us&apiKey=" + API_KEY ;

    public String fetchNews() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
        return response.getBody();
    }
}