package com.asseco.cm;

import javax.ws.rs.ApplicationPath;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ApplicationPath("/api")
public class Application extends SpringBootServletInitializer {

  private static final Logger logger = LoggerFactory.getLogger(Application.class);

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    logger.debug("TEST MISIA");
    return application.sources(Application.class);
  }

//  @Autowired
//  Config conf;


  public static void main(String[] args) {
    //System.out.println("Main");
    logger.debug("(Main) Start aplikacji - loger: "+logger.getClass().getName());
    logger.info("(Main) Start aplikacji");
    logger.error("(Main) Start aplikacji");
    System.out.println(logger.getClass().getName());
    System.out.println(logger.isDebugEnabled());

    SpringApplication.run(Application.class, args);
    //System.out.println("Po main");
  }
}
