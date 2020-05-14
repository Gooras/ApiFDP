package com.asseco.cm;

import java.io.StringWriter;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class FDPApiTools {

  @Autowired
  static Config conf;

  public static void myLog (String txt) {
//    if (conf.getDebugEnabled()){
      System.out.println(txt);
//    }
  }

  public static XMLGregorianCalendar getXMLDate(Date date) throws DatatypeConfigurationException {
    GregorianCalendar calendar = new GregorianCalendar();
    calendar.setTime(date);
    XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
    return xmlDate;
  }

  public static Date getDate(XMLGregorianCalendar date) throws DatatypeConfigurationException {
    if(date == null) {
      return null;
    }
      return date.toGregorianCalendar().getTime();
  }

  public static String jaxbObjectToXML(Object obj) {
    String xmlContent = new String();
    try
    {
      //Create JAXB Context
      JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
      System.out.println("JaxBContext: " + jaxbContext.toString());

      //Create Marshaller
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
      System.out.println("Marshaller: " + jaxbMarshaller.toString());

      //Required formatting??
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

      //Print XML String to Console
      StringWriter sw = new StringWriter();

      //Write XML to StringWriter
      jaxbMarshaller.marshal(obj, sw);

      //Verify XML Content
      xmlContent = sw.toString();
      System.out.println( xmlContent );

    } catch (JAXBException e) {
      e.printStackTrace();
    }
    return xmlContent;
  }

}
