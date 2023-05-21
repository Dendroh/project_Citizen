package com.app.citizen.domain.Request;
import lombok.Data;

@Data
public class FamilyRegisterRequest {

  private int familyResidentSerialNumber;

  private String familyRelationshipCode;
}
