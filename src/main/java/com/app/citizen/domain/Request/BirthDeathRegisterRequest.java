package com.app.citizen.domain.Request;

import lombok.Data;

@Data
public class BirthDeathRegisterRequest {
  private String birthDeathTypeCode;
  private int targetResidentSerialNumber;
  private String birthDeathReportDate;
  private String birthReportQualificationsCode;
  private String deathReportQualificationsCode;
  private String emailAddress;
  private String phoneNumber;

}
