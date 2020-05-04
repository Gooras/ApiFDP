package com.asseco.cm;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import org.springframework.context.annotation.Lazy;
import javax.xml.namespace.QName;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.firstdata.wdx.business.card.AccountManagementRequest;
import pl.firstdata.wdx.business.card.CardAccountBindingRequest;
import pl.firstdata.wdx.business.card.CardIssuingRequest;
import pl.firstdata.wdx.business.card.CardIssuingResponse;
import pl.firstdata.wdx.business.card.CardStatusChangeRequest;
import pl.firstdata.wdx.business.card.v5.CardService;
import pl.firstdata.wdx.business.card.v5.CardService_Service;
import pl.firstdata.wdx.business.card.v5.OperationResult;

@RestController
@Lazy
@RequestMapping("/api")
public class FDPProxyController {

  public static URL wsdl_url;

  CardService_Service cService;
  CardService cardService;

  // Konstruktor - inicjalizacja serwisu FDP
  public FDPProxyController() {
    try {
      System.out.println("FDPProxyController - konstruktor");
//      wsdl_url = new URL("CardService.wsdl");
//      wsdl_url = new File("src/main/resources/CardService.wsdl").toURI().toURL();
//      wsdl_url = new File("/WEB-INF/classes/CardService.wsdl").toURI().toURL();
//      wsdl_url = new File("C:/app/wildfly-14.0.1.Final/bin/CardService.wsdl").toURI().toURL();
      wsdl_url = new File("C:/Users/Grzegorz.Gora/Desktop/REST/FDPapi/src/main/resources/CardService.wsdl").toURI().toURL();
//          wsdl_url = new File(wsdlUrl).toURI().toURL();

      System.out.println("URL: " + wsdl_url);
    } catch (MalformedURLException e) {
      java.util.logging.Logger.getLogger(CardService_Service.class.getName())
          .log(java.util.logging.Level.INFO,
              "Can not initialize the default wsdl from {0}",
              wsdl_url);

    }

    cService = new CardService_Service(wsdl_url,
        new QName("http://www.firstdata.pl/wdx/business/card/v5/", "CardService"));

    cardService = cService.getCardServicePort();

    System.out.println("FDPProxyController - konstruktor wykonany, serwis utworzony" + cardService.toString());

  }

//Właściwe metody REST

  @PostMapping(FDPRestURIConstants.ACC_MNGMT)
  @Consumes(MediaType.APPLICATION_JSON)
  public OperationResult accountManagement(@RequestBody AccountManagementRequest request) {
    System.out.println("Metoda: " + FDPRestURIConstants.ACC_MNGMT);
    OperationResult result = cardService.accountManagement(request);
    System.out.println("WdxResponseCode: " + result.getWdxResponseCode());
    System.out.println("WdxMessageId: " + result.getWdxMessageId());
    System.out.println("ResponseDate: " + result.getResponseDate());
    System.out.println("ResponseTime: " + result.getResponseTime());
    System.out.println("Odp: " + result.toString());
    return result;
  }

  @PostMapping(FDPRestURIConstants.CARD_ISS)
  @Consumes(MediaType.APPLICATION_JSON)
  public OperationResult cardIssuing(@RequestBody CardIssuingRequest request) {
    System.out.println("Metoda: " + FDPRestURIConstants.CARD_ISS);
    //OperationResult result = cardService.cardIssuing(request);
    CardIssuingResponse result = cardService.cardIssuing(request);
    System.out.println("WdxResponseCode: " + result.getWdxResponseCode());
    System.out.println("WdxMessageId: " + result.getWdxMessageId());
    System.out.println("ResponseDate: " + result.getResponseDate());
    System.out.println("ResponseTime: " + result.getResponseTime());
    System.out.println("ExpDate: " + result.getCardExpiryDate());
    System.out.println("CardNumber: " + result.getCardNumber());
    System.out.println("Odp: " + result.toString());
    return result;
  }

  @PostMapping(FDPRestURIConstants.CARD_BIND)
  @Consumes(MediaType.APPLICATION_JSON)
  public OperationResult binding(@RequestBody CardAccountBindingRequest request) {
    System.out.println("Metoda: " + FDPRestURIConstants.CARD_BIND);
    OperationResult result = cardService.cardAccountBinding(request);
    System.out.println("WdxResponseCode: " + result.getWdxResponseCode());
    System.out.println("WdxMessageId: " + result.getWdxMessageId());
    System.out.println("ResponseDate: " + result.getResponseDate());
    System.out.println("ResponseTime: " + result.getResponseTime());
   System.out.println("Odp: " + result.toString());
    return result;
  }

  @PostMapping(FDPRestURIConstants.CARD_STATUS)
  @Consumes(MediaType.APPLICATION_JSON)
  public OperationResult cardStatus(@RequestBody CardStatusChangeRequest request) {
    System.out.println("Metoda: " + FDPRestURIConstants.CARD_STATUS);
    OperationResult result = cardService.changeCardStatus(request);
    System.out.println("WdxResponseCode: " + result.getWdxResponseCode());
    System.out.println("WdxMessageId: " + result.getWdxMessageId());
    System.out.println("ResponseDate: " + result.getResponseDate());
    System.out.println("ResponseTime: " + result.getResponseTime());
    System.out.println("Odp: " + result.toString());
    return result;
  }


}
