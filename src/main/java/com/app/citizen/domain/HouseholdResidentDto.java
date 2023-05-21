package com.app.citizen.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HouseholdResidentDto {

  public String householdResidentName;

  public LocalDateTime householdResidentReportDate;

  public String householdResidentChangeReasonCode;

  public HouseholdResidentDto(String householdResidentName, LocalDateTime householdResidentReportDate, String householdResidentChangeReasonCode) {
    this.householdResidentName = householdResidentName;
    this.householdResidentReportDate = householdResidentReportDate;
    this.householdResidentChangeReasonCode = householdResidentChangeReasonCode;
  }

  public String getFormattedReportDate() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return householdResidentReportDate.format(formatter);
  }
}
