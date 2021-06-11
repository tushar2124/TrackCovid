package com.example.covid19tracker.HelpLineNumbersForCovid.Controller;

import com.example.covid19tracker.HelpLineNumbersForCovid.Service.ContactCovid19DataProvider;
import com.example.covid19tracker.HelpLineNumbersForCovid.StateContactData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OurController {

    @Autowired
    ContactCovid19DataProvider contactCovid19DataProvider;

}
