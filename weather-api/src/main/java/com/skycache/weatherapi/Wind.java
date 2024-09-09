package com.skycache.weatherapi;

public record Wind(
        double speed,
        int deg,
        double gust
) {}
