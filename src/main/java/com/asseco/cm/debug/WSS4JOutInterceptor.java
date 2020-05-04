package com.asseco.cm.debug;

import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.xml.soap.SOAPMessage;

import org.apache.cxf.ws.security.wss4j.AbstractWSS4JInterceptor;
import org.apache.cxf.ws.security.wss4j.AttachmentCallbackHandler;
import org.apache.wss4j.common.EncryptionActionToken;
import org.apache.wss4j.common.SecurityActionToken;
import org.apache.wss4j.common.SignatureActionToken;
import org.apache.wss4j.common.SignatureEncryptionActionToken;
import org.apache.wss4j.common.WSEncryptionPart;
import org.apache.wss4j.common.crypto.Crypto;
import org.apache.wss4j.common.crypto.CryptoType;
import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.apache.wss4j.dom.WSDocInfo;
import org.apache.wss4j.dom.handler.WSHandler;
import org.apache.wss4j.dom.message.WSSecEncrypt;
import org.apache.wss4j.dom.message.WSSecHeader;
import org.w3c.dom.Document;

import org.apache.cxf.attachment.AttachmentUtil;
import org.apache.cxf.binding.soap.SoapFault;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.SoapVersion;
import org.apache.cxf.binding.soap.saaj.SAAJOutInterceptor;
import org.apache.cxf.common.i18n.Message;
import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.phase.PhaseInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.common.crypto.ThreadLocalSecurityProvider;
import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.action.Action;
import org.apache.wss4j.dom.engine.WSSConfig;
import org.apache.wss4j.dom.handler.HandlerAction;
import org.apache.wss4j.dom.handler.RequestData;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.apache.wss4j.dom.util.WSSecurityUtil;

public class WSS4JOutInterceptor extends AbstractWSS4JInterceptor {

  /**
   * Property name for a map of action IDs ({@link Integer}) to action
   * class names. Values can be either {@link Class}) or Objects
   -    * implementing {@link Action}.
   */
  public static final String WSS4J_ACTION_MAP = "wss4j.action.map";

  private static final Logger LOG = LogUtils
      .getL7dLogger(WSS4JOutInterceptor.class);

  private WSS4JOutInterceptorInternal ending;
  private SAAJOutInterceptor saajOut = new SAAJOutInterceptor();
  private boolean mtomEnabled;

  public WSS4JOutInterceptor() {
    super();
    setPhase(Phase.PRE_PROTOCOL);
    getAfter().add(SAAJOutInterceptor.class.getName());

    ending = createEndingInterceptor();
  }

  public WSS4JOutInterceptor(Map<String, Object> props) {
    this();
    setProperties(props);
  }

  @Deprecated
  public boolean isAllowMTOM() {
    return mtomEnabled;
  }

  @Deprecated
  public void setAllowMTOM(boolean allowMTOM) {
    this.mtomEnabled = allowMTOM;
  }

  @Override
  public Object getProperty(Object msgContext, String key) {
    // use the superclass first
    Object result = super.getProperty(msgContext, key);

    // handle the special case of the RECV_RESULTS
    if (result == null
        && WSHandlerConstants.RECV_RESULTS.equals(key)
        && !this.isRequestor((SoapMessage)msgContext)) {
      result = ((SoapMessage)msgContext).getExchange().getInMessage().get(key);
    }
    return result;
  }

  public void handleMessage(SoapMessage mc) throws Fault {
    System.out.println("handleMessage "+getClass().getName() + " "+getClass().getCanonicalName());

    if (mc.getContent(SOAPMessage.class) == null) {
      saajOut.handleMessage(mc);
    }

    // If a custom Id has been set, then change the Id for the internal interceptor as well, as otherwise
    // we can't add two WSS4JOutInterceptor instances to the interceptor chain.
    if (!WSS4JOutInterceptor.class.getName().equals(getId())) {
      Random random = new Random();
      int randomInt = random.nextInt();
      ending.setId(WSS4JOutInterceptorInternal.class.getName() + "_" + randomInt);
    }
    mc.getInterceptorChain().add(ending);
  }
  public void handleFault(SoapMessage message) {
    saajOut.handleFault(message);
  }

