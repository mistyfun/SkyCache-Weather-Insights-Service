package com.skycache.weatherapi;

public record Weather(
        int id,
        String main,
        String description,
        String icon
) {}
