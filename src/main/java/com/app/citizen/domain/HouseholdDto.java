package com.app.citizen.domain;

import java.time.LocalDate;

public class HouseholdDto {

  public String householdRelationshipCode;

  public String householdCompositionName;

  public String householdCompositionRegistrationNumber;

  public LocalDate householdCompositionReportDate;

  public String householdCompositionChangeReasonCode;

  public HouseholdDto(String householdRelationshipCode, String householdCompositionName, String householdCompositionRegistrationNumber, LocalDate householdCompositionReportDate, String householdCompositionChangeReasonCode) {
    this.householdRelationshipCode = householdRelationshipCode;
    this.householdCompositionName = householdCompositionName;
    this.householdCompositionRegistrationNumber = householdCompositionRegistrationNumber;
    this.householdCompositionReportDate = householdCompositionReportDate;
    this.householdCompositionChangeReasonCode = householdCompositionChangeReasonCode;
  }
}
