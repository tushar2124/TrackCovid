package com.example.covid19tracker.LatestApi.DAO;

import lombok.Data;

@Data
public class CountryData {

    private SummaryData summary;

    private StateData[] regional;
}
