package com.asseco.cm;

import java.net.URL;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Slf4j
@Setter
@Getter
@Configuration
@PropertySource(value = "classpath:FDPproxy.properties", ignoreResourceNotFound = true)
public class Config {

  //do testu zewn. properties
  @Value("${gg.test:domyslna wartosc gg.test}")
  public String ggTest;

  @Value("${app.version:x.y.z}")
  public String appVersion;

  @Value("${ws.fdp.address}")
  public String wsAddress;
//  private static String wsAddress;

  @Value("${wsdl.url}")
  public String wsdlUrl;

  @Value("${wsdl.wss.url}")
  public String wsdlWssUrl;

  //te zostaną
  @Value("${wsdl.filename}")
  public String wsdlFilename;

  @Value("${wsdl.wss.filename}")
  public String wsdlWssFilename;

  @Value("${fdp.wss.enabled}")
  public Boolean wssEnabled;

  @Value("${fdp.wssOut.enabled}")
  public Boolean wssOutEnabled;

  @Value("${fdp.wssIn.enabled}")
  public Boolean wssInEnabled;

  @Value("${fdp.loggingOut.enabled}")
  public Boolean loggingOutEnabled;

  @Value("${fdp.loggingOut.fileName}")
  public String loggingOutFileName;

  @Value("${fdp.loggingIn.enabled}")
  public Boolean loggingInEnabled;

  @Value("${fdp.loggingIn.fileName}")
  public String loggingInFileName;

  @Value("${fdp.debug.enabled}")
  public Boolean debugEnabled;

  public String getWsdlFileNameForService() {
    if (getWssEnabled()) {
      return getWsdlWssFilename();
    } else {
      return getWsdlFilename();
    }
  }

  public URL getWsdl() {
    if (getWssEnabled()) {
      return ClassLoader.getSystemResource(getWsdlWssFilename());
    } else {
      return ClassLoader.getSystemResource(getWsdlFilename());
    }
  }
  public Config () {
    System.out.println("Config!");
    log.debug("Config created!");
    //System.out.println("Adress: "+wsAddress);
    //this.setWsAddress("Testowy IP");
    //System.out.println("Adress: "+wsAddress);
  }

}
