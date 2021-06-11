package com.example.covid19tracker.LatestApi.DAO;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Covid19ApiLatest {

    private boolean success;

    private CountryData data;

    private ZonedDateTime lastRefreshed;

    private ZonedDateTime lastOriginUpdate;
}
