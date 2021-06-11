package com.example.covid19tracker.LatestApi.DAO;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class SummaryData {

    private int total;
    private int confirmedCasesIndian;
    private int confirmedCasesForeign;
    private int discharged;
    private int deaths;
    private int confirmedButLocationUnidentified;

    private ZonedDateTime update;

}
