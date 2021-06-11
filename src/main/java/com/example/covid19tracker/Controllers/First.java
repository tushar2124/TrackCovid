package com.example.covid19tracker.Controllers;


import com.example.covid19tracker.HelpLineNumbersForCovid.Service.ContactCovid19DataProvider;
import com.example.covid19tracker.HelpLineNumbersForCovid.StateContactData;
import com.example.covid19tracker.HistoryApi.DAO.HistoryStateData;
import com.example.covid19tracker.HistoryApi.DAO.HistorySummaryData;
import com.example.covid19tracker.HistoryApi.HistoryService.HistoryCovidAlert;
import com.example.covid19tracker.LatestApi.DAO.StateData;
import com.example.covid19tracker.LatestApi.DAO.SummaryData;
import com.example.covid19tracker.LatestApi.Service.CovidAlert;
import com.example.covid19tracker.LatestApi.Service.LatestCovid19DataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class First {

    @Autowired
    CovidAlert covidAlert;

    @Autowired
    HistoryCovidAlert historyCovidAlert;

    @Autowired
    LatestCovid19DataProvider latestCovid19DataProvider;

    @Autowired
    ContactCovid19DataProvider contactCovid19DataProvider;

    @GetMapping("/trackcovid")
    public String fun() {
        return "FirstPage";
    }

    @GetMapping("/trackcovid/countrycases")
    public String GetData(Model model) {
        SummaryData summaryData = covidAlert.GetSummaryData();
        HistorySummaryData historySummaryData = historyCovidAlert.getHistorySummaryData(covidAlert.GetSummaryData().getUpdate());
        LocalDate localdate = summaryData.getUpdate().toLocalDate();
        ZonedDateTime localtime = summaryData.getUpdate();
        int total = summaryData.getTotal();
        int deaths = summaryData.getDeaths();
        int discharged = summaryData.getDischarged();
        int activecases = total - deaths - discharged;
        int todaysdeaths = deaths - historySummaryData.getDeaths();
        int todaysdischarged = discharged - historySummaryData.getDischarged();
        int todaysactivecases = activecases - (historySummaryData.getTotal() - historySummaryData.getDeaths() - historySummaryData.getDischarged());
        model.addAttribute("TOTALCASES", total);
        model.addAttribute("DEATHS", deaths);
        model.addAttribute("DISCHARGED", discharged);
        model.addAttribute("ACTIVECASES", activecases);
        model.addAttribute("TODAYSDEATHS", todaysdeaths);
        model.addAttribute("TODAYSDISCHARGED", todaysdischarged);
        model.addAttribute("TODAYSACTIVECASES", todaysactivecases);
        model.addAttribute("localdate", localdate.toString());
        return "Home";
    }


    @GetMapping("/trackcovid/statewisedata")
    public String GetStateData(Model model) {
        StateData[] stateData = latestCovid19DataProvider.GetAllStateData();
        List<HistoryStateData> listOfAllHistoryStates = historyCovidAlert.getAllHistoryStateData(covidAlert.GetSummaryData().getUpdate());
        HistoryStateData[] historyData = listOfAllHistoryStates.toArray(new HistoryStateData[0]);
        model.addAttribute("first", stateData);
        return "StateList";
    }

    @GetMapping("/trackcovid/emergencycontacts")
    public String getStateContactData(Model model) {
        List<StateContactData> cc = contactCovid19DataProvider.GetStateContactData();
        model.addAttribute("contacts", cc);
        return "Contacts";
    }


    @GetMapping("/trackcovid/getcovidcaseson")
    public String GetParticularState(Model model)
    {
        return "GetState";
        //HistorySummaryData historySummaryData = historyCovidAlert.GetParticularDateWiseCountryData();
    }

    @GetMapping("/trackcovid/getcountrycovidcases")
        public String GetParticularCountry(HttpServletRequest httpServletRequest,Model model)
        {
            String date = httpServletRequest.getParameter("getdate");
            HistorySummaryData historySummaryData = historyCovidAlert.GetParticularDateWiseCountryData(date);
            model.addAttribute("date",date);
            model.addAttribute("totalcases",historySummaryData.getTotal());
            model.addAttribute("totaldischarged",historySummaryData.getDischarged());
            model.addAttribute("totaldeaths",historySummaryData.getDeaths());
            model.addAttribute("totalactive",historySummaryData.getTotal()-historySummaryData.getDischarged()-historySummaryData.getDeaths());
            return "getparticularcountry";
        }
}
