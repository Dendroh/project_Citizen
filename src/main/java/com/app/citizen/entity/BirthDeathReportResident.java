package com.app.citizen.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "birth_death_report_resident")
public class BirthDeathReportResident {
  @EmbeddedId
  private Pk pk;

  @Column(name = "birth_death_report_date")
  private LocalDateTime birthDeathReportDate;

  @Column(name = "birth_report_qualifications_code")
  private String birthReportQualificationsCode;

  @Column(name = "death_report_qualifications_code")
  private String deathReportQualificationsCode;

  @Column(name = "email_address")
  private String emailAddress;

  @Column(name = "phone_number")
  private String phoneNumber;

  @MapsId("residentSerialNumber")
  @ManyToOne
  @JoinColumn(name = "resident_serial_number")
  private Resident birthDeathResident;

  @MapsId("reportResident")
  @ManyToOne
  @JoinColumn(name = "report_resident_serial_number")
  private Resident reportResident;

  @NoArgsConstructor
  @AllArgsConstructor
  @EqualsAndHashCode
  @Getter
  @Setter
  @Embeddable
  public static class Pk implements Serializable {
    @Column(name = "resident_serial_number")
    private Integer residentSerialNumber;

    @Column(name = "birth_death_type_code")
    private String birthDeathTypeCode;

    @Column(name = "report_resident_serial_number")
    private Integer reportResident;
  }
}
