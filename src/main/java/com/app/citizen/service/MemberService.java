package com.app.citizen.service;

import com.app.citizen.domain.MemberCreateRequest;
import com.app.citizen.domain.MemberId;
import com.app.citizen.entity.Authority;
import com.app.citizen.entity.Member;
import com.app.citizen.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MemberService {
  private final MemberRepository memberRepository;

  private final PasswordEncoder passwordEncoder;

  public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
    this.memberRepository = memberRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Transactional
  public MemberId createMember(MemberCreateRequest request) {
    Member member = new Member();
    member.setId(request.getId());
    member.setName(request.getName());
    member.setPwd(passwordEncoder.encode(request.getPwd()));

    Authority authority = new Authority();
    authority.setMember(member);
    authority.setAuthority(request.getAuthority());

    member.setAuthority(authority);

    memberRepository.saveAndFlush(member);

    MemberId memberId = new MemberId();
    memberId.setId(member.getId());

    return memberId;
  }
}
