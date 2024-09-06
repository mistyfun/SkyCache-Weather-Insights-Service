package com.skycache.weatherapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Service
public class WeatherService {
    private static final String API_KEY = "6b6278c371e51d00693d8c2fa91e6c83";
    private static final String API_URL = "https://api.agromonitoring.com/agro/1.0/weather?lat=%s&lon=%s&appid=%s";
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
        String url = String.format(API_URL, lat, lon, API_KEY);
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

    public WeatherData getCurrentWeather(String location) {
        String cacheKey = "weather::" + location;
        WeatherData data = (WeatherData) redisTemplate.opsForValue().get(cacheKey);

        if (data == null) {
            data = fetchWeatherFromAPI(location);
            redisTemplate.opsForValue().set(cacheKey, data, Duration.ofHours(1)); // cache for 1 hour
        }

        return data;
    }

    private WeatherData fetchWeatherFromAPI(String location) {
        // Code to fetch weather from the OpenWeatherMap API
        return null;
    }
}

