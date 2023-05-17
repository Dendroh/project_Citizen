package com.app.citizen.service;

import com.app.citizen.entity.Member;
import com.app.citizen.repository.MemberRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailService implements UserDetailsService {
  private final MemberRepository memberRepository;

  public CustomUserDetailService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Member member = memberRepository.findById(username)
            .orElseThrow(() -> new UsernameNotFoundException(username + "not found"));

    return new User(member.getId(), member.getPwd(),
            Collections.singletonList(new SimpleGrantedAuthority(member.getAuthority().getAuthority())));
  }
}
