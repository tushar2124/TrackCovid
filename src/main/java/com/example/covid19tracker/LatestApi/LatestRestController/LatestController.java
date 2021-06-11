package com.example.covid19tracker.LatestApi.LatestRestController;

import com.example.covid19tracker.LatestApi.DAO.StateData;
import com.example.covid19tracker.LatestApi.DAO.SummaryData;
import com.example.covid19tracker.LatestApi.Service.LatestCovid19DataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LatestController {

    @Autowired
    LatestCovid19DataProvider latestCovid19DataProvider;

    @GetMapping("/summary")
    public SummaryData GetData() {
        return latestCovid19DataProvider.GetSummaryData();
    }
}
