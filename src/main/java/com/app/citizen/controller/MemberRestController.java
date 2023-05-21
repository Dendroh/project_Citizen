package com.app.citizen.controller;

import com.app.citizen.domain.Request.MemberId;
import com.app.citizen.domain.Request.MemberRegisterRequest;
import com.app.citizen.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberRestController {
  private final MemberService memberService;

  public MemberRestController(MemberService memberService) {
    this.memberService = memberService;
  }

  @PostMapping
  public MemberId registerMember(@RequestBody MemberRegisterRequest request) {
    return memberService.registerMember(request);
  }

  @PutMapping
  public MemberId editMember(@RequestBody MemberRegisterRequest request) {
    return memberService.registerMember(request);
  }
}
