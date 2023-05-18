package com.app.citizen.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "certificate_issue")
public class CertificateIssue {
  @Id
  @Column(name = "certificate_confirmation_number")
  private Long certificateConfirmationNumber;

  @ManyToOne
  @JoinColumn(name = "resident_serial_number")
  private Resident certificateRequestResident;

  @Column(name = "certificate_type_code")
  private String certificateTypeCode;

  @Column(name = "certificate_issue_date")
  private LocalDateTime certificateIssueDate;

}
