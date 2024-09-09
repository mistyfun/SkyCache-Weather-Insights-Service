package com.skycache.weatherapi;

import com.sun.tools.javac.Main;

import java.util.List;

public record WeatherEntry(
        long dt,
        Main main,
        List<Weather> weather,
        Clouds clouds,
        Wind wind,
        int visibility,
        double pop,
        Sys sys,
        Rain rain,
        String dt_txt
) {}
