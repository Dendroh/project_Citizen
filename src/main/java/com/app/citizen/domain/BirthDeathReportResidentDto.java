package com.app.citizen.domain;

public class BirthDeathReportResidentDto {

  public String birthDeathReportResidentQualificationCode;

  public String birthDeathReportResidentName;

  public String birthDeathReportResidentRegistrationNumber;

  public String birthDeathReportResidentPhoneNumber;

  public String birthDeathReportResidentEmail;

  public BirthDeathReportResidentDto(String birthDeathReportResidentQualificationCode, String birthDeathReportResidentName, String birthDeathReportResidentRegistrationNumber, String birthDeathReportResidentPhoneNumber, String birthDeathReportResidentEmail) {
    this.birthDeathReportResidentQualificationCode = birthDeathReportResidentQualificationCode;
    this.birthDeathReportResidentName = birthDeathReportResidentName;
    this.birthDeathReportResidentRegistrationNumber = birthDeathReportResidentRegistrationNumber;
    this.birthDeathReportResidentPhoneNumber = birthDeathReportResidentPhoneNumber;
    this.birthDeathReportResidentEmail = birthDeathReportResidentEmail;
  }
}
