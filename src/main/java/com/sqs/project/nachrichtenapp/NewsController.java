package com.sqs.project.nachrichtenapp;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class NewsController {

    private final NewsApiService newsApiService;

    public NewsController(NewsApiService newsApiService) {
        this.newsApiService = newsApiService;
    }

    @GetMapping("/news/{country}/{date}")
    public NewsResponse getNews(@PathVariable String country, @PathVariable String date) {
        return newsApiService.fetchTrendNews(country, date);
    }

    @GetMapping("/news/search/{keyword}")
    public NewsResponse searchForSpecificNews(@PathVariable String keyword) {
        return newsApiService.fetchSpecificNews(keyword);
    }
}