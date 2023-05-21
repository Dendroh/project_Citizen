package com.app.citizen.domain;

import lombok.Data;

@Data
public class ResidentRegisterRequest {
  private int residentSerialNumber ;

  private String name;

  private String residentRegistrationNumber;

  private String genderCode;

  private String birthDate;

  private String birthPlaceCode;

  private String registrationBaseAddress;

  private String deathDate;

  private String deathPlaceCode;

  private String deathPlaceAddress;
}
