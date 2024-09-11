package com.skycache.weatherapi.weatherRecords;

public record Wind(
        double speed,
        int deg,
        double gust
) {}
