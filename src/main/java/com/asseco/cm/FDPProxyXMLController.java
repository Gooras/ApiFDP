package com.asseco.cm;

import static com.asseco.cm.FDPApiTools.myLog;

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
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import javax.xml.namespace.QName;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.firstdata.wdx.business.card.AccountManagementRequest;
import pl.firstdata.wdx.business.card.CardAccountBindingRequest;
import pl.firstdata.wdx.business.card.CardIssuingRequest;
import pl.firstdata.wdx.business.card.CardIssuingResponse;
import pl.firstdata.wdx.business.card.CardStatusChangeRequest;
import pl.firstdata.wdx.business.card.v5.CardService;
import pl.firstdata.wdx.business.card.v5.CardService_Service;
import pl.firstdata.wdx.business.card.v5.OperationResult;
import com.asseco.cm.FDPApiTools;


@RestController
@RequestMapping("/api/xml")
public class FDPProxyXMLController {

  @Autowired
  Config conf;
  @Autowired
  CardService cardService;
  @Autowired
  Client client;

  public static URL wsdl_url;

  CardService_Service cService;

  private Logger logger = LoggerFactory.getLogger(FDPProxyXMLController.class);

  @Bean
  public CardService cardService() throws MalformedURLException {
    System.out.println(logger.getClass().getName());
    System.out.println(logger.isDebugEnabled());

    //TODO: zgłosić wyjątek, gdy url nieprawidłowy
    URL url = new URL(conf.getWsAddress());
    //url = conf.getWsdl();
    System.out.println("Bean CardService "+url);
    logger.debug("(Bean) (CardService) Serwis utworzony "+url);

    //TODO: zgłosić wyjątek, gdy nie uda się stworzyć serwisu? Da się to jakoś sprawdzić?
    CardService_Service service = new CardService_Service(url);
    CardService cardService = service.getCardServicePort();

    return service.getCardServicePort();
  }

  @Bean
  public Client client() {
    System.out.println(logger.getClass().getName());
    System.out.println(logger.isDebugEnabled());

    Client cli = (Client) cardService;
    System.out.println("Bean Client "+cli.toString());
    logger.debug("(Bean) Klient utworzony");
    //TODO - interceptory do logowania, interceptory do WSS jak włączony parametr
    addInterceptors(cli);
    logger.debug("(Bean) Interceptory włączone");
    return cli;
  }

  private void addInterceptors(Client cli) {

    if (false) {

    if (conf.getLoggingInEnabled()) {
      myLog("DemoController - interceptory do logowania - In");
      LoggingInInterceptor loggerIn = new LoggingInInterceptor();
        PrintWriter writerIn = null;
        try {
          writerIn = new PrintWriter(new File("src/main/resources/FDPProxyIn.log"));
          //writerIn = new PrintWriter(new File("C:/Users/Grzegorz.Gora/Desktop/REST/FDPapi/src/main/resources/FDPProxyIn.log"));
        } catch (FileNotFoundException e) {
          logger.error(e.getLocalizedMessage());
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
          System.out.println("Path1: "+file.getAbsolutePath());
          System.out.println("Writer: "+file.getCanonicalPath());
          writerOut = new PrintWriter(file);
          file = new File(fileName);
          System.out.println("Path2: "+file.getAbsolutePath());
          System.out.println("Writer: "+file.getCanonicalPath());
          writerOut = new PrintWriter(file);
          file = new File("../log/"+fileName);
          System.out.println("Path3: "+file.getAbsolutePath());
          System.out.println("Writer: "+file.getCanonicalPath());
          file = new File("./log/"+fileName);
          System.out.println("Path4: "+file.getAbsolutePath());
          System.out.println("Writer: "+file.getCanonicalPath());
          writerOut = new PrintWriter(file);

//          writerOut = new PrintWriter(new File("src/main/resources/FDPProxyOut.log"));
        } catch (FileNotFoundException e) {
          logger.error(e.getLocalizedMessage());
          e.printStackTrace();
        } catch (IOException e) {
          logger.error(e.getLocalizedMessage());
          e.printStackTrace();
        }

        LoggingOutInterceptor loggerOut = new LoggingOutInterceptor(writerOut);
        cli.getOutInterceptors().add(loggerOut);
      }

    }//koniec warunku 1=0

  }

  // wyłączony Konstruktor - inicjalizacja serwisu FDP
  public void testFDPProxyXMLController() {
/*    try {
      System.out.println("FDPProxyXMLController - konstruktor");
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
*/
    wsdl_url = ClassLoader.getSystemResource("CardService.wsdl");
    System.out.println("wsdl: "+wsdl_url);
    //wsdl_url = getWsld();
    cService = new CardService_Service(wsdl_url,
        new QName("http://www.firstdata.pl/wdx/business/card/v5/", "CardService"));

    cardService = cService.getCardServicePort();

    System.out.println("FDPProxyXMLController - konstruktor wykonany, serwis utworzony" + cardService.toString());

  }

//Właściwe metody REST

