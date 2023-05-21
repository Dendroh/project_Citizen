package com.app.citizen.domain.Request;

import lombok.Data;

@Data
public class MemberRegisterRequest {
  private String id;
  private String name;
  private String pwd;
  private String authority;
}
