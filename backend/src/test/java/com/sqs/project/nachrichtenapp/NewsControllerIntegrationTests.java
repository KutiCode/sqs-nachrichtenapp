package com.sqs.project.nachrichtenapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.mockito.Mockito.lenient;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NewsControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;


    @Mock
    private NewsApiService newsApiService;


    @BeforeEach
    public void setUp() throws IOException {
        NewsResponse trendNewsResponse = new NewsResponse();
        NewsResponse specificNewsResponse = new NewsResponse();
        // Mocking the service methods leniently
        lenient().when(newsApiService.fetchTrendNews("us", "2024-06-18")).thenReturn(trendNewsResponse);
        lenient().when(newsApiService.fetchSpecificNews("keyword")).thenReturn(specificNewsResponse);
    }

    @Test
    public void testGetNews() throws Exception {
        mockMvc.perform(get("/news/us/2024-06-18")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").exists())
                .andExpect(jsonPath("$.totalResults").exists())
                .andExpect(jsonPath("$.articles[0].author").exists())
                .andExpect(jsonPath("$.articles[0].title").exists())
                .andExpect(jsonPath("$.articles[0].description").doesNotExist())
                .andExpect(jsonPath("$.articles[0].url").exists())
                .andExpect(jsonPath("$.articles[0].urlToImage").doesNotExist())
                .andExpect(jsonPath("$.articles[0].publishedAt").exists())
                .andExpect(jsonPath("$.articles[0].content").doesNotExist());
    }

    @Test
    void testSearchForSpecificNews() throws Exception {
        mockMvc.perform(get("/news/search/keyword")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("ok"))
                .andExpect(jsonPath("$.totalResults").exists())
                .andExpect(jsonPath("$.articles").isArray())
                .andExpect(jsonPath("$.articles[0].author").exists())
                .andExpect(jsonPath("$.articles[0].title").exists())
                .andExpect(jsonPath("$.articles[0].description").exists())
                .andExpect(jsonPath("$.articles[0].url").exists())
                .andExpect(jsonPath("$.articles[0].urlToImage").exists())
                .andExpect(jsonPath("$.articles[0].publishedAt").exists())
                .andExpect(jsonPath("$.articles[0].content").exists());
    }
}
