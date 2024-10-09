package com.flowerGo.weatherRecords;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherList(Main main, List<Weather> weather) {}