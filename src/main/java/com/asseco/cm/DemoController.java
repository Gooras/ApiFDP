package com.asseco.cm;

import com.asseco.cm.callback.ClientKeyStorePasswordCallback;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.Client;


import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
//import com.asseco.cm.debug.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.http.MediaType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.firstdata.wdx.business.card.AccountManagementRequest;
import pl.firstdata.wdx.business.card.BlockStatusCardRequest;
import pl.firstdata.wdx.business.card.CardAccountBindingRequest;
import pl.firstdata.wdx.business.card.CardActivationRequest;
import pl.firstdata.wdx.business.card.CardIssuingRequest;
import pl.firstdata.wdx.business.card.CardIssuingResponse;
import pl.firstdata.wdx.business.card.CardStatus;
import pl.firstdata.wdx.business.card.CardStatusChangeRequest;
import pl.firstdata.wdx.business.card.CrtaResponse;
import pl.firstdata.wdx.business.card.LimitsData;
import pl.firstdata.wdx.business.card.ObjectFactory;
import pl.firstdata.wdx.business.card.ReadCrtaRequest;
import pl.firstdata.wdx.business.card.ReadLimitsRequest;
import pl.firstdata.wdx.business.card.ReadLimitsResponse;
import pl.firstdata.wdx.business.card.SetLimitsRequest;
import pl.firstdata.wdx.business.card.v5.CardService;
import pl.firstdata.wdx.business.card.v5.CardService_Service;
import pl.firstdata.wdx.business.card.v5.OperationResult;
import com.asseco.cm.EmpRestURIConstants;

@RestController
@Lazy
@RequestMapping("/demo")
public class DemoController {

//@Autowired
//public static Config conf;

  //Start parametry
  @Autowired
  @Value("${ws.fdp.address}")
  public static String wsAddress;

  @Value("${ws.fdp.address.local}")
  public String wsAddressLocal;

  @Value("${ws.fdp.address.127}")
  public String wsAddress127;

//  @Autowired
  @Value("${ws.fdp.address.name}")
  public static String wsAddressName; // = new Config().getWsAddress();
  //Koniec parametry

  @Value("${wsdl.url}")
  public String wsdlUrl;

  public static URL WSDL_LOCATION;
  public static URL wsdl_url;

  @Autowired
  Config conf;

  CardService_Service cService;
  CardService cardService;
  Client client;
  Endpoint endpoint;

//  @Autowired
//  CardService cs;

  static {
    System.out.println("Static "+wsAddressName);
    //System.out.println("Autowired: " + conf.getWsAddress());
  }

