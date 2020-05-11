package com.asseco.cm;

import java.net.MalformedURLException;
import java.net.URL;
import javax.ws.rs.ApplicationPath;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import pl.firstdata.wdx.business.card.ObjectFactory;
import pl.firstdata.wdx.business.card.v5.CardService;
import pl.firstdata.wdx.business.card.v5.CardService_CardServicePort_Client;
import pl.firstdata.wdx.business.card.v5.CardService_Service;
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
    logger.debug("TEST MISIA MAIN");
    SpringApplication.run(Application.class, args);
    //System.out.println("Po main");
  }
}
