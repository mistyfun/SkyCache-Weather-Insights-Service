package com.skycache.weatherapi;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherData(
        String cod,
        int message,
        int cnt,
        List<WeatherEntry> list
) {}
