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

//  @Autowired
//  Config conf;


  public static void main(String[] args) {
    //System.out.println("Main");
    log.debug("(Main) Start aplikacji - loger: "+log.getClass().getName());
    log.info("(Main) Start aplikacji");
    log.error("(Main) Start aplikacji");
    System.out.println(log.getClass().getName());
    System.out.println(log.isDebugEnabled());

    SpringApplication.run(Application.class, args);
    //System.out.println("Po main");
  }
}
