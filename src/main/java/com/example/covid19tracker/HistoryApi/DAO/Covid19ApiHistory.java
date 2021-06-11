package com.example.covid19tracker.HistoryApi.DAO;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class Covid19ApiHistory {

    private boolean success;

    private List<HistoryData> data;

    private ZonedDateTime lastRefreshed;

    private ZonedDateTime lastOriginUpdate;
}
