package com.example.covid19tracker.HelpLineNumbersForCovid;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Contacts {

    private boolean success;

    private ContactsSummary data;

    private ZonedDateTime lastRefreshed;

    private ZonedDateTime lastOriginUpdate;
}
