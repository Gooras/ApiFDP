package com.asseco.cm;

import static com.asseco.cm.FDPApiTools.myLog;

import com.asseco.cm.fdp.client.CmAccountManagementRequest;
import com.asseco.cm.fdp.client.CmCardAccountBindingRequest;
import com.asseco.cm.fdp.client.CmCardIssuingRequest;
import com.asseco.cm.fdp.client.CmCardIssuingResponse;
import com.asseco.cm.fdp.client.CmCardStatusUpdateRequest;
import com.asseco.cm.fdp.client.CmOperationResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import javax.xml.namespace.QName;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.firstdata.wdx.business.card.CardAccountBindingRequest;
import pl.firstdata.wdx.business.card.CardIssuingResponse;
import pl.firstdata.wdx.business.card.CardStatusUpdateRequest;
import pl.firstdata.wdx.business.card.v5.CardService;
import pl.firstdata.wdx.business.card.v5.CardService_Service;
import pl.firstdata.wdx.business.card.v5.OperationResult;


@Slf4j
@RestController
@RequestMapping("/api/xml")
public class FDPProxyXMLController {

  @Autowired
  Config conf;

  @Autowired
  ClientConfig clientConf;

  @Autowired
  CardService cardService;
  @Autowired
  Client client;

  public static URL wsdl_url;

  private String nl = System.lineSeparator();

  CardService_Service cService;

  @Bean
  public CardService cardService() throws MalformedURLException {

    //TODO: zgłosić wyjątek, gdy url nieprawidłowy
    URL url = new URL(clientConf.getConfFdpWsdlUrl());
    //URL url = new URL(conf.getWsAddress());
    //url = conf.getWsdl();
    log.debug("(Bean) (CardService) WSDL: "+url);
    CardService_Service service = null;

    //TODO: zgłosić wyjątek, gdy nie uda się stworzyć serwisu? Da się to jakoś sprawdzić?
    try {
      service = new CardService_Service(url);
    } catch (Exception e) {
      log.error("(Bean) (CardService) Błąd tworzenia serwisu "+url+e.getLocalizedMessage());
    }

    if (service==null) {
      log.error("(Bean) (CardService) Błąd tworzenia serwisu "+url);
    } else
      log.debug("(Bean) (CardService) Serwis utworzony "+url);

    CardService cardService = service.getCardServicePort();

    return service.getCardServicePort();
  }

  @Bean
  public Client client() {
    Client cli = (Client) cardService;
    log.debug("(Bean) Klient utworzony");
    //TODO - interceptory do logowania, interceptory do WSS jak włączony parametr
    addInterceptors(cli);
    log.debug("(Bean) Klient - interceptory włączone");
    return cli;
  }

//Właściwe metody REST

