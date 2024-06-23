package com.sqs.project.nachrichtenapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.sqs.project.nachrichtenapp.model.Article;
import com.sqs.project.nachrichtenapp.model.Source;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArticleTest {

    private Article article;

    @BeforeEach
    void setUp() {
        article = new Article();
    }

    @Test
    void testGetAndSetSource() {
        Source source = new Source();  // Angenommen, Source ist eine einfache Klasse mit mindestens einer Eigenschaft
        source.setName("Example Source");
        article.setSource(source);
        assertEquals(source, article.getSource());
    }

    @Test
    void testGetAndSetAuthor() {
        String author = "John Doe";
        article.setAuthor(author);
        assertEquals(author, article.getAuthor());
    }

    @Test
    void testGetAndSetContent() {
        String content = "This is some test content.";
        article.setContent(content);
        assertEquals(content, article.getContent());
    }

    @Test
    void testGetAndSetDescription() {
        String description = "This is a description.";
        article.setDescription(description);
        assertEquals(description, article.getDescription());
    }

    @Test
    void testGetAndSetPublishedAt() {
        String publishedAt = "2024-06-23";
        article.setPublishedAt(publishedAt);
        assertEquals(publishedAt, article.getPublishedAt());
    }

    @Test
    void testGetAndSetTitle() {
        String title = "Test Title";
        article.setTitle(title);
        assertEquals(title, article.getTitle());
    }

    @Test
    void testGetAndSetUrl() {
        String url = "http://example.com";
        article.setUrl(url);
        assertEquals(url, article.getUrl());
    }

    @Test
    void testGetAndSetUrlToImage() {
        String urlToImage = "http://example.com/image.jpg";
        article.setUrlToImage(urlToImage);
        assertEquals(urlToImage, article.getUrlToImage());
    }

    @Test
    void testNullAuthor() {
        article.setAuthor(null);
        assertNull(article.getAuthor());
    }
}