  public DemoController() {
    try {
      System.out.println("DemoController - konstruktor");
      System.out.println("Url1: " + wsdlUrl);
      System.out.println("Url2: " + wsAddressName);
      //      wsdl_url = new URL("CardService.wsdl");
//      wsdl_url = new File("src/main/resources/CardService.wsdl").toURI().toURL();
//      wsdl_url = new File("/WEB-INF/classes/CardService.wsdl").toURI().toURL();
//      wsdl_url = new File("C:/app/wildfly-14.0.1.Final/bin/CardService.wsdl").toURI().toURL();
//mock bez WSS
//      wsdl_url = new File("C:/Users/Grzegorz.Gora/Desktop/REST/FDPapi/src/main/resources/CardService.wsdl").toURI().toURL();
//mock z WSS
      wsdl_url = new File(
          "C:/Users/Grzegorz.Gora/Desktop/REST/FDPapi/src/main/resources/CardServiceWSSMock.wsdl")
          .toURI().toURL();

//          wsdl_url = new File(wsdlUrl).toURI().toURL();

      System.out.println("Url2: " + wsdl_url);
    } catch (MalformedURLException e) {
      java.util.logging.Logger.getLogger(CardService_Service.class.getName())
          .log(java.util.logging.Level.INFO,
              "Can not initialize the default wsdl from {0}",
              wsdl_url);

    }
//    CardService_Service cService = new CardService_Service(wsdl_url, //WSDL_LOCATION,

    //wsdl_url = ClassLoader.getSystemResource("CardServiceWSSMock.wsdl");
    //System.out.println("wsdl_url "+wsdl_url);

    System.out.println("cService");
    //inicjowanie konkretnym, innym niż domyślny plikiem wsdl
    cService = new CardService_Service(wsdl_url, //WSDL_LOCATION,
        new QName("http://www.firstdata.pl/wdx/business/card/v5/", "CardService"));
    //domyślny konstruktor - jest domyślna lokalizacja pliku:
    //                  wsdlLocation = "file:src/main/resources/CardService.wsdl",
    //cService = new CardService_Service();

//    CardService cardService = cService.getCardServicePort();
    System.out.println("cardService");
    cardService = cService.getCardServicePort();

    System.out.println("DemoController - interceptory Start");
    client = (Client) cardService;

//    client.getInInterceptors().add(new LoggingInInterceptor());
//    endpoint = client.getEndpoint();
//    endpoint.getInInterceptors().add(new LoggingInInterceptor());

    Map<String, Object> incomingProps = new HashMap<String, Object>();
    incomingProps.put(WSHandlerConstants.ACTION,
        WSHandlerConstants.TIMESTAMP + " " + WSHandlerConstants.SIGNATURE + " "
            + WSHandlerConstants.ENCRYPT);
    incomingProps.put(WSHandlerConstants.SIG_PROP_FILE, "clientKeyStore.properties");
    incomingProps.put(WSHandlerConstants.DEC_PROP_FILE, "clientKeyStore.properties");
    incomingProps
        .put(WSHandlerConstants.PW_CALLBACK_CLASS, ClientKeyStorePasswordCallback.class.getName());
    incomingProps.put(WSHandlerConstants.ALLOW_RSA15_KEY_TRANSPORT_ALGORITHM, "true");

    WSS4JInInterceptor wssIncoming = new WSS4JInInterceptor(incomingProps);
    System.out.println("DemoController - interceptory do logowania - In");
    PrintWriter writerIn = null;
    try {
      writerIn = new PrintWriter(new File("src/main/resources/FDPProxyIn.log"));
      //writerIn = new PrintWriter(new File("C:/Users/Grzegorz.Gora/Desktop/REST/FDPapi/src/main/resources/FDPProxyIn.log"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    //writer1.write("Like Java, Spring, Hibernate, Android, PHP etc.");
    //writer1.flush();
    //writer1.close();
    client.getInInterceptors().add(new LoggingInInterceptor(writerIn)); //przed odszyfrowaniem
    client.getInInterceptors().add(wssIncoming);
    //client.getInInterceptors().add(new LoggingInInterceptor()); //po odszyfrowaniu?
//    ((Client) cardService).getInInterceptors().add(wssIncoming);

    Map<String, Object> outgoingProps = new HashMap<String, Object>();

    outgoingProps.put(WSHandlerConstants.ACTION,
        WSHandlerConstants.SIGNATURE + " " + WSHandlerConstants.ENCRYPT);
    outgoingProps.put(WSHandlerConstants.SIG_PROP_FILE, "clientKeyStore.properties");
    outgoingProps.put(WSHandlerConstants.ENC_PROP_FILE, "clientKeyStore.properties");
    outgoingProps
        .put(WSHandlerConstants.PW_CALLBACK_CLASS, ClientKeyStorePasswordCallback.class.getName());

//to działa z FDP
//        outgoingProps.put(WSHandlerConstants.USER, "nsb");
//to działa z mockiem
    outgoingProps.put(WSHandlerConstants.USER, "fdp");
    outgoingProps.put(WSHandlerConstants.ENCRYPTION_USER, "fdp");
    outgoingProps.put(WSHandlerConstants.SIGNATURE_PARTS,
        "{Element}{http://schemas.xmlsoap.org/soap/envelope/}Body");
    outgoingProps.put(WSHandlerConstants.ENCRYPTION_PARTS,
        "{Element}{http://www.w3.org/2000/09/xmldsig#}Signature;{Content}{http://schemas.xmlsoap.org/soap/envelope/}Body");
    outgoingProps.put(WSHandlerConstants.ENC_SYM_ALGO, WSConstants.AES_128);
//    outgoingProps.put(WSHandlerConstants.ALLOW_RSA15_KEY_TRANSPORT_ALGORITHM, "true");

    WSS4JOutInterceptor wssOutgoing = new WSS4JOutInterceptor(outgoingProps);
    System.out.println("DemoController - interceptory do logowania - Out");
    PrintWriter writerOut = null;
    try {
      writerOut = new PrintWriter(new File("src/main/resources/FDPProxyOut.log"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    client.getOutInterceptors().add(new LoggingOutInterceptor(writerOut));
    client.getOutInterceptors().add(wssOutgoing);
    //PrintWriter writer = new PrintWriter()
    //client.getOutInterceptors().add(new LoggingOutInterceptor());
    //client.getOutInterceptors().remove(wssOutgoing);

    if (client.getOutInterceptors().contains(wssOutgoing)) {
      System.out.println("Jest wssOut");
    } else {
      System.out.println("Nie ma wssOut");
    }

    System.out.println("DemoController - interceptory do logowania");
    //client.getInInterceptors().add(new MyLoggingInInterceptor());

    System.out.println(
        "DemoController - konstruktor wykonany, serwis utworzony" + cardService.toString());

  }

/*
  //  @Autowired
  static {
    URL url = null;
    try {
      System.out.println("Url");
      url = new URL("http://172.20.22.248:8088/mockCardServiceBinding?WSDL");
      System.out.println("Url: " + url);
    } catch (MalformedURLException e) {
      java.util.logging.Logger.getLogger(CardService_Service.class.getName())
          .log(java.util.logging.Level.INFO,
              "Can not initialize the default wsdl from {0}",
              "http://172.20.22.248:8088/mockCardServiceBinding?WSDL");
//      "file:src/main/resources/CardService.wsdl");
    }
    WSDL_LOCATION = url;
  }

  //  CardService_Service service = new CardService_Service(new URL("file:src/main/resources/CardService.wsdl"), new QName("http://localhost:8088/CardServiceBinding/"));;
  //CardService_Service service = new CardService_Service(WSDL_LOCATION, new QName("http://localhost:8088/mockCardServiceBinding/"));;
//  Service service = Service.create(WSDL_LOCATION, new QName("http://localhost:8088/mockCardServiceBinding/"));
//  CardService_Service cService = (CardService_Service) service;
//  CardService_Service cService = new CardService_Service();
  public static URL wsdl_url;

  static {
    try {
      System.out.println("Url2");
//      wsdl_url = new URL("CardService.wsdl");
//      wsdl_url = new File("src/main/resources/CardService.wsdl").toURI().toURL();
//      wsdl_url = new File("/WEB-INF/classes/CardService.wsdl").toURI().toURL();
//      wsdl_url = new File("C:/app/wildfly-14.0.1.Final/bin/CardService.wsdl").toURI().toURL();
      wsdl_url = new File("C:/Users/Grzegorz.Gora/Desktop/REST/FDPapi/src/main/resources/CardService.wsdl").toURI().toURL();
//          wsdl_url = new File(wsdlUrl).toURI().toURL();

      System.out.println("Url2: " + wsdl_url);
    } catch (MalformedURLException e) {
      java.util.logging.Logger.getLogger(CardService_Service.class.getName())
          .log(java.util.logging.Level.INFO,
              "Can not initialize the default wsdl from {0}",
              wsdl_url);

    }
  }

  CardService_Service cService = new CardService_Service(wsdl_url, //WSDL_LOCATION,
      new QName("http://www.firstdata.pl/wdx/business/card/v5/", "CardService"));
//  CardService_Service cService = new CardService_Service(wsdl_url,
//    new QName("http://www.firstdata.pl/wdx/business/card/v5/"));
//  CardService_Service cService = new CardService_Service(wsdl_url,
//      new QName("http://172.20.22.248:8088/mockCardServiceBinding/"));

  CardService cardService = cService.getCardServicePort();
*/

  /*public DemoController() throws MalformedURLException {
    service = new CardService_Service(new URL("file:src/main/resources/CardService.wsdl"), new QName("http://localhost:8088/CardServiceBinding/"));
  }
*/
  public CardStatusChangeRequest getCardStatus() {
    CardStatusChangeRequest req = new CardStatusChangeRequest();
    try {
      req.setExpDate(FDPApiTools.getXMLDate(new Date()));
    } catch (DatatypeConfigurationException e) {
      e.printStackTrace();
    }
    req.setRegionCode("region code");
    req.setCardStatus("status karty");
    req.setCardNumber("numer karty");

    System.out.println("getCardStatus!");

    return req;
  }

  @RequestMapping(value = "/xml/getCardStatusRequest", produces = MediaType.APPLICATION_XML_VALUE)
  public CardStatusChangeRequest getCardStatusRequestXML() {
    System.out.println("getCardStatusRequestXML!");

    return getCardStatus();
  }

  @RequestMapping(value = "/getCardStatusRequest", produces = MediaType.APPLICATION_JSON_VALUE)
  public CardStatusChangeRequest getCardStatusRequest() {
    System.out.println("getCardStatusRequest!");

    return getCardStatus();
  }

  public CardAccountBindingRequest getBinding() {
    CardAccountBindingRequest req = new CardAccountBindingRequest();
    req.setActionType("action type");
    req.setBankAccountId("bank account 123");
    req.setCardNumber("numer karty");
    req.setMaster(Boolean.TRUE);
    System.out.println("getBinding!");

    return req;
  }

  @RequestMapping(value = "/xml/getBindingRequest", produces = MediaType.APPLICATION_XML_VALUE)
  public CardAccountBindingRequest getBindingRequestXML() {
    System.out.println("getBindingRequestXML!");

    return getBinding();
  }

  @RequestMapping(value = "/getBindingRequest", produces = MediaType.APPLICATION_JSON_VALUE)
  public CardAccountBindingRequest getBindingRequest() {
    System.out.println("getBindingRequest!");

    return getBinding();
  }

  public CardIssuingRequest getCardIssuing() throws DatatypeConfigurationException {
    CardIssuingRequest req = new CardIssuingRequest();
    req.setApplicationCardId("1234");
    req.setActionType("ADD");
    req.setAddressLine1("Addr1");
    req.setAddressLine2("Addr2");
    req.setAddressLine3("Addr3");
    req.setCity("Rzeszów");
    req.setCountryCode("PL");
    req.setFirstName("Grzegorz");
    req.setLastName("Góra");
    req.setMiddleName("MiddleName");
    req.setPostCode("35-000");
    req.setTemplateId("TemplateId");
    req.setCardNumber("Numer karty 1");
    req.setCourier(true);
    req.setDateOfBirth("2020-03-03");
    req.setEmbossedCompanyName("Company name");
    req.setEmbossedName("Embossed Name");
    req.setExpress(false);
    req.setExpress(new Boolean("0"));
    req.setIssueType("Issue Type");
    req.setMaidenName("Maiden name");
    req.setExpiryDate("2021-04-04");
    req.setNationalId("polskie");
    req.setPlasticId("plastic ID");
    req.setPhoneNumber("123-456-789");

    System.out.println("getIssuing!");

    return req;
  }

  @RequestMapping(value = "/xml/getIssuingRequest", produces = MediaType.APPLICATION_XML_VALUE)
  public CardIssuingRequest getCardIssuingRequestXML() {
    CardIssuingRequest req = null;
    try {
      req = getCardIssuing();
    } catch (DatatypeConfigurationException e) {
      e.printStackTrace();
    }
    System.out.println("getIssuingRequestXML!");

    return req;
  }

  @RequestMapping(value = "/getIssuingRequest", produces = MediaType.APPLICATION_JSON_VALUE)
 public CardIssuingRequest getCardIssuingRequest() throws DatatypeConfigurationException {
    CardIssuingRequest req = null;
    try {
      req = getCardIssuing();
    } catch (DatatypeConfigurationException e) {
      e.printStackTrace();
    }
    System.out.println("getIssuingRequest!");

    return req;
  }

  @RequestMapping(value = "/getAccountRequest", produces = MediaType.APPLICATION_JSON_VALUE)
  //@RequestMapping(value = "/getAccountRequest", produces = MediaType.APPLICATION_XML_VALUE)
  public AccountManagementRequest getAccountRequest() {
    AccountManagementRequest req = new AccountManagementRequest();
/*    req.setAccountNumber("1234");
    req.setAccountType("AccountType");
    req.setActionType("ADD");
    req.setAddressLine1("Addr1");
    //req.setAddressLine2("Addr2");
    req.setAddressLine3("Addr3");
    req.setBalance(new Long(1234));
    req.setBankAccountId("ID1234");
    req.setBankOwnerId("OwnerID1234");
    req.setBranch("Branch");
    req.setCity("Rzeszów");
    req.setCountryCode("PL");
    req.setCurrencyCode("PLN");
    req.setFirstName("Grzegorz");
    req.setLastName("Góra");
    req.setLK("Co to?");
    req.setMiddleName("MiddleName");
    req.setPostCode("35-000");
    req.setSubtype("Subtype");
    req.setTemplateId("TemplateId");
*/
    System.out.println("getAccountRequest!");

    return req;
  }

  @RequestMapping("/hello")
  public String hello() {
    String wynik = "Hello! Wykonanie ok. ";

    System.out.println("Hello!");
    System.out.println("Url1: " + wsdlUrl);
    System.out.println("Url2: " + wsAddressName);

    return wynik;
  }

  @PostMapping("/post")
  public String post(@RequestBody CardStatusChangeRequest cardStatus) {
    System.out.println("Url2.1: " + wsdlUrl);
    System.out.println("Url2.1: " + cardStatus.getCardNumber());
    OperationResult result = cardService.changeCardStatus(cardStatus);
    //CardIssuingRequest cardIssuing = new CardIssuingRequest();
    //cardIssuing.
    //CardIssuingResponse cardIssuingResponse = cardService.cardIssuing(CardIssuingRequest cardIssuing);
    System.out.println("Odp: " + result.getWdxResponseCode());
    System.out.println("Odp: " + result.getWdxMessageId());
    System.out.println("Odp: " + result.getResponseDate());
    System.out.println("Odp: " + result.toString());
    return "getTest";
  }

  @GetMapping("/xml/get")
  @Produces(MediaType.APPLICATION_XML_VALUE)
//  @Consumes(MediaType.APPLICATION_XML_VALUE)
  public CardStatusChangeRequest XMLget() {
    System.out.println("Url2.1: " + wsdlUrl);
    CardStatusChangeRequest cardStatus = new CardStatusChangeRequest();
    cardStatus.setCardNumber("123");
    cardStatus.setCardStatus("Nowa");
    cardStatus.setRegionCode("35-330");
    try {
      cardStatus.setExpDate(FDPApiTools.getXMLDate(new Date()));
    } catch (DatatypeConfigurationException e) {
      e.printStackTrace();
    }
    System.out.println("Url2.1: " + cardStatus.getCardNumber());
    return cardStatus;
  }
  //@RequestMapping(value = "/xml/post", consumes = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
  @PostMapping("/xml/post")
  @POST
  @Consumes(MediaType.APPLICATION_XML_VALUE)
  public CardStatusChangeRequest XMLpost(@RequestBody CardStatusChangeRequest cardStatus) {
    System.out.println("Url2.1: " + wsdlUrl);
    System.out.println("Url2.1: " + cardStatus.getCardNumber());
    OperationResult result = cardService.changeCardStatus(cardStatus);
    System.out.println("Odp: " + result.getWdxResponseCode());
    System.out.println("Odp: " + result.getWdxMessageId());
    System.out.println("Odp: " + result.getResponseDate());
    System.out.println("Odp: " + result.toString());
    return cardStatus;
  }

  @GetMapping(EmpRestURIConstants.CREATE_EMP+"/{id}")
  @Consumes(MediaType.APPLICATION_XML_VALUE)
public String getTest(@PathVariable String id) {
//    System.out.println(
//        "DemoController - serwis Autowired dostępny" + cs.toString());
  System.out.println("Url2.1: " + wsdlUrl);
    System.out.println("GetTest 0");
    System.out.println("Adres2: " + wsAddressName);
    //System.out.println("Adres3: " + new Config().getWsAddress());
    System.out.println("AD1 + "+wsAddressLocal);
    System.out.println("AD2 + "+wsAddress127);
    System.out.println("AD3 + "+conf.getWsAddress());


    ReadCrtaRequest crtaRequest = new ReadCrtaRequest();
    System.out.println("GetTest 1");
  crtaRequest.setCardNumber(id);
    System.out.println("GetTest 2 "+ id);
    CrtaResponse crtaResponse = cardService.readCrta(crtaRequest);
    System.out.println("GetTest 3");
  System.out.println("Odp: " + crtaResponse.getWdxResponseCode());
  System.out.println("Odp: " + crtaResponse.getWdxMessageId());
  System.out.println("Odp: " + crtaResponse.getResponseDate());
  System.out.println("Odp: " + crtaResponse.toString());
    return "getTest";
}
    @RequestMapping("/test")
  public String test(@RequestParam("cardNo") String cardNumber, @RequestParam("testKom") String message) {
    String wynik = "Wykonanie ok. ";

    System.out.println("Przekazane parametry: "+cardNumber+" "+message);

      CardActivationRequest activateCard = new CardActivationRequest();
      activateCard.setCardNumber(cardNumber);
      OperationResult result = cardService.activateCard(activateCard);
      //getDate to prywatna metoda - do implementacji później
      //activateCard.setExpiryDate(getDate(new Date()));
      System.out.println("Odebrana odp: "+ result.getWdxMessageId());

    if (Integer.valueOf(cardNumber) == 1)
    {
      wynik = wynik + "Testowy wynik "+cardNumber+ " "+message;
    }
    else
      wynik = wynik + "Inny testowy wynik "+cardNumber+ " "+message;

      switch (cardNumber) {
        case "1":
          wynik = wynik + "\n" + wsAddress;
          break;
        case "2":
          wynik = wynik + "\n" + wsAddressLocal;
          break;
        case "3":
          wynik = wynik + "\n" + wsAddress127;
          break;
        case "4":
          wynik = wynik + "\n" + wsAddressName;
          break;
      }

      return wynik;

  }

//  @RequestMapping(value = "/limits/read", produces = MediaType.APPLICATION_JSON_VALUE)
  @RequestMapping("/limits/read")
  @Produces(MediaType.APPLICATION_JSON_VALUE)
  public ReadLimitsResponse readLimits(@RequestParam("cardNo") String cardNumber)
      throws DatatypeConfigurationException {
    String wynik = "Read Limits - wykonanie ok. ";

    System.out.println("Przekazane parametry: "+cardNumber);

    ReadLimitsRequest readLimit = new ReadLimitsRequest();
    readLimit.setCardNumber(cardNumber);
    OperationResult result = cardService.readLimits(readLimit);
    ReadLimitsResponse response = cardService.readLimits(readLimit);
    //getDate to prywatna metoda - do implementacji później
    //activateCard.setExpiryDate(getDate(new Date()));
    Date data = FDPApiTools.getDate(result.getResponseDate());
    System.out.println("Odebrana odp: "+ result.getWdxMessageId());

    if (Integer.valueOf(cardNumber) == 1)
    {
      wynik = wynik + "Testowy wynik "+cardNumber;
    }
    else
      wynik = wynik + "Inny testowy wynik "+cardNumber;

    switch (cardNumber) {
      case "1":
        wynik = wynik + "\n" + wsAddress;
        break;
      case "2":
        wynik = wynik + "\n" + wsAddressLocal;
        break;
      case "3":
        wynik = wynik + "\n" + wsAddress127;
        break;
      case "4":
        wynik = wynik + "\n" + wsAddressName;
        break;
    }

    return response;

  }

//  @RequestMapping(value = "/xml/limits/read", produces = MediaType.APPLICATION_XML_VALUE)
  @RequestMapping(value = "/xml/limits/read")
  @Produces(MediaType.APPLICATION_JSON_VALUE)
  public ReadLimitsResponse readXMLLimits(@RequestParam("cardNo") String cardNumber)
      throws DatatypeConfigurationException {
    String wynik = "Read Limits - wykonanie ok. ";

    System.out.println("Przekazane parametry: "+cardNumber);

    ReadLimitsRequest readLimit = new ReadLimitsRequest();
    readLimit.setCardNumber(cardNumber);
    OperationResult result = cardService.readLimits(readLimit);
    ReadLimitsResponse response = cardService.readLimits(readLimit);
    //getDate to prywatna metoda - do implementacji później
    //activateCard.setExpiryDate(getDate(new Date()));
    Date data = FDPApiTools.getDate(result.getResponseDate());
    System.out.println("Odebrana odp: "+ result.getWdxMessageId());

    if (Integer.valueOf(cardNumber) == 1)
    {
      wynik = wynik + "Testowy wynik "+cardNumber;
    }
    else
      wynik = wynik + "Inny testowy wynik "+cardNumber;

    switch (cardNumber) {
      case "1":
        wynik = wynik + "\n" + wsAddress;
        break;
      case "2":
        wynik = wynik + "\n" + wsAddressLocal;
        break;
      case "3":
        wynik = wynik + "\n" + wsAddress127;
        break;
      case "4":
        wynik = wynik + "\n" + wsAddressName;
        break;
    }

    return response;

  }

  @RequestMapping(value = "/limits/set", produces = MediaType.APPLICATION_XML_VALUE)
  //@RequestMapping(value = "/limits/set")
  //@Produces(MediaType.APPLICATION_XML)
  public OperationResult setLimits(@RequestParam("cardNo") String cardNumber, @RequestParam("AtmCcaLmt") long AtmCcaLmt)
      throws DatatypeConfigurationException {
    String wynik = "Set Limits - wykonanie ok. ";

    System.out.println(wynik + "Przekazane parametry: "+cardNumber);

    SetLimitsRequest setLimit = new SetLimitsRequest();
    setLimit.setCardNumber(cardNumber);
    LimitsData limitsData = new LimitsData();
    limitsData.setAtmCcaLmt(AtmCcaLmt);
    limitsData.setAtmDepCrLmt((long) 2);
    limitsData.setAtmOfflCcaLmt((long) 3);
    setLimit.setLimitsData(limitsData);
    System.out.println(wynik + "Serwis: "+cardService.toString());
    OperationResult result = cardService.setLimits(setLimit);
    //getDate to prywatna metoda - do implementacji później
    //activateCard.setExpiryDate(getDate(new Date()));
    Date data = FDPApiTools.getDate(result.getResponseDate());
    System.out.println("Odebrana odp: "+ result.getWdxMessageId());

    if (Integer.valueOf(cardNumber) == 1)
    {
      wynik = wynik + "Testowy wynik "+cardNumber;
    }
    else
      wynik = wynik + "Inny testowy wynik "+cardNumber;

    switch (cardNumber) {
      case "1":
        wynik = wynik + "\n" + wsAddress;
        break;
      case "2":
        wynik = wynik + "\n" + wsAddressLocal;
        break;
      case "3":
        wynik = wynik + "\n" + wsAddress127;
        break;
      case "4":
        wynik = wynik + "\n" + wsAddressName;
        break;
    }

    return result;

  }

/*  @RequestMapping("/block-card")
  //public void blockCard(@RequestParam("cardNo") String cardNumber, @RequestParam("expDate") String expiryDate) {
  //public String BlockStatusCardRequest blockCard(@RequestParam("cardNo") String cardNumber, @RequestParam("expDate") String expiryDate) {
  public BlockStatusCardRequest blockCard(@RequestParam("cardNo") String cardNumber) {

    BlockStatusCardRequest req = new BlockStatusCardRequest();
    req.setCardNumber(cardNumber);
    OperationResult result;
    result = cardService.blockCard(req);

    System.out.println(result);

    System.out.println(result.getWdxMessageId()+" "+result.getWdxResponseCode());

    //return "Wykonanie ok "+result.getWdxResponseCode()+" "+result.getWdxMessageId();
    //return result;
    return req;
  }
*/
/*
  @Value("${ws.fdp.address}")
  public String wsAddress;

  @Value("${ws.fdp.address.local}")
  public String wsAddressLocal;

  @Value("${ws.fdp.address.127}")
  public String wsAddress127;

  @Value("${ws.fdp.address.name}")
  public String wsAddressName;

  @RequestMapping("/block")
  //public void blockCard(@RequestParam("cardNo") String cardNumber, @RequestParam("expDate") String expiryDate) {
  //public String BlockStatusCardRequest blockCard(@RequestParam("cardNo") String cardNumber, @RequestParam("expDate") String expiryDate) {
  public BlockStatusCardRequest block(@RequestParam("cardNo") String cardNumber)  throws MalformedURLException {

    CardService cardService;
    URL url = new URL(wsAddress);

    switch (cardNumber) {
      case "1":
        url = new URL(wsAddress);
        break;
      case "2":
        url = new URL(wsAddressLocal);
        break;
      case "3":
        url = new URL(wsAddress127);
        break;
      case "4":
        url = new URL(wsAddressName);
        break;
    }

    CardService_Service service = new CardService_Service(url);

    cardService = service.getCardServicePort();


    BlockStatusCardRequest req = new BlockStatusCardRequest();
    req.setCardNumber(cardNumber);
    OperationResult result;
    result = cardService.blockCard(req);

    System.out.println(result);

    System.out.println(result.getWdxMessageId()+" "+result.getWdxResponseCode());

    //return "Wykonanie ok "+result.getWdxResponseCode()+" "+result.getWdxMessageId();
    //return result;
    return req;
  }
*/
}
