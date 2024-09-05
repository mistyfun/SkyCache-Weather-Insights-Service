package com.skycache.weatherapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @GetMapping("/message")
    public String hello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/current")
    public ResponseEntity<WeatherData> getCurrentWeather() {
        // logic to get current weather
        return null;
    }

    @GetMapping("/forecast")
    public ResponseEntity<List<ForecastData>> getWeatherForecast() {
        // logic to get weather forecast
        return null;
    }

    @GetMapping("/historical")
    public ResponseEntity<HistoricalData> getHistoricalWeather() {
        // logic to get historical weather data
        return null;
    }
}

