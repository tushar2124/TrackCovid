package com.example.covid19tracker.HelpLineNumbersForCovid;

import lombok.Data;

import java.util.List;

@Data
public class ContactsData {

    private PrimaryContactData primary;

    private List<StateContactData> regional;
}
