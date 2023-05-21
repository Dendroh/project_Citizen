package com.app.citizen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "resident")
public class Resident {
  @Id
  @Column(name = "resident_serial_number")
  private int residentSerialNumber ;

  @Column(name = "name")
  private String name;

  @Column(name = "resident_registration_number")
  private String residentRegistrationNumber;

  @Column(name = "gender_code")
  private String genderCode;

  @Column(name = "birth_date")
  private LocalDateTime birthDate;

  @Column(name = "birth_place_code")
  private String birthPlaceCode;

  @Column(name = "registration_base_address")
  private String registrationBaseAddress;

  @Column(name = "death_date")
  private LocalDateTime deathDate;

  @Column(name = "death_place_code")
  private String deathPlaceCode;

  @Column(name = "death_place_address")
  private String deathPlaceAddress;

  @OneToMany(mappedBy = "baseResident", cascade = CascadeType.ALL)
  private List<FamilyRelationship> baseFamilyRelationships;

  @OneToMany(mappedBy = "familyResident", cascade = CascadeType.ALL)
  private List<FamilyRelationship> familyFamilyRelationships;

  @OneToMany(mappedBy = "birthDeathResident", cascade = CascadeType.ALL)
  private List<BirthDeathReportResident> birthDeathResidents;

  @OneToMany(mappedBy = "reportResident", cascade = CascadeType.ALL)
  private List<BirthDeathReportResident> reportResidents;

  @OneToMany(mappedBy = "certificateRequestResident", cascade = CascadeType.ALL)
  private List<CertificateIssue> certificateIssues;

  @OneToMany(mappedBy = "householdResident", cascade = CascadeType.ALL)
  private List<Household> households;

  @OneToMany(mappedBy = "householdCompositionResident", cascade = CascadeType.ALL)
  private List<HouseholdCompositionResident> householdCompositionResidents;

  public String getFormattedBirthDate() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return birthDate.format(formatter);
  }

  public String getFormattedBirthDateTime() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy 년 MM 월 dd 일 HH 시 mm 분 (한국시간 : 24시각제로 기제)");
    return birthDate.format(formatter);
  }


  public String getFormattedDeathDateTime() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy 년 MM 월 dd 일 HH 시 mm 분 (한국시간 : 24시각제로 기제)");
    return deathDate.format(formatter);
  }
}