  public final WSS4JOutInterceptorInternal createEndingInterceptor() {
    return new WSS4JOutInterceptorInternal();
  }

  final class WSS4JOutInterceptorInternal
      implements PhaseInterceptor<SoapMessage> {
    private String id = WSS4JOutInterceptorInternal.class.getName();

    WSS4JOutInterceptorInternal() {
      super();
    }

    public void handleMessage(SoapMessage message) throws Fault {
      System.out.println("handleMessage2 "+getClass().getName() + " "+getClass().getCanonicalName());
      System.out.println(message);
      System.out.println("SOAP: " + message);

      Object provider = message.getExchange().get(Provider.class);
      final boolean useCustomProvider = provider != null && ThreadLocalSecurityProvider.isInstalled();
      try {
        if (useCustomProvider) {
          ThreadLocalSecurityProvider.setProvider((Provider)provider);
        }
        handleMessageInternal(message);
      } finally {
        if (useCustomProvider) {
          ThreadLocalSecurityProvider.unsetProvider();
        }
      }
    }

    private void handleMessageInternal(SoapMessage mc) throws Fault {

      System.out.println("handleMessageInternal");
      boolean doDebug = LOG.isLoggable(Level.FINE);

      if (doDebug) {
        LOG.fine("WSS4JOutInterceptor XXXXX: enter handleMessage()");
      }
      /**
       * There is nothing to send...Usually happens when the provider
       * needs to send a HTTP 202 message (with no content)
       */
      if (mc == null) {
        return;
      }
      SoapVersion version = mc.getVersion();
      RequestData reqData = new RequestData();
      System.out.println("RequestData: "+ reqData.toString());

      /*
       * The overall try, just to have a finally at the end to perform some
       * housekeeping.
       */
      try {
        WSSConfig config = WSSConfig.getNewInstance();
        reqData.setWssConfig(config);

        System.out.println("hMI 1");
        /*
         * Setup any custom actions first by processing the input properties
         * and reconfiguring the WSSConfig with the user defined properties.
         */
        this.configureActions(mc, doDebug, version, config);
        System.out.println("hMI 2");

        /*
         * Get the action first.
         */
        List<HandlerAction> actions =
            CastUtils.cast((List<?>)getProperty(mc, WSHandlerConstants.HANDLER_ACTIONS));
        System.out.println("hMI 3");
        if (actions == null) {
          // If null then just fall back to the "action" String
          System.out.println("hMI 4");
          String action = getString(ConfigurationConstants.ACTION, mc);
          System.out.println("hMI 5");
          if (action == null) {
            throw new SoapFault(new Message("NO_ACTION", LOG), version
                .getReceiver());
          }

          actions = WSSecurityUtil.decodeHandlerAction(action, config);
          System.out.println("hMI 6 "+actions.toString());
        }
        if (actions.isEmpty()) {
          return;
        }

        translateProperties(mc);
        System.out.println("hMI 7");
        reqData.setMsgContext(mc);
        System.out.println("hMI 8");
        reqData.setAttachmentCallbackHandler(new AttachmentCallbackHandler(mc));
        System.out.println("hMI 9");

        // Enable XOP Include unless the user has explicitly configured it
        if (getString(ConfigurationConstants.EXPAND_XOP_INCLUDE, mc) == null) {
          reqData.setExpandXopInclude(AttachmentUtil.isMtomEnabled(mc));
        }
        if (getString(ConfigurationConstants.STORE_BYTES_IN_ATTACHMENT, mc) == null) {
          reqData.setStoreBytesInAttachment(AttachmentUtil.isMtomEnabled(mc));
        }
        System.out.println("hMI 10");

        /*
         * For every action we need a username, so get this now. The
         * username defined in the deployment descriptor takes precedence.
         */
        reqData.setUsername((String) getOption(ConfigurationConstants.USER));
        System.out.println("hMI 11 "+reqData.getUsername());

        if (reqData.getUsername() == null || reqData.getUsername().isEmpty()) {
          String username = (String) getProperty(reqData.getMsgContext(),
              ConfigurationConstants.USER);
          System.out.println("hMI 12 "+ConfigurationConstants.USER);

          if (username != null) {
            reqData.setUsername(username);
          }
        }

        // Check to see if we require a username (+ if it's missing)
        boolean userNameRequired = false;
        for (HandlerAction handlerAction : actions) {
          if ((handlerAction.getAction() == WSConstants.SIGN
              || handlerAction.getAction() == WSConstants.UT
              || handlerAction.getAction() == WSConstants.UT_NOPASSWORD
              || handlerAction.getAction() == WSConstants.UT_SIGN)
              && (handlerAction.getActionToken() == null
              || handlerAction.getActionToken().getUser() == null)) {
            userNameRequired = true;
            System.out.println("hMI 13");
            break;
          }
        }
        if (userNameRequired && (reqData.getUsername() == null || reqData.getUsername().isEmpty())
            && (String)getOption(ConfigurationConstants.SIGNATURE_USER) == null) {
          System.out.println("hMI 14");

          throw new SoapFault(new Message("NO_USERNAME", LOG), version
              .getReceiver());
        }

        if (doDebug) {
          LOG.fine("Actor: " + reqData.getActor());
        }
        /*
         * Now get the SOAP part from the request message and convert it
         * into a Document. This forces CXF to serialize the SOAP request
         * into FORM_STRING. This string is converted into a document.
         * During the FORM_STRING serialization CXF performs multi-ref of
         * complex data types (if requested), generates and inserts
         * references for attachments and so on. The resulting Document
         * MUST be the complete and final SOAP request as CXF would send it
         * over the wire. Therefore this must shall be the last (or only)
         * handler in a chain. Now we can perform our security operations on
         * this request.
         */

        SOAPMessage saaj = mc.getContent(SOAPMessage.class);
        System.out.println("hMI 15 "+saaj.toString());

        if (saaj == null) {
          LOG.warning("SAAJOutHandler must be enabled for WS-Security!");
          throw new SoapFault(new Message("NO_SAAJ_DOC", LOG), version
              .getReceiver());
        }

        Document doc = saaj.getSOAPPart();
        System.out.println("hMI 16 ");
        System.out.println("doc "+doc.toString());
        System.out.println("req "+reqData.toString());
        System.out.println("act "+actions.toString());
        System.out.println("role "+getProperty(mc, org.apache.cxf.message.Message.REQUESTOR_ROLE));
        System.out.println("bool "+Boolean.TRUE.equals(getProperty(mc, org.apache.cxf.message.Message.REQUESTOR_ROLE)));


        doSenderAction(doc, reqData, actions, Boolean.TRUE.equals(getProperty(mc, org.apache.cxf.message.Message.REQUESTOR_ROLE)));
        System.out.println("hMI 17");

        if (doDebug) {
          LOG.fine("WSS4JOutInterceptor: exit handleMessage()");
        }
      } catch (WSSecurityException e) {
        System.out.println("hMI 18");
        throw new SoapFault(new Message("SECURITY_FAILED", LOG), e, version
            .getSender());
      } finally {
        reqData = null;
      }
    }

    public Set<String> getAfter() {
      return Collections.emptySet();
    }

    public Set<String> getBefore() {
      return Collections.emptySet();
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getPhase() {
      return Phase.POST_PROTOCOL;
    }

    public void handleFault(SoapMessage message) {
      //nothing
    }

    private void configureActions(SoapMessage mc, boolean doDebug,
        SoapVersion version, WSSConfig config) {

      final Map<Integer, Object> actionMap = CastUtils.cast(
          (Map<?, ?>)getProperty(mc, WSS4J_ACTION_MAP));
      if (actionMap != null && !actionMap.isEmpty()) {
        for (Map.Entry<Integer, Object> entry : actionMap.entrySet()) {
          Class<?> removedAction = null;

          // Be defensive here since the cast above is slightly risky
          // with the handler config options not being strongly typed.
          try {
            if (entry.getValue() instanceof Class<?>) {
              removedAction = config.setAction(
                  entry.getKey().intValue(),
                  (Class<?>)entry.getValue());
            } else if (entry.getValue() instanceof Action) {
              removedAction = config.setAction(
                  entry.getKey().intValue(),
                  (Action)entry.getValue());
            } else {
              throw new SoapFault(new Message("BAD_ACTION", LOG), version
                  .getReceiver());
            }
          } catch (ClassCastException e) {
            throw new SoapFault(new Message("BAD_ACTION", LOG), version
                .getReceiver());
          }

          if (doDebug) {
            if (removedAction != null) {
              LOG.fine("Replaced Action: " + removedAction.getName()
                  + " with Action: " + entry.getValue()
                  + " for ID: " + entry.getKey());
            } else {
              LOG.fine("Added Action: " + entry.getValue()
                  + " with ID: " + entry.getKey());
            }
          }
        }
      }
    }

    public Collection<PhaseInterceptor<? extends org.apache.cxf.message.Message>> getAdditionalInterceptors() {
      return null;
    }
  }

  protected void doSenderAction(
      Document doc,
      RequestData reqData,
      List<HandlerAction> actions,
      boolean isRequest
  ) throws WSSecurityException {

    System.out.println("doSenderAction");


    WSSConfig wssConfig = reqData.getWssConfig();
    if (wssConfig == null) {
      wssConfig = WSSConfig.getNewInstance();
      reqData.setWssConfig(wssConfig);
    }

    if (reqData.getWsDocInfo() == null) {
      WSDocInfo wsDocInfo = new WSDocInfo(doc);
      reqData.setWsDocInfo(wsDocInfo);
    }

    Object mc = reqData.getMsgContext();
    reqData.setEncodePasswords(
        decodeBooleanConfigValue(mc, WSHandlerConstants.USE_ENCODED_PASSWORDS, false)
    );
    reqData.setPrecisionInMilliSeconds(
        decodeBooleanConfigValue(mc, WSHandlerConstants.TIMESTAMP_PRECISION, true)
    );
    reqData.setAddInclusivePrefixes(
        decodeBooleanConfigValue(mc, WSHandlerConstants.ADD_INCLUSIVE_PREFIXES, true)
    );
    reqData.setEnableSignatureConfirmation(
        decodeBooleanConfigValue(mc, WSHandlerConstants.ENABLE_SIGNATURE_CONFIRMATION, false)
    );
    reqData.setTimeStampTTL(decodeTimeToLive(reqData, true));

    String actor = getString(WSHandlerConstants.ACTOR, mc);
    reqData.setActor(actor);

    boolean mu = decodeBooleanConfigValue(mc, WSHandlerConstants.MUST_UNDERSTAND, true);
    WSSecHeader secHeader = new WSSecHeader(actor, mu, doc);
    secHeader.insertSecurityHeader();
    reqData.setSecHeader(secHeader);
    reqData.setSoapConstants(WSSecurityUtil.getSOAPConstants(doc.getDocumentElement()));

    // Load CallbackHandler
    if (reqData.getCallbackHandler() == null) {
      CallbackHandler passwordCallbackHandler = getPasswordCallbackHandler(reqData);
      reqData.setCallbackHandler(passwordCallbackHandler);
    }

    if (!reqData.isStoreBytesInAttachment()) {
      boolean storeBytesInAttachment =
          decodeBooleanConfigValue(mc, WSHandlerConstants.STORE_BYTES_IN_ATTACHMENT, false);
      reqData.setStoreBytesInAttachment(storeBytesInAttachment);
    }

    // Perform configuration
    boolean encryptionFound = false;
    for (HandlerAction actionToDo : actions) {
      if (actionToDo.getAction() == WSConstants.SC) {
        reqData.setEnableSignatureConfirmation(true);
      } else if ((actionToDo.getAction() == WSConstants.UT
          || actionToDo.getAction() == WSConstants.UT_NOPASSWORD)
          && actionToDo.getActionToken() == null) {
        decodeUTParameter(reqData);
        if (actionToDo.getAction() == WSConstants.UT_NOPASSWORD) {
          reqData.setPwType(null);
        }
      } else if (actionToDo.getAction() == WSConstants.UT_SIGN
          && actionToDo.getActionToken() == null) {
        decodeUTParameter(reqData);
        decodeSignatureParameter(reqData);
      } else if ((actionToDo.getAction() == WSConstants.SIGN
          || actionToDo.getAction() == WSConstants.DKT_SIGN)
          && actionToDo.getActionToken() == null) {
        SignatureActionToken actionToken = reqData.getSignatureToken();
        if (actionToken == null) {
          actionToken = new SignatureActionToken();
          reqData.setSignatureToken(actionToken);
        }
        if (actionToken.getCrypto() == null) {
          actionToken.setCrypto(loadSignatureCrypto(reqData));
        }
        decodeSignatureParameter(reqData);
        if (encryptionFound && reqData.isStoreBytesInAttachment()) {
          //LOG.warn("Turning off storeBytesInAttachment as we have encryption before signature."
          //    + " The danger here is that the actual encryption bytes will not be signed");
          System.out.println("Turning off storeBytesInAttachment as we have encryption before signature."
              + " The danger here is that the actual encryption bytes will not be signed");
          reqData.setStoreBytesInAttachment(false);
        }
      } else if (actionToDo.getAction() == WSConstants.ST_SIGNED
          && actionToDo.getActionToken() == null) {
        decodeSignatureParameter(reqData);
      } else if ((actionToDo.getAction() == WSConstants.ENCR
          || actionToDo.getAction() == WSConstants.DKT_ENCR)
          && actionToDo.getActionToken() == null) {
        encryptionFound = true;
        EncryptionActionToken actionToken = reqData.getEncryptionToken();
        if (actionToken == null) {
          actionToken = new EncryptionActionToken();
          reqData.setEncryptionToken(actionToken);
        }
        if (actionToken.getCrypto() == null) {
          actionToken.setCrypto(loadEncryptionCrypto(reqData));
        }
        decodeEncryptionParameter(reqData);
      }
    }

    /*
     * If after all the parsing no Signature parts defined, set here a
     * default set. This is necessary because we add SignatureConfirmation
     * and therefore the default (Body) must be set here. The default setting
     * in WSSignEnvelope doesn't work because the vector is not empty anymore.
     */
    SignatureActionToken signatureToken = reqData.getSignatureToken();
    if (signatureToken == null) {
      signatureToken = new SignatureActionToken();
      reqData.setSignatureToken(signatureToken);
    }
    if (signatureToken.getParts().isEmpty()) {
      signatureToken.getParts().add(WSSecurityUtil.getDefaultEncryptionPart(doc));
    }
    /*
     * If SignatureConfirmation is enabled and this is a response then
     * insert SignatureConfirmation elements, note their wsu:id in the signature
     * parts. They will be signed automatically during a (probably) defined
     * SIGN action.
     */
    if (reqData.isEnableSignatureConfirmation() && !isRequest) {
      String done =
          (String)getProperty(reqData.getMsgContext(), WSHandlerConstants.SIG_CONF_DONE);
      if (done == null) {
        wssConfig.getAction(WSConstants.SC).execute(this, null, reqData);
      }
    }

    // See if the Signature and Timestamp actions (in that order) are defined, and if
    // the Timestamp is to be signed. In this case we need to swap the actions, as the
    // Timestamp must appear in the security header first for signature creation to work.
    List<HandlerAction> actionsToPerform = actions;
    HandlerAction signingAction = getSignatureActionThatSignsATimestamp(actions, reqData);

    if (signingAction != null) {
      actionsToPerform = new ArrayList<>(actions);
      Collections.copy(actionsToPerform, actions);

      int signatureIndex = actions.indexOf(signingAction);
      actionsToPerform.remove(signingAction);
      actionsToPerform.add(signingAction);
      reqData.setAppendSignatureAfterTimestamp(true);
      reqData.setOriginalSignatureActionPosition(signatureIndex);
    }

    /*
     * Here we have all necessary information to perform the requested
     * action(s).
     */
    for (HandlerAction actionToDo : actionsToPerform) {
      //LOG.debug("Performing Action: {}", actionToDo.getAction());
      System.out.println("Performing Action: {}" + actionToDo.getAction());
      System.out.println("Action: {}" + wssConfig.getAction(actionToDo.getAction()));
      System.out.println("SecHeader: " + reqData.getSecHeader());

      if (WSConstants.NO_SECURITY != actionToDo.getAction()) {
        if (actionToDo.getAction() == 4) {
          //Action act = wssConfig.getAction(actionToDo.getAction());
          //act.execute(this, actionToDo.getActionToken(), reqData);
          System.out.println("execute");
          execute(this, actionToDo.getActionToken(), reqData);
        } else {
          wssConfig.getAction(actionToDo.getAction()).execute(
              this, actionToDo.getActionToken(), reqData);
        }
      }
    }

    /*
     * If this is a request then store all signature values. Add ours to
     * already gathered values because of chained handlers, e.g. for
     * other actors.
     */
    if (reqData.isEnableSignatureConfirmation()
        && isRequest && !reqData.getSignatureValues().isEmpty()) {
      @SuppressWarnings("unchecked")
      Set<Integer> savedSignatures =
          (Set<Integer>)getProperty(reqData.getMsgContext(), WSHandlerConstants.SEND_SIGV);
      if (savedSignatures == null) {
        savedSignatures = new HashSet<>();
        setProperty(
            reqData.getMsgContext(), WSHandlerConstants.SEND_SIGV, savedSignatures
        );
      }
      for (byte[] signatureValue : reqData.getSignatureValues()) {
        savedSignatures.add(Arrays.hashCode(signatureValue));
      }
    }
  }

  private HandlerAction getSignatureActionThatSignsATimestamp(
      List<HandlerAction> actions, RequestData reqData
  ) {
    for (HandlerAction action : actions) {
      // Only applies if a Signature is before a Timestamp
      if (action.getAction() == WSConstants.TS) {
        return null;
      } else if (action.getAction() == WSConstants.SIGN) {
        if (action.getActionToken() != null
            && ((SignatureEncryptionActionToken)action.getActionToken()).getParts() != null) {
          for (WSEncryptionPart encP
              : ((SignatureEncryptionActionToken)action.getActionToken()).getParts()) {
            if (WSConstants.WSU_NS.equals(encP.getNamespace())
                && "Timestamp".equals(encP.getName())) {
              return action;
            }
          }
        } else {
          for (WSEncryptionPart encP : reqData.getSignatureToken().getParts()) {
            if (WSConstants.WSU_NS.equals(encP.getNamespace())
                && "Timestamp".equals(encP.getName())) {
              return action;
            }
          }
        }
      }
    }
    return null;
  }

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
      System.out.println("EncryptionAcition - execute 16 "+encryptionToken.toString());
      wsEncrypt.build(encryptionToken.getCrypto());
    } catch (WSSecurityException e) {
      throw new WSSecurityException(WSSecurityException.ErrorCode.FAILURE, e, "empty",
          new Object[] {"Error during encryption: "});
    }
  }

}
