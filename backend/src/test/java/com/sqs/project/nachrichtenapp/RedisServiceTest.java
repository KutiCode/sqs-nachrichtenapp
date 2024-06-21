package com.sqs.project.nachrichtenapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sqs.project.nachrichtenapp.database.RedisService;
import com.sqs.project.nachrichtenapp.model.NewsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class RedisServiceTest {

    @Mock
    private RedisTemplate<String, String> redisTemplate;

    @Mock
    private ValueOperations<String, String> valueOperations;

    @InjectMocks
    private RedisService redisService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
    }

    @Test
    public void testSaveNewsData() throws JsonProcessingException {
        NewsResponse mockResponse = new NewsResponse();
        mockResponse.setStatus("ok");
        mockResponse.setTotalResults(1);

        String mockResponseJson = objectMapper.writeValueAsString(mockResponse);

        redisService.saveNewsData("testKey", mockResponse);

        verify(valueOperations, times(1)).set("testKey", mockResponseJson);
        verify(redisTemplate, times(1)).expire("testKey", 1, TimeUnit.HOURS);
    }

    @Test
    public void testGetNewsData() throws JsonProcessingException {
        NewsResponse mockResponse = new NewsResponse();
        mockResponse.setStatus("ok");
        mockResponse.setTotalResults(1);

        String mockResponseJson = objectMapper.writeValueAsString(mockResponse);

        when(valueOperations.get("testKey")).thenReturn(mockResponseJson);

        NewsResponse response = redisService.getNewsData("testKey");

        assertNotNull(response);
        assertEquals("ok", response.getStatus());
        assertEquals(1, response.getTotalResults());
    }

    @Test
    public void testGetNewsDataNotFound() throws JsonProcessingException {
        when(valueOperations.get("testKey")).thenReturn(null);

        NewsResponse response = redisService.getNewsData("testKey");

        assertNull(response);
    }
}
