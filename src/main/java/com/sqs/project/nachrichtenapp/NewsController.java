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
    public String getNews(@PathVariable String country, @PathVariable String date) {
        return newsApiService.fetchNews(country, date);
    }

    @GetMapping("/news/delete/{country}/{date}")
    public void deleteNews(@PathVariable String country, @PathVariable String date) {
        newsApiService.deleteNews(country, date);
    }

    @GetMapping("/news/search/{keyword}/{pageSize}")
    public String searchForSpecificNews(@PathVariable String keyword, @PathVariable String pageSize) {
        return newsApiService.fetchSpecificNews(keyword, pageSize);
    }
}