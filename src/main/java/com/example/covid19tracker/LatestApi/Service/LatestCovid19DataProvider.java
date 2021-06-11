package com.example.covid19tracker.LatestApi.Service;

import com.example.covid19tracker.LatestApi.DAO.Covid19ApiLatest;
import com.example.covid19tracker.LatestApi.DAO.StateData;
import com.example.covid19tracker.LatestApi.DAO.SummaryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class LatestCovid19DataProvider {

    @Autowired
    RestTemplate restTemplate;

    String url = "https://api.rootnet.in/covid19-in/stats/latest";

    public SummaryData GetSummaryData() {
        Covid19ApiLatest covid19ApiLatest = restTemplate.getForObject(url, Covid19ApiLatest.class);
        covid19ApiLatest.getData().getSummary().setUpdate(covid19ApiLatest.getLastRefreshed());
        return covid19ApiLatest.getData().getSummary();
    }

    public StateData[] GetAllStateData()
    {
        Covid19ApiLatest covid19ApiLatest = restTemplate.getForObject(url,Covid19ApiLatest.class);
        return covid19ApiLatest.getData().getRegional();
    }
    public StateData GetStateData(String state) {
        Covid19ApiLatest covid19ApiLatest = restTemplate.getForObject(url, Covid19ApiLatest.class);
        return Arrays.stream(covid19ApiLatest.getData().getRegional()).filter(e -> e.getLoc().equalsIgnoreCase(state))
                .findAny().orElse(new StateData());

    }
}
