package com.sqs.project.nachrichtenapp;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "http://localhost:80", "http://localhost"})
public class NewsController {

    private final NewsApiService newsApiService;

    public NewsController(NewsApiService newsApiService) {
        this.newsApiService = newsApiService;
    }

    @GetMapping("/news/{country}/{date}")
    public NewsResponse getNews(@PathVariable String country, @PathVariable String date) throws IOException {
        return newsApiService.fetchTrendNews(country, date);
    }

    @GetMapping("/news/search/{keyword}")
    public NewsResponse searchForSpecificNews(@PathVariable String keyword) {
        return newsApiService.fetchSpecificNews(keyword);
    }
}