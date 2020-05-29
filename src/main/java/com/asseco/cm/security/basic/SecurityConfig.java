package com.asseco.cm.security.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeRequests()
        //.antMatchers(HttpMethod.GET, "/api/*").permitAll()
        .antMatchers("/api/xml/version").permitAll()
        .anyRequest().authenticated()
        .and()
        .httpBasic();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth)
      throws Exception
  {

    //TODO: do zmiany użytkownik i hasło i ew. do użycia jakaś metoda kodowania hasła - BCrypt? coś innego niż samo Base64
    auth.inMemoryAuthentication()
        .withUser("cmadmin")
        .password("{noop}passwordcm")
        .roles("USER");
//        .and()
//        .withUser("cmadmin")
//        .password(passwordEncoder().encode("admincmpass"))
//        .roles("ADMIN");
  }

  //@Bean
  //public PasswordEncoder passwordEncoder() {
  //  return new BCryptPasswordEncoder();
  //}
}