package com.flowerGo.weatherRecords;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Main(double temp, double feels_like, double humidity) {}
