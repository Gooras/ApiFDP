package com.asseco.cm;

import com.asseco.cm.callback.ClientKeyStorePasswordCallback;
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

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.firstdata.wdx.business.card.AccountManagementRequest;
import pl.firstdata.wdx.business.card.CardAccountBindingRequest;
import pl.firstdata.wdx.business.card.CardIssuingRequest;
import pl.firstdata.wdx.business.card.CardIssuingResponse;
import pl.firstdata.wdx.business.card.CardStatusUpdateRequest;
import pl.firstdata.wdx.business.card.CrtaResponse;
import pl.firstdata.wdx.business.card.ReadCrtaRequest;
import pl.firstdata.wdx.business.card.v5.CardService;
import pl.firstdata.wdx.business.card.v5.CardService_Service;
import pl.firstdata.wdx.business.card.v5.OperationResult;

import com.asseco.cm.fdp.client.CmAccountManagementRequest;
import com.asseco.cm.fdp.client.CmCardAccountBindingRequest;
import com.asseco.cm.fdp.client.CmCardIssuingRequest;
import com.asseco.cm.fdp.client.CmCardStatusUpdateRequest;


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
    //MOCK Michała
    //url = new File(
    //    "C:/Users/Grzegorz.Gora/Desktop/REST/FDPapi/src/main/resources/CardServiceWSSMock.wsdl")
    //    .toURI().toURL();
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

    log.debug("(Bean) (CardService_Service): "+service.toString());

    cardService = service.getCardServicePort();
    //CardService cardService = service.getCardServicePort();
    //this.cardService = cardService;
    log.debug("Serwis utworzony: " + cardService.toString());

    client = (Client) cardService;
    log.debug("(Bean) Klient utworzony " + client.toString());
//    addInterceptors(client);
    addInterceptors();
    log.debug("(Bean) Klient - interceptory włączone");

    //return service.getCardServicePort();
    return cardService;
  }

  //@Bean
  /*public Client client(CardService cardService) {
    Client cli = (Client) cardService;
    log.debug("(Bean) Klient utworzony " + cli.toString());
    //TODO - interceptory do logowania, interceptory do WSS jak włączony parametr
    //addInterceptors(cli);
    log.debug("(Bean) Klient - interceptory włączone");
    return cli;
  }*/

