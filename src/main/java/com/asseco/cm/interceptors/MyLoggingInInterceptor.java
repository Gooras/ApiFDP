package com.asseco.cm.interceptors;


import java.util.concurrent.TimeUnit;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.io.CachedOutputStream;
import org.springframework.util.xml.TransformerUtils;

/**
   * A simple logging handler which outputs the bytes of the message to the
   * Logger.
   * @deprecated use the logging module rt/features/logging instead
   */
  public class MyLoggingInInterceptor extends LoggingInInterceptor {

    static {
      System.out.println("My LoggingInInterceptor");
    }

    public MyLoggingInInterceptor () {
      super();
    }
    @Override
    public boolean isPrettyLogging() {
      System.out.println("My isPrettyLogging");
      return true;
    }

/*    protected void writePayload(StringBuilder builder, CachedOutputStream cos,
        String encoding, String contentType)
        throws Exception {
      // Save the outputstream to file
      String filename = "soap.request-" + TimeUnit.MILLISECONDS.toMillis(
          System.currentTimeMillis());
      //TransformerUtils.saveLogToFile("dumps", filename, ".log", cos);

      super.writePayload(builder, cos, encoding, contentType, false);
    }

 */
  }