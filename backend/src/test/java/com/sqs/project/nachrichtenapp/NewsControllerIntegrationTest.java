package com.sqs.project.nachrichtenapp;

import com.sqs.project.nachrichtenapp.Application.NachrichtenappApplication;
import com.sqs.project.nachrichtenapp.model.NewsResponse;
import com.sqs.project.nachrichtenapp.service.NewsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(classes = NachrichtenappApplication.class)
@AutoConfigureMockMvc
public class NewsControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NewsService newsService;

    @Test
    public void testGetTrendNews() throws Exception {
        NewsResponse mockResponse = new NewsResponse();
        mockResponse.setStatus("ok");
        mockResponse.setTotalResults(1);

        Mockito.when(newsService.fetchNews("us", "2024-06-19")).thenReturn(mockResponse);

        mockMvc.perform(get("/news/us/2024-06-19"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("ok"))
                .andExpect(jsonPath("$.totalResults").value(1));
    }

    @Test
    public void testSearchForNews() throws Exception {
        NewsResponse mockResponse = new NewsResponse();
        mockResponse.setStatus("ok");
        mockResponse.setTotalResults(1);

        Mockito.when(newsService.fetchNewsByKeyword("test")).thenReturn(mockResponse);

        mockMvc.perform(get("/news/search/test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("ok"))
                .andExpect(jsonPath("$.totalResults").value(1));
    }
}
