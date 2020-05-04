package com.asseco.cm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Configuration
//@Component
//@PropertySource("classpath:logging.properties")
public class Config {

  @Value("${ws.fdp.address}")
  public String wsAddress;
//  private static String wsAddress;

  @Value("${fdp.wssOut.enabled}")
  public Boolean wssOutEnabled;

  public Config () {
    System.out.println("Config!");
    System.out.println("Adress: "+wsAddress);
    //this.setWsAddress("Testowy IP");
    //System.out.println("Adress: "+wsAddress);
  }


  public String getWsAddress() {
    return wsAddress;
  }

  public void setWsAddress(String wsAddress) {
    this.wsAddress = wsAddress;
  }
}
