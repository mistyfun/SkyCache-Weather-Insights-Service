package com.flowerGo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${openweather.api.key}")
    private String apiKey;
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public WeatherService() {
        this.redisTemplate = new RedisTemplate<>();
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    public String getCurrentWeather(double lat, double lon) {
        String API_URL = "https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s";
        String url = String.format(API_URL, lat, lon, apiKey);
        try {
            // Send HTTP GET request
            String jsonResponse = restTemplate.getForObject(url, String.class);

            // Parse JSON response
            JsonNode root = objectMapper.readTree(jsonResponse);
            JsonNode main = root.path("main");
            JsonNode weather = root.path("weather").get(0);

            // Extract specific weather data
            String description = weather.path("description").asText();
            double temperature = main.path("temp").asDouble();

            return String.format("Weather: %s, Temperature: %.2f°C", description, temperature - 273.15); // Convert from Kelvin to Celsius
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching weather data";
        }
    }
}

