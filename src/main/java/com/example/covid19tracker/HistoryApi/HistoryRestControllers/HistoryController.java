package com.example.covid19tracker.HistoryApi.HistoryRestControllers;

import com.example.covid19tracker.HistoryApi.HistoryService.HistoryCovidAlert;
import com.example.covid19tracker.HistoryApi.DAO.HistoryStateData;
import com.example.covid19tracker.LatestApi.Service.CovidAlert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoryController {

    @Autowired
    HistoryCovidAlert historyCovidAlert;

    @Autowired
    CovidAlert covidAlert;

    @GetMapping("/history/{State}")
            public List<HistoryStateData> getData(@PathVariable String State)
    {
      return historyCovidAlert.getHistoryStateData(covidAlert.GetSummaryData().getUpdate(),State);
    }

    @GetMapping("/dikhao")
    public List<HistoryStateData> dikha()
    {
        return historyCovidAlert.getAllHistoryStateData(covidAlert.GetSummaryData().getUpdate());
    }

}
