package com.sqs.project.nachrichtenapp;
import com.sqs.project.nachrichtenapp.Article;
import com.sqs.project.nachrichtenapp.Source;
import java.util.List;

public class NewsResponse {
    private String status;
    private int totalResults;
    private List<Article> articles;

    public int getTotalResults() {
        return totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public String getStatus() {
        return status;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

}