  @RequestMapping(value = FDPRestURIConstants.ACC_MNGMT, consumes = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
  public OperationResult accountManagement(@RequestBody AccountManagementRequest request) {
    logger.debug("Metoda: " + FDPRestURIConstants.ACC_MNGMT);
    System.out.println("Metoda: " + FDPRestURIConstants.ACC_MNGMT);
    logger.debug("Request: " + request);
    OperationResult result = cardService.accountManagement(request);
    logger.debug("Response: " + result);
    System.out.println("WdxResponseCode: " + result.getWdxResponseCode());
    System.out.println("WdxMessageId: " + result.getWdxMessageId());
    System.out.println("ResponseDate: " + result.getResponseDate());
    System.out.println("ResponseTime: " + result.getResponseTime());
    System.out.println("Odp: " + result.toString());
    return result;
  }

  @RequestMapping(value = FDPRestURIConstants.CARD_ISS, consumes = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
  public OperationResult cardIssuing(@RequestBody CardIssuingRequest request) {
    logger.debug("Metoda: " + FDPRestURIConstants.CARD_ISS);
    System.out.println("Metoda: " + FDPRestURIConstants.CARD_ISS);
    //OperationResult result = cardService.cardIssuing(request);

    logger.debug("Request: " + request);
    logger.debug("Request (XMl): " + FDPApiTools.jaxbObjectToXML(request));
    System.out.println("Request (XMl): " + FDPApiTools.jaxbObjectToXML(request));
    CardIssuingResponse result = cardService.cardIssuing(request);
    logger.debug("Response: " + result);
    logger.debug("Response (XMl): " + FDPApiTools.jaxbObjectToXML(result));
    System.out.println("Response (XMl): " + FDPApiTools.jaxbObjectToXML(result));
    System.out.println("WdxResponseCode: " + result.getWdxResponseCode());
    System.out.println("WdxMessageId: " + result.getWdxMessageId());
    System.out.println("ResponseDate: " + result.getResponseDate());
    System.out.println("ResponseTime: " + result.getResponseTime());
    System.out.println("ExpDate: " + result.getCardExpiryDate());
    System.out.println("CardNumber: " + result.getCardNumber());
    System.out.println("Odp: " + result.toString());
    return result;
  }

  @RequestMapping(value = FDPRestURIConstants.CARD_BIND, consumes = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
  public OperationResult binding(@RequestBody CardAccountBindingRequest request) {
    logger.debug("Metoda: " + FDPRestURIConstants.CARD_BIND);
    System.out.println("Metoda: " + FDPRestURIConstants.CARD_BIND);
    logger.debug("Request: " + request);
    OperationResult result = cardService.cardAccountBinding(request);
    logger.debug("Response: " + result);
    System.out.println("WdxResponseCode: " + result.getWdxResponseCode());
    System.out.println("WdxMessageId: " + result.getWdxMessageId());
    System.out.println("ResponseDate: " + result.getResponseDate());
    System.out.println("ResponseTime: " + result.getResponseTime());
    System.out.println("Odp: " + result.toString());
    return result;
  }

  @RequestMapping(value = FDPRestURIConstants.CARD_STATUS, consumes = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
  public OperationResult cardStatus(@RequestBody CardStatusChangeRequest request) {
    logger.debug("Metoda: " + FDPRestURIConstants.CARD_STATUS);
    System.out.println("Metoda: " + FDPRestURIConstants.CARD_STATUS);
    logger.debug("Request: " + request);
    OperationResult result = cardService.changeCardStatus(request);
    logger.debug("Response: " + result);
    System.out.println("WdxResponseCode: " + result.getWdxResponseCode());
    System.out.println("WdxMessageId: " + result.getWdxMessageId());
    System.out.println("ResponseDate: " + result.getResponseDate());
    System.out.println("ResponseTime: " + result.getResponseTime());
    System.out.println("Odp: " + result.toString());
    return result;
  }

  @RequestMapping(value = FDPRestURIConstants.VERSION, consumes = MediaType.ALL_VALUE, method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
  public String getVersion() {
    logger.debug("Metoda: " + FDPRestURIConstants.VERSION+" ver: "+conf.getAppVersion());
    System.out.println("Metoda: " + FDPRestURIConstants.VERSION);
    System.out.println("Wersja: "+ conf.getAppVersion());

    System.out.println(logger.getClass().getName());
    System.out.println(logger.isDebugEnabled());

    logger.debug("Version: "+conf.getAppVersion());
    logger.info("Version: "+conf.getAppVersion());
    logger.error("Version: "+conf.getAppVersion());

    return "ver: "+conf.getAppVersion() + " logger: "+logger.getClass().getName()+" conf: "+conf.getGgTest();
  }

}
