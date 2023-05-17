package com.app.citizen.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Authroties")
public class Authority {
  @Id
  @Column(name = "member_id")
  private String id;

  private String authority;

  @MapsId
  @OneToOne
  @JoinColumn(name = "member_id")
  private Member member;
}