  @RequestMapping(value = FDPRestURIConstants.ACC_MNGMT, consumes = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
//  public OperationResult accountManagement(@RequestBody AccountManagementRequest request) {
  public OperationResult accountManagement(@RequestBody CmAccountManagementRequest request) {

    log.debug("Metoda: " + FDPRestURIConstants.ACC_MNGMT);
    log.debug("Request: " + nl + FDPApiTools.jaxbObjectToXML(request));
    OperationResult result = cardService.accountManagement(request);
    log.debug("Response: " + nl + FDPApiTools.jaxbObjectToXML(result));
    return result;
  }

  @RequestMapping(value = FDPRestURIConstants.CARD_ISS, consumes = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
//  public OperationResult cardIssuing(@RequestBody CardIssuingRequest request) {
  public OperationResult cardIssuing(@RequestBody CmCardIssuingRequest request) {
    log.debug("Metoda: " + FDPRestURIConstants.CARD_ISS);
    log.debug("Request (XML): " + nl + FDPApiTools.jaxbObjectToXML(request));
    CardIssuingResponse result = cardService.cardIssuing(request);
    log.debug("Response (XML): " + nl + FDPApiTools.jaxbObjectToXML(result));
    return result;
  }

  @RequestMapping(value = FDPRestURIConstants.CARD_BIND, consumes = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
//  public OperationResult binding(@RequestBody CardAccountBindingRequest request) {
  public OperationResult binding(@RequestBody CmCardAccountBindingRequest request) {
    log.debug("Metoda: " + FDPRestURIConstants.CARD_BIND);
    log.debug("Request: " + nl + FDPApiTools.jaxbObjectToXML(request));
    OperationResult result = cardService.cardAccountBinding(request);
    log.debug("Response: " + nl + FDPApiTools.jaxbObjectToXML(result));
    return result;
  }

  @RequestMapping(value = FDPRestURIConstants.CARD_STATUS, consumes = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
//  public OperationResult cardStatus(@RequestBody CardStatusUpdateRequest request) {
  public OperationResult cardStatus(@RequestBody CmCardStatusUpdateRequest request) {
    log.debug("Metoda: " + FDPRestURIConstants.CARD_STATUS);
    log.debug("Request: " + nl + FDPApiTools.jaxbObjectToXML(request));
    OperationResult result = cardService.updateCardStatus(request);
    log.debug("Response: " + nl + FDPApiTools.jaxbObjectToXML(result));
    return result;
  }

  @RequestMapping(value = FDPRestURIConstants.VERSION, consumes = MediaType.ALL_VALUE, method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
  public String getVersion() {
    log.debug("Metoda: " + FDPRestURIConstants.VERSION+" ver: "+conf.getAppVersion());

    return "ver: "+conf.getAppVersion()
        + nl + "<br/>logger: "+ log.getClass().getName()
        + nl + "<br/>conf: "+clientConf.getConfFilename();
  }

  private void addInterceptors(Client cli) {

    if (clientConf.getConfWSSEnabled()) {

      if (conf.getLoggingInEnabled()) {
        myLog("DemoController - interceptory do logowania - In");
        LoggingInInterceptor loggerIn = new LoggingInInterceptor();
        PrintWriter writerIn = null;
        try {
          writerIn = new PrintWriter(new File("src/main/resources/FDPProxyIn.log"));
          //writerIn = new PrintWriter(new File("C:/Users/Grzegorz.Gora/Desktop/REST/FDPapi/src/main/resources/FDPProxyIn.log"));
        } catch (FileNotFoundException e) {
          log.error(e.getLocalizedMessage());
          e.printStackTrace();
        }

        loggerIn.setPrintWriter(writerIn);
        cli.getInInterceptors().add(loggerIn);
      }

      if (conf.getLoggingOutEnabled()) {
        myLog("DemoController - interceptory do logowania - Out");
        PrintWriter writerOut = null;
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");
        String strDate = dateFormat.format(date);
        String fileName = conf.getLoggingOutFileName()+"_"+strDate+".log";
        try {
          File file = new File("/logs/"+fileName);
          log.debug("Path1: "+file.getAbsolutePath());
          log.debug("Writer: "+file.getCanonicalPath());
          writerOut = new PrintWriter(file);
          file = new File(fileName);
          log.debug("Path2: "+file.getAbsolutePath());
          log.debug("Writer: "+file.getCanonicalPath());
          writerOut = new PrintWriter(file);
          file = new File("../log/"+fileName);
          log.debug("Path3: "+file.getAbsolutePath());
          log.debug("Writer: "+file.getCanonicalPath());
          file = new File("./log/"+fileName);
          log.debug("Path4: "+file.getAbsolutePath());
          log.debug("Writer: "+file.getCanonicalPath());
          writerOut = new PrintWriter(file);

//          writerOut = new PrintWriter(new File("src/main/resources/FDPProxyOut.log"));
        } catch (FileNotFoundException e) {
          log.error(e.getLocalizedMessage());
          e.printStackTrace();
        } catch (IOException e) {
          log.error(e.getLocalizedMessage());
          e.printStackTrace();
        }

        LoggingOutInterceptor loggerOut = new LoggingOutInterceptor(writerOut);
        cli.getOutInterceptors().add(loggerOut);
      }

    }//koniec warunku 1=0

  }

}
