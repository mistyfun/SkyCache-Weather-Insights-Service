package com.skycache.weatherapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class WeatherService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

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

