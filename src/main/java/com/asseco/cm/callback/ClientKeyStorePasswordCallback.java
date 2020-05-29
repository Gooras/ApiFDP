package com.asseco.cm.callback;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.wss4j.common.ext.WSPasswordCallback;

public class ClientKeyStorePasswordCallback implements CallbackHandler {

  private Map<String, String> passwords = new HashMap<String, String>();

  public ClientKeyStorePasswordCallback() {
    //System.out.println("Konstruktor ClientKeyStorePasswordCallback");

    passwords.put("ca", "fdppass");
    passwords.put("nsb", "jbossws");
    passwords.put("fdp", "fdppass");
  }

  @Override
  public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
    //System.out.println("Callback");

    for (int i = 0; i < callbacks.length; i++) {
      //System.out.println("Pętla: " + i);
      WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];

      String pass = passwords.get(pc.getIdentifier());
      //System.out.println("Identyfikator: " + pc.getIdentifier() + " hasło: " + pass);
      if (pass != null) {
        pc.setPassword(pass);
        return;
      }
    }
  }

}
