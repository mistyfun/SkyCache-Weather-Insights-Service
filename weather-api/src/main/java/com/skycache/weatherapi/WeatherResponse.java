package com.skycache.weatherapi;

import java.util.List;

public record WeatherResponse(
        Main main,
        List<Weather> weather
) {}