package com.app.citizen.config;

import com.app.citizen.auth.LoginSuccessHandler;
import com.app.citizen.service.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
            .authorizeHttpRequests()
              .requestMatchers("/teacher/**").hasAnyAuthority("ROLE_TEACHER")
              .requestMatchers("/student/**").hasAnyAuthority("ROLE_STUDENT")
              .requestMatchers("redirect-index").authenticated()
              .anyRequest().permitAll()
              .and()

            .formLogin()
              .loginPage("/login")
              .loginProcessingUrl("/login-process")
              .usernameParameter("username")
              .passwordParameter("password")
              .successHandler(loginSuccessHandler())
              .and()

            .logout()
              .deleteCookies("LOGIN")
              .invalidateHttpSession(true)
              .and()

            .csrf()
              .disable()

            .headers()
              .defaultsDisabled()
              .frameOptions().sameOrigin()
              .and()

            .exceptionHandling()
              .accessDeniedPage("/error/403")
              .and()

            .build();
  }

  @Bean
  public AuthenticationProvider authenticationProvider(CustomUserDetailService customuserDetailService,
                                                       PasswordEncoder passwordEncoder) {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(customuserDetailService);
    authenticationProvider.setPasswordEncoder(passwordEncoder);
    return authenticationProvider;
  }

  @Bean
  public AuthenticationSuccessHandler loginSuccessHandler() {
    return new LoginSuccessHandler();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
