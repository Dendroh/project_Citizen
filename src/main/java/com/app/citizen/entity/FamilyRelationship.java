package com.app.citizen.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "family_relationship")
public class FamilyRelationship {
  @EmbeddedId
  private Pk pk;

  @Column(name = "family_relationship_code")
  private String familyRelationshipCode;

  @MapsId("baseResidentSerialNumber")
  @ManyToOne
  @JoinColumn(name = "base_resident_serial_number")
  private Resident baseResident;

  @MapsId("familyResidentSerialNumber")
  @ManyToOne
  @JoinColumn(name = "family_resident_serial_number")
  private Resident familyResident;

  @NoArgsConstructor
  @AllArgsConstructor
  @EqualsAndHashCode
  @Getter
  @Setter
  @Embeddable
  public static class Pk implements Serializable {
    @Column(name = "base_resident_serial_number")
    private int baseResidentSerialNumber;

    @Column(name = "family_resident_serial_number")
    private int familyResidentSerialNumber;
  }
}
