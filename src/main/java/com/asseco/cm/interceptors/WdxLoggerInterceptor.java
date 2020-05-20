package com.asseco.cm.interceptors;

import java.io.IOException;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WdxLoggerInterceptor extends AbstractSoapInterceptor {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  // dodaje interceptor do odpowiedniej fazy, by logował wiadomość już po odszyfrowaniu
  public WdxLoggerInterceptor() {
    //super(Phase.USER_PROTOCOL);
    super(Phase.POST_PROTOCOL);
    System.out.println("WdxLoggerInterceptor");
    // Must run after the message has been decrypted:
    addAfter(WSS4JInInterceptor.class.getName());
    // Must run after SAAJ processing has provided the content in the SOAPMessage format:
    addAfter(SAAJInInterceptor.class.getName());
  }
/*  @Override
  public void handleMessage(Message message) throws Fault {
    // get the message from the SOAP body
    System.out.println("Wiad1: "+message);
    //System.out.println("Wiad1.0: "+FDPApiTools.jaxbObjectToXML(message));
    SOAPMessage soapMessage = (SOAPMessage) message.getContent(Message.class);
    //System.out.println("Wiad1.1: "+FDPApiTools.jaxbObjectToXML(soapMessage));
    System.out.println("Wiad1.2: "+soapMessage);
    ByteArrayOutputStream buf = new ByteArrayOutputStream();
    try {
      soapMessage.writeTo(buf);
    } catch (SOAPException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    String xmlAsString = buf.toString();
    System.out.println("Wiad2: "+xmlAsString);

// I teraz mozna z tym zrobic co sie chce
  }
*/

  @Override
  public void handleMessage(SoapMessage message) throws Fault {
    // get the message from the SOAP body
    System.out.println("Wiad1: "+message);
    //System.out.println("Wiad1.0: "+FDPApiTools.jaxbObjectToXML(message));
    SOAPMessage soapMessage = message.getContent(SOAPMessage.class);
    //System.out.println("Wiad1.1: "+FDPApiTools.jaxbObjectToXML(soapMessage));
    System.out.println("Wiad1.2: "+soapMessage);
    ByteArrayOutputStream buf = new ByteArrayOutputStream();
    try {
      soapMessage.writeTo(buf);
    } catch (SOAPException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    String xmlAsString = buf.toString();
    System.out.println("Wiad2: "+xmlAsString);

// I teraz mozna z tym zrobic co sie chce

  }
}
/*
public WdxLoggerOutInterceptor() {
    super(Phase.MARSHAL);
    addAfter(BareOutInterceptor.class.getName());
}

 */