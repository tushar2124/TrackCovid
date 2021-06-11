package com.example.covid19tracker.HistoryApi.HistoryService;

import com.example.covid19tracker.HistoryApi.DAO.Covid19ApiHistory;
import com.example.covid19tracker.HistoryApi.DAO.HistoryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class HistoryCovid19DataProvider {

    @Autowired
    RestTemplate restTemplate;

    String url = "https://api.rootnet.in/covid19-in/stats/history";

    public List<HistoryData> getHistoryData()
    {
        Covid19ApiHistory covid19ApiHistory = restTemplate.getForObject(url,Covid19ApiHistory.class);
        return covid19ApiHistory.getData();
    }
}
