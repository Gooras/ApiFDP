package com.asseco.cm;

import java.net.MalformedURLException;
import java.net.URL;
import javax.ws.rs.ApplicationPath;
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

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Application.class);
  }

  @Autowired
  Config conf;

/*  @Bean @Lazy
  public CardService cardService() throws MalformedURLException {
    //URL url = new URL("http://localhost:8088/mockCardServiceBinding?wsdl");
    URL url = new URL(conf.getWsAddress());
    System.out.println("Bean "+url);

    CardService_Service service = new CardService_Service(url);

    CardService cardService = service.getCardServicePort();

    return service.getCardServicePort();
  }
*/

  public static void main(String[] args) {
    System.out.println("Main");
    SpringApplication.run(Application.class, args);
    System.out.println("Po main");
  }
}
