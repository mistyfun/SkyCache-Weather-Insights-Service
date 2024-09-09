package com.skycache.weatherapi;
import java.util.List;
public record WeatherData(
        String cod,
        int message,
        int cnt,
        List<WeatherEntry> list
) {}
