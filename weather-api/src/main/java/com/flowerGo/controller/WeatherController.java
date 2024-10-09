package com.flowerGo.controller;

import com.flowerGo.service.WeatherService;
import org.springframework.web.bind.annotation.*;

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
}

