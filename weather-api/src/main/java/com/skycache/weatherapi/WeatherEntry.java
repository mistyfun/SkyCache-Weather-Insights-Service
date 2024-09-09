package com.skycache.weatherapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherEntry(
        long dt,
        @JsonProperty("main") Main main,
        List<Weather> weather,
        Clouds clouds,
        Wind wind,
        int visibility,
        double pop,
        Sys sys,
        Rain rain,
        String dt_txt
) {}
