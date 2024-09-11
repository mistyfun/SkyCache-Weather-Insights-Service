package com.skycache.weatherapi.weatherRecords;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Rain(
        double _3h
) {}
