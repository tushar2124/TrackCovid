package com.example.covid19tracker.LatestApi.DAO;

import com.example.covid19tracker.HistoryApi.DAO.HistoryStateData;
import lombok.Data;

@Data
public class StateData {


        private String loc;
        private int confirmedCasesIndian;
        private int confirmedCasesForeign;
        private int discharged;
        private int deaths;
        private int totalConfirmed;


}
