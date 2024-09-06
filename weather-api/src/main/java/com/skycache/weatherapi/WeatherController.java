package com.skycache.weatherapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/message")
    public String hello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/current")
    public String getWeather(@RequestParam double lat, @RequestParam double lon) {
        return weatherService.getCurrentWeather(lat, lon);
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

