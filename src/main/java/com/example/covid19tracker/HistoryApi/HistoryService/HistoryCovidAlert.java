package com.example.covid19tracker.HistoryApi.HistoryService;

import com.example.covid19tracker.HistoryApi.DAO.HistoryData;
import com.example.covid19tracker.HistoryApi.DAO.HistoryStateData;
import com.example.covid19tracker.HistoryApi.DAO.HistorySummaryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class HistoryCovidAlert {

    @Autowired
    HistoryCovid19DataProvider historyCovid19DataProvider;

    public HistorySummaryData getHistorySummaryData(ZonedDateTime zonedDateTime)
    {
        LocalDate localDate = zonedDateTime.toLocalDate();

        localDate = localDate.minusDays(2);
        List<HistoryData> listOfData = historyCovid19DataProvider.getHistoryData();

        for(int i=0;i<listOfData.size();i++)
        {
            if(listOfData.get(i).getDay().equals(localDate))
                return listOfData.get(i).getSummary();
        }

        return null;
    }


    public List<HistoryStateData> getHistoryStateData(ZonedDateTime zonedDateTime,String state)
    {
        LocalDate localDate = zonedDateTime.toLocalDate();
        localDate = localDate.minusDays(1);
        List<HistoryData> listOfData = historyCovid19DataProvider.getHistoryData();

        System.out.println(localDate);
        System.out.println(state);
        for(int i=0;i<listOfData.size();i++)
        {
            if(listOfData.get(i).getDay().equals(localDate))
            {
                for(int j=0;j<listOfData.get(i).getRegional().size();j++)
                {
                    if(listOfData.get(i).getRegional().get(j).getLoc().equalsIgnoreCase(state))
                        return listOfData.get(i).getRegional().subList(j,j+1);
                }
            }

        }

        return null;
    }


    public List<HistoryStateData> getAllHistoryStateData(ZonedDateTime zonedDateTime)
    {
        LocalDate localDate = zonedDateTime.toLocalDate();
        localDate = localDate.minusDays(1);
        List<HistoryData> listOfData = historyCovid19DataProvider.getHistoryData();


        for(int i=0;i<listOfData.size();i++)
        {
            if(listOfData.get(i).getDay().equals(localDate))
            {
                return listOfData.get(i).getRegional();
            }
            }

        return null;

        }

        public HistorySummaryData GetParticularDateWiseCountryData(String localDate)
        {
            List<HistoryData> listOfData = historyCovid19DataProvider.getHistoryData();
            System.out.println(localDate);
            for(int i=0;i<listOfData.size();i++)
            {
                if(listOfData.get(i).getDay().toString().equalsIgnoreCase(localDate))
                {
                    System.out.println("i" + i + "    " + listOfData.get(i).getSummary().getDeaths());
                    return listOfData.get(i).getSummary();
                }
            }
            return null;
        }

    public List<HistoryStateData> GetParticularDateWiseStateData(String localDate)
    {
        List<HistoryData> listOfData = historyCovid19DataProvider.getHistoryData();
        System.out.println(localDate);
        for(int i=0;i<listOfData.size();i++)
        {
            if(listOfData.get(i).getDay().toString().equalsIgnoreCase(localDate))
            {
                return listOfData.get(i).getRegional();
            }
        }
        return null;
    }

}