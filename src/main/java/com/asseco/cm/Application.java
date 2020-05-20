package com.asseco.cm;

import javax.ws.rs.ApplicationPath;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ApplicationPath("/api")
@Slf4j
public class Application extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Application.class);
  }

  public static void main(String[] args) {
    log.debug("(Main) Start aplikacji - loger: "+log.getClass().getName());
    //Test polskich znaków logera
    //log.debug("za\u017c\u00f3\u0142\u0107 g\u0119\u015bl\u0105 ka\u017a\u0144");
    SpringApplication.run(Application.class, args);
  }
}
