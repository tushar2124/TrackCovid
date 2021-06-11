package com.example.covid19tracker.HistoryApi.DAO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class HistoryData {

    private LocalDate day;

    private HistorySummaryData summary;

    private List<HistoryStateData> regional;
}
