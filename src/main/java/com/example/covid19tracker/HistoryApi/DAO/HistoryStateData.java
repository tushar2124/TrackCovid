package com.example.covid19tracker.HistoryApi.DAO;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

@Data
public class HistoryStateData {

    private String loc;
    private int confirmedCasesIndian;
    private int confirmedCasesForeign;
    private int discharged;
    private int deaths;
    private int totalConfirmed;

}
