package com.example.covid19tracker.HistoryApi.DAO;

import lombok.Data;

@Data
public class HistorySummaryData {

    private int total;
    private int confirmedCasesIndian;
    private int confirmedCasesForeign;
    private int discharged;
    private int deaths;
    private int confirmedButLocationUnidentified;
}
