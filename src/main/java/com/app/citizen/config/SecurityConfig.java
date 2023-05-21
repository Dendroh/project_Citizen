package com.app.citizen.config;

import com.app.citizen.auth.LoginSuccessHandler;
import com.app.citizen.service.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableMethodSecurity(prePostEnabled = true)
@EnableWebSecurity(debug = false)
@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
            .authorizeHttpRequests()
              .requestMatchers("/css/**").permitAll()
              .anyRequest().permitAll()
              .and()

            .formLogin()
              .loginPage("/login")
              .loginProcessingUrl("/login-process")
              .usernameParameter("username")
              .passwordParameter("password")
              .successHandler(loginSuccessHandler())
              .and()

            .oauth2Login()
              .loginPage("/login")
              .clientRegistrationRepository(clientRegistrationRepository())
              .authorizedClientService(authorizedClientService())
              .successHandler(loginSuccessHandler())
              .and()

            .logout()
              .deleteCookies("SESSION")
              .invalidateHttpSession(true)
              .and()

            .csrf()
              .disable()

            .headers()
              .defaultsDisabled()
              .frameOptions().sameOrigin()
              .and()

            .sessionManagement()
              .sessionFixation()
                .none()
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

  @Bean
  public ClientRegistrationRepository clientRegistrationRepository() {
    return new InMemoryClientRegistrationRepository(github());
  }

  @Bean
  public OAuth2AuthorizedClientService authorizedClientService() {
    return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository());
  }

  private ClientRegistration github() {
    return CommonOAuth2Provider.GITHUB.getBuilder("github")
            .clientId("168d20325ace2a4e23c0")
            .clientSecret("0cef5f0e1999de91a793a39e29c30be9255d0777")
            .userNameAttributeName("name")
            .build();
  }
}
