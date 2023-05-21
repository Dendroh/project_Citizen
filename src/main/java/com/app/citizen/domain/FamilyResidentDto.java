package com.app.citizen.domain;

import java.time.LocalDateTime;

public class FamilyResidentDto {

  public String familyRelationshipCode;

  public String familyResidentName;

  public LocalDateTime familyResidentBirthDate;

  public String familyResidentRegistrationNumber;

  public String familyResidentGenderCode;

  public String familyResidentRegistrationBaseAddress;

  public FamilyResidentDto(String familyRelationshipCode,
                           String familyResidentName,
                           LocalDateTime familyResidentBirthDate,
                           String familyResidentRegistrationNumber,
                           String familyResidentGenderCode,
                           String familyResidentRegistrationBaseAddress) {
    this.familyRelationshipCode = familyRelationshipCode;
    this.familyResidentName = familyResidentName;
    this.familyResidentBirthDate = familyResidentBirthDate;
    this.familyResidentRegistrationNumber = familyResidentRegistrationNumber;
    this.familyResidentGenderCode = familyResidentGenderCode;
    this.familyResidentRegistrationBaseAddress = familyResidentRegistrationBaseAddress;
  }
}
