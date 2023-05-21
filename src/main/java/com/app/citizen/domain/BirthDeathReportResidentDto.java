package com.app.citizen.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BirthDeathReportResidentDto {

  public String birthDeathReportResidentQualificationCode;

  public String birthDeathReportResidentName;

  public String birthDeathReportResidentRegistrationNumber;

  public String birthDeathReportResidentPhoneNumber;

  public String birthDeathReportResidentEmail;

  public LocalDateTime birthDeathReportDate;

  public BirthDeathReportResidentDto(String birthDeathReportResidentQualificationCode, String birthDeathReportResidentName, String birthDeathReportResidentRegistrationNumber, String birthDeathReportResidentPhoneNumber, String birthDeathReportResidentEmail, LocalDateTime birthDeathReportDate) {
    this.birthDeathReportResidentQualificationCode = birthDeathReportResidentQualificationCode;
    this.birthDeathReportResidentName = birthDeathReportResidentName;
    this.birthDeathReportResidentRegistrationNumber = birthDeathReportResidentRegistrationNumber;
    this.birthDeathReportResidentPhoneNumber = birthDeathReportResidentPhoneNumber;
    this.birthDeathReportResidentEmail = birthDeathReportResidentEmail;
    this.birthDeathReportDate = birthDeathReportDate;
  }

  public String getFormattedDate() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy 년 MM 월 dd 일");
    return birthDeathReportDate.format(formatter);
  }
}
