package com.asseco.cm.debug;

import java.security.cert.X509Certificate;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import org.apache.wss4j.common.EncryptionActionToken;
import org.apache.wss4j.common.SecurityActionToken;
import org.apache.wss4j.common.crypto.Crypto;
import org.apache.wss4j.common.crypto.CryptoType;
import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.dom.action.Action;
import org.apache.wss4j.dom.handler.RequestData;
import org.apache.wss4j.dom.handler.WSHandler;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.apache.wss4j.dom.message.WSSecEncrypt;

public class EncryptionAction implements Action {
  public void execute(WSHandler handler, SecurityActionToken actionToken, RequestData reqData)
      throws WSSecurityException {
    System.out.println("EncryptionAcition - execute 1");

    WSSecEncrypt wsEncrypt = new WSSecEncrypt(reqData.getSecHeader());
    System.out.println("EncryptionAcition - execute 2");
    wsEncrypt.setIdAllocator(reqData.getWssConfig().getIdAllocator());
    System.out.println("EncryptionAcition - execute 3");
    wsEncrypt.setWsDocInfo(reqData.getWsDocInfo());
    System.out.println("EncryptionAcition - execute 4");
    wsEncrypt.setExpandXopInclude(reqData.isExpandXopInclude());
    System.out.println("EncryptionAcition - execute 5");

    EncryptionActionToken encryptionToken = null;
    if (actionToken instanceof EncryptionActionToken) {
      System.out.println("EncryptionAcition - execute 6");
      encryptionToken = (EncryptionActionToken)actionToken;
    }
    if (encryptionToken == null) {
      System.out.println("EncryptionAcition - execute 7");
      encryptionToken = reqData.getEncryptionToken();
    }

    if (encryptionToken.getKeyIdentifierId() != 0) {
      System.out.println("EncryptionAcition - execute 8");
      wsEncrypt.setKeyIdentifierType(encryptionToken.getKeyIdentifierId());
    }

    if (encryptionToken.getSymmetricAlgorithm() != null) {
      System.out.println("EncryptionAcition - execute 9");
      wsEncrypt.setSymmetricEncAlgorithm(encryptionToken.getSymmetricAlgorithm());
    }
    if (encryptionToken.getKeyTransportAlgorithm() != null) {
      System.out.println("EncryptionAcition - execute 10");
      wsEncrypt.setKeyEncAlgo(encryptionToken.getKeyTransportAlgorithm());
    }
    if (encryptionToken.getDigestAlgorithm() != null) {
      System.out.println("EncryptionAcition - execute 11");
      wsEncrypt.setDigestAlgorithm(encryptionToken.getDigestAlgorithm());
    }

    if (encryptionToken.getMgfAlgorithm() != null) {
      System.out.println("EncryptionAcition - execute 12");
      wsEncrypt.setMGFAlgorithm(encryptionToken.getMgfAlgorithm());
    }

    wsEncrypt.setIncludeEncryptionToken(encryptionToken.isIncludeToken());
    System.out.println("EncryptionAcition - execute 13");

    wsEncrypt.setUserInfo(encryptionToken.getUser());
    wsEncrypt.setUseThisCert(encryptionToken.getCertificate());
    System.out.println("EncryptionAcition - execute 14");

    Crypto crypto = encryptionToken.getCrypto();
    System.out.println("EncryptionAcition - execute 15");
    boolean enableRevocation = Boolean.valueOf(handler.getStringOption(WSHandlerConstants.ENABLE_REVOCATION));
    if (enableRevocation && crypto != null) {
      CryptoType cryptoType = new CryptoType(CryptoType.TYPE.ALIAS);
      cryptoType.setAlias(encryptionToken.getUser());
      X509Certificate[] certs = crypto.getX509Certificates(cryptoType);
      if (certs != null && certs.length > 0) {
        crypto.verifyTrust(certs, enableRevocation, null, null);
      }
    }
    if (!encryptionToken.getParts().isEmpty()) {
      wsEncrypt.getParts().addAll(encryptionToken.getParts());
    }

    wsEncrypt.setEncryptSymmKey(encryptionToken.isEncSymmetricEncryptionKey());

    byte[] ephemeralKey = encryptionToken.getKey();
    if (encryptionToken.isGetSymmetricKeyFromCallbackHandler()
        || !encryptionToken.isEncSymmetricEncryptionKey() && ephemeralKey == null) {
      CallbackHandler callbackHandler =
          handler.getPasswordCallbackHandler(reqData);
      // Get secret key for encryption from a CallbackHandler
      WSPasswordCallback pwcb =
          new WSPasswordCallback(encryptionToken.getUser(), WSPasswordCallback.SECRET_KEY);
      pwcb.setAlgorithm(wsEncrypt.getSymmetricEncAlgorithm());
      try {
        callbackHandler.handle(new Callback[] {pwcb});
      } catch (Exception e) {
        throw new WSSecurityException(WSSecurityException.ErrorCode.FAILURE, e,
            "empty", new Object[] {"WSHandler: password callback failed"});
      }

      ephemeralKey = pwcb.getKey();
      byte[] encryptedKey = pwcb.getEncryptedSecret();
      wsEncrypt.setEncryptedEphemeralKey(encryptedKey);
      wsEncrypt.setCustomEKKeyInfoElement(pwcb.getKeyInfoReference());
    }
    wsEncrypt.setEphemeralKey(ephemeralKey);

    if (encryptionToken.getTokenId() != null) {
      wsEncrypt.setEncKeyId(encryptionToken.getTokenId());
    }
    if (encryptionToken.getTokenType() != null) {
      wsEncrypt.setCustomReferenceValue(encryptionToken.getTokenType());
    }

    wsEncrypt.setAttachmentCallbackHandler(reqData.getAttachmentCallbackHandler());
    wsEncrypt.setStoreBytesInAttachment(reqData.isStoreBytesInAttachment());

    try {
      wsEncrypt.build(encryptionToken.getCrypto());
    } catch (WSSecurityException e) {
      throw new WSSecurityException(WSSecurityException.ErrorCode.FAILURE, e, "empty",
          new Object[] {"Error during encryption: "});
    }
  }
}
