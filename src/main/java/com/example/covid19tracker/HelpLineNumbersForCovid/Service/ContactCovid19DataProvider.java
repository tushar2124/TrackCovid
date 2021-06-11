package com.example.covid19tracker.HelpLineNumbersForCovid.Service;

import com.example.covid19tracker.HelpLineNumbersForCovid.Contacts;
import com.example.covid19tracker.HelpLineNumbersForCovid.StateContactData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ContactCovid19DataProvider {

    @Autowired
    RestTemplate restTemplate;
    String url = "https://api.rootnet.in/covid19-in/contacts";

    public List<StateContactData> GetStateContactData()
    {
        Contacts contacts = restTemplate.getForObject(url,Contacts.class);
        List<StateContactData> stateContactData = contacts.getData().getContacts().getRegional();
        return stateContactData;
    }
}
