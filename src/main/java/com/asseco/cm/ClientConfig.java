package com.asseco.cm;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Slf4j
@Data
@Configuration
//@PropertySource("classpath:FDPproxy.properties")
@PropertySource(value = "classpath:FDPproxy.properties", ignoreResourceNotFound = true)
public class ClientConfig {

  @Value("${conf.filename:Brak}")
  public String confFilename;

  @Value("${conf.fdp.wsdl.url:Brak}")
  public String confFdpWsdlUrl;

  @Value("${conf.fdp.wss.enabled:false}")
  public boolean confWSSEnabled;

  public ClientConfig () {
    log.debug("ClientConfig created!");
  }

  public boolean getConfWSSEnabled() {
    return confWSSEnabled;
  }
}
