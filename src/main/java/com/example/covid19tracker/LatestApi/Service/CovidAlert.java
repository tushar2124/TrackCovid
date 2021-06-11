package com.example.covid19tracker.LatestApi.Service;

import com.example.covid19tracker.LatestApi.DAO.StateData;
import com.example.covid19tracker.LatestApi.DAO.SummaryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CovidAlert {

    @Autowired
    LatestCovid19DataProvider latestCovid19DataProvider;

    public SummaryData GetSummaryData() {
        return latestCovid19DataProvider.GetSummaryData();
    }

    public StateData GetStateData(String state) {
        return latestCovid19DataProvider.GetStateData(state);
    }
}
