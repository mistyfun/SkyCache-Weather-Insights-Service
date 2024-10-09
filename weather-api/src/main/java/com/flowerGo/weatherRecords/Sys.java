package com.flowerGo.weatherRecords;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Sys(
        String pod
) {}
