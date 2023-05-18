package com.app.citizen.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "household_composition_resident")
public class HouseholdCompositionResident {
  @EmbeddedId
  private Pk pk;

  @Column(name = "report_date")
  private LocalDate familyRelationshipCode;

  @Column(name = "household_relationship_code")
  private String householdRelationshipCode;

  @Column(name = "household_composition_change_reason_code")
  private String householdCompositionChangeReasonCode;

  @MapsId("householdSerialNumber")
  @ManyToOne
  @JoinColumn(name = "household_serial_number")
  private Household baseHousehold;

  @MapsId("residentSerialNumber")
  @ManyToOne
  @JoinColumn(name = "resident_serial_number")
  private Resident householdCompositionResident;

  @NoArgsConstructor
  @AllArgsConstructor
  @EqualsAndHashCode
  @Getter
  @Setter
  @Embeddable
  public static class Pk implements Serializable {
    @Column(name = "household_serial_number")
    private Integer householdSerialNumber;

    @Column(name = "resident_serial_number")
    private Integer residentSerialNumber;
  }
}
