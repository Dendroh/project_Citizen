package com.app.citizen.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "household_movement_address")
public class HouseholdMovementAddress {
  @EmbeddedId
  private Pk pk;

  @Column(name = "house_movement_address")
  private String houseMovementAddress;

  @Column(name = "last_address_yn")
  private String lastAddressYn;

  @MapsId("householdSerialNumber")
  @ManyToOne
  @JoinColumn(name = "household_serial_number")
  private Household movedHousehold;

  @NoArgsConstructor
  @AllArgsConstructor
  @EqualsAndHashCode
  @Getter
  @Setter
  @Embeddable
  public static class Pk implements Serializable {
    @Column(name = "household_serial_number")
    private Integer householdSerialNumber;

    @Column(name = "house_movement_report_date")
    private LocalDateTime houseMovementReportDate;
  }

  public String getFormattedReportDate() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return pk.houseMovementReportDate.format(formatter);
  }
}
