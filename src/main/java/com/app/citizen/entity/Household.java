package com.app.citizen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "household")
public class Household {
  @Id
  @Column(name = "household_serial_number")
  private Integer householdSerialNumber;

  @ManyToOne
  @JoinColumn(name = "household_resident_serial_number")
  private Resident householdResident;

  @Column(name = "household_composition_date")
  private LocalDateTime householdCompositionDate;

  @Column(name = "household_composition_reason_code")
  private String householdCompositionReasonCode;

  @Column(name = "current_house_movement_address")
  private String currentHouseMovementAddress;

  @OneToMany(mappedBy = "baseHousehold", cascade = CascadeType.ALL)
  private List<HouseholdCompositionResident> householdCompositionResidents;

  @OneToMany(mappedBy = "movedHousehold", cascade = CascadeType.ALL)
  private List<HouseholdMovementAddress> householdMovementAddresses;
}
