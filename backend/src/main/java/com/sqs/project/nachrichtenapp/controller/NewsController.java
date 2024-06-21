package com.sqs.project.nachrichtenapp.controller;

import com.sqs.project.nachrichtenapp.model.NewsResponse;
import com.sqs.project.nachrichtenapp.service.NewsService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:*")
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/{country}/{date}")
    public NewsResponse getTrendNews(@PathVariable String country, @PathVariable String date) throws IOException {
        return newsService.fetchNews(country, date);
    }

    @GetMapping("/search/{keyword}")
    public NewsResponse searchForNews(@PathVariable String keyword) throws IOException {
        return newsService.fetchNewsByKeyword(keyword);
    }
}