//Właściwe metody REST

  @RequestMapping(value = FDPRestURIConstants.ACC_MNGMT, consumes = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
  public OperationResult accountManagement(@RequestBody AccountManagementRequest request) {
//  public OperationResult accountManagement(@RequestBody CmAccountManagementRequest request) {

    log.debug("Metoda: " + FDPRestURIConstants.ACC_MNGMT);
    log.debug("Request: " + nl + FDPApiTools.jaxbObjectToXML(request));
    OperationResult result = cardService.accountManagement(request);
    log.debug("Response: " + nl + FDPApiTools.jaxbObjectToXML(result));
    return result;
  }

  @RequestMapping(value = FDPRestURIConstants.CARD_ISS, consumes = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
  public OperationResult cardIssuing(@RequestBody CardIssuingRequest request) {
//  public OperationResult cardIssuing(@RequestBody CmCardIssuingRequest request) {
    log.debug("Metoda: " + FDPRestURIConstants.CARD_ISS);
    log.debug("Request (XML): " + nl + FDPApiTools.jaxbObjectToXML(request));
    CardIssuingResponse result = cardService.cardIssuing(request);
    log.debug("Response (XML): " + nl + FDPApiTools.jaxbObjectToXML(result));
    return result;
  }

  @RequestMapping(value = FDPRestURIConstants.CARD_BIND, consumes = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
  public OperationResult binding(@RequestBody CardAccountBindingRequest request) {
//  public OperationResult binding(@RequestBody CmCardAccountBindingRequest request) {
    log.debug("Metoda: " + FDPRestURIConstants.CARD_BIND);
    log.debug("Request: " + nl + FDPApiTools.jaxbObjectToXML(request));
    OperationResult result = cardService.cardAccountBinding(request);
    log.debug("Response: " + nl + FDPApiTools.jaxbObjectToXML(result));
    return result;
  }

  @RequestMapping(value = FDPRestURIConstants.CARD_STATUS, consumes = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
  public OperationResult cardStatus(@RequestBody CardStatusUpdateRequest request) {
//  public OperationResult cardStatus(@RequestBody CmCardStatusUpdateRequest request) {
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

  //do testów WSS na MOCKu:
  @RequestMapping(value = "/testWSScrta", consumes = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
  public CrtaResponse crta(@RequestBody ReadCrtaRequest request) {
    log.debug("Metoda: " + "/testWSScrta");
    log.debug("Request: " + nl + FDPApiTools.jaxbObjectToXML(request));
    log.debug("Serwis: " + cardService.toString());
    log.debug("Klient: " + client.toString());
    CrtaResponse result = cardService.readCrta(request);
    log.debug("Response: " + nl + FDPApiTools.jaxbObjectToXML(result));
    return result;
  }


//  private void addInterceptors(Client cli) {
  public void addInterceptors() {

    if (clientConf.getConfWSSEnabled()) {

      log.debug("interceptory WSS Start - Klient: " + client.toString());

      //Incoming
      Map<String, Object> incomingProps = new HashMap<String, Object>();
      incomingProps.put(WSHandlerConstants.ACTION,
          WSHandlerConstants.TIMESTAMP + " " + WSHandlerConstants.SIGNATURE + " " + WSHandlerConstants.ENCRYPT);
      incomingProps.put(WSHandlerConstants.SIG_PROP_FILE, "clientKeyStore.properties");
      incomingProps.put(WSHandlerConstants.DEC_PROP_FILE, "clientKeyStore.properties");//odpowiednik truststore
      incomingProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, ClientKeyStorePasswordCallback.class.getName());
      incomingProps.put(WSHandlerConstants.ALLOW_RSA15_KEY_TRANSPORT_ALGORITHM, "true");

      WSS4JInInterceptor wssIncoming = new WSS4JInInterceptor(incomingProps);
      System.out.println("FDPProxyXMLController - interceptory do logowania - In: "+wssIncoming.toString());
      client.getInInterceptors().add(wssIncoming);

      //Outgoing
      Map<String, Object> outgoingProps = new HashMap<String, Object>();

      outgoingProps.put(WSHandlerConstants.ACTION,
          WSHandlerConstants.SIGNATURE + " " + WSHandlerConstants.ENCRYPT);
      outgoingProps.put(WSHandlerConstants.SIG_PROP_FILE, "clientKeyStore.properties");
      outgoingProps.put(WSHandlerConstants.ENC_PROP_FILE, "clientKeyStore.properties");
      outgoingProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, ClientKeyStorePasswordCallback.class.getName());

//to dziaĹ‚a z FDP
//        outgoingProps.put(WSHandlerConstants.USER, "nsb");
//to dziaĹ‚a z mockiem
      outgoingProps.put(WSHandlerConstants.USER, "fdp");
      outgoingProps.put(WSHandlerConstants.ENCRYPTION_USER, "fdp");
      outgoingProps.put(WSHandlerConstants.SIGNATURE_PARTS,
          "{Element}{http://schemas.xmlsoap.org/soap/envelope/}Body");
      outgoingProps.put(WSHandlerConstants.ENCRYPTION_PARTS,
          "{Element}{http://www.w3.org/2000/09/xmldsig#}Signature;{Content}{http://schemas.xmlsoap.org/soap/envelope/}Body");
      outgoingProps.put(WSHandlerConstants.ENC_SYM_ALGO, WSConstants.AES_128);
//    outgoingProps.put(WSHandlerConstants.ALLOW_RSA15_KEY_TRANSPORT_ALGORITHM, "true");

      WSS4JOutInterceptor wssOutgoing = new WSS4JOutInterceptor(outgoingProps);
      client.getOutInterceptors().add(wssOutgoing);
      log.debug("wssOutgoing: " + String.valueOf(client.getOutInterceptors().contains(wssOutgoing)));
    }

    log.debug("interceptory WSS Stop");

    /*if (clientConf.isConfLogCXFEnabled()) {

      if (conf.getLoggingInEnabled()) {
        log.debug("FDPProxyXMLController - interceptory do logowania - In");
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
        client.getInInterceptors().add(loggerIn);
      }

      if (conf.getLoggingOutEnabled()) {
        log.debug("FDPProxyXMLController - interceptory do logowania - Out");
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
//???
//    LoggingOutInterceptor loggerOut = new LoggingOutInterceptor((PrintWriter) log);
        client.getOutInterceptors().add(loggerOut);
      }

    }//koniec warunku 1=0
*/
  }

}
