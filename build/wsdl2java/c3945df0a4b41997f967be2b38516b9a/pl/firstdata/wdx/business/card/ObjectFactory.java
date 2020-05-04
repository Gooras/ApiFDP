
package pl.firstdata.wdx.business.card;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import pl.firstdata.wdx.business.card.v5.OperationResult;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.firstdata.wdx.business.card package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AccountManagement_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "accountManagement");
    private final static QName _AccountManagementResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "accountManagementResponse");
    private final static QName _ActivateCard_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "activateCard");
    private final static QName _ActivateCardResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "activateCardResponse");
    private final static QName _BlockCard_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "blockCard");
    private final static QName _BlockCardResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "blockCardResponse");
    private final static QName _CancelEnrollment_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "cancelEnrollment");
    private final static QName _CancelEnrollmentResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "cancelEnrollmentResponse");
    private final static QName _CardAccountBinding_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "cardAccountBinding");
    private final static QName _CardAccountBindingResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "cardAccountBindingResponse");
    private final static QName _CardIssuing_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "cardIssuing");
    private final static QName _CardIssuingResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "cardIssuingResponse");
    private final static QName _ChangeCardStatus_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "changeCardStatus");
    private final static QName _ChangeCardStatusResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "changeCardStatusResponse");
    private final static QName _ChangePhoneNumber_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "changePhoneNumber");
    private final static QName _ChangePhoneNumberResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "changePhoneNumberResponse");
    private final static QName _EnrollCH_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "enrollCH");
    private final static QName _EnrollCHResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "enrollCHResponse");
    private final static QName _EnrollCard_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "enrollCard");
    private final static QName _EnrollCardResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "enrollCardResponse");
    private final static QName _GetBalance_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "getBalance");
    private final static QName _GetBalanceResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "getBalanceResponse");
    private final static QName _GetCardStatus_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "getCardStatus");
    private final static QName _GetCardStatusResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "getCardStatusResponse");
    private final static QName _GetToken_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "getToken");
    private final static QName _GetTokenResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "getTokenResponse");
    private final static QName _GetUserDetails_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "getUserDetails");
    private final static QName _GetUserDetailsPan_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "getUserDetailsPan");
    private final static QName _GetUserDetailsPanResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "getUserDetailsPanResponse");
    private final static QName _GetUserDetailsResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "getUserDetailsResponse");
    private final static QName _Manage3DsCard_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "manage3dsCard");
    private final static QName _Manage3DsCardResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "manage3dsCardResponse");
    private final static QName _ManageCard_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "manageCard");
    private final static QName _ManageCardResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "manageCardResponse");
    private final static QName _OrderPin_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "orderPin");
    private final static QName _OrderPinResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "orderPinResponse");
    private final static QName _ReadCardId_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "readCardId");
    private final static QName _ReadCardIdResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "readCardIdResponse");
    private final static QName _ReadCrta_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "readCrta");
    private final static QName _ReadCrtaResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "readCrtaResponse");
    private final static QName _ReadCtls_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "readCtls");
    private final static QName _ReadCtlsResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "readCtlsResponse");
    private final static QName _ReadLimits_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "readLimits");
    private final static QName _ReadLimitsResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "readLimitsResponse");
    private final static QName _ReadSecureCode_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "readSecureCode");
    private final static QName _ReadSecureCodeResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "readSecureCodeResponse");
    private final static QName _SendAuthStatus_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "sendAuthStatus");
    private final static QName _SendAuthStatusResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "sendAuthStatusResponse");
    private final static QName _SetCtls_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "setCtls");
    private final static QName _SetCtlsResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "setCtlsResponse");
    private final static QName _SetLimits_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "setLimits");
    private final static QName _SetLimitsResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "setLimitsResponse");
    private final static QName _SetMonthlyLimits_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "setMonthlyLimits");
    private final static QName _SetMonthlyLimitsResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "setMonthlyLimitsResponse");
    private final static QName _UnblockCard_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "unblockCard");
    private final static QName _UnblockCardResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "unblockCardResponse");
    private final static QName _UnblockPin_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "unblockPin");
    private final static QName _UnblockPinResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "unblockPinResponse");
    private final static QName _UpdateCardStatus_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "updateCardStatus");
    private final static QName _UpdateCardStatusResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "updateCardStatusResponse");
    private final static QName _UpdateCrta_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "updateCrta");
    private final static QName _UpdateCrtaResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "updateCrtaResponse");
    private final static QName _UpdateIssuerQuestions_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "updateIssuerQuestions");
    private final static QName _UpdateIssuerQuestionsResponse_QNAME = new QName("http://www.firstdata.pl/wdx/business/card/", "updateIssuerQuestionsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.firstdata.wdx.business.card
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AccountManagementRequest }
     * 
     */
    public AccountManagementRequest createAccountManagementRequest() {
        return new AccountManagementRequest();
    }

    /**
     * Create an instance of {@link CardActivationRequest }
     * 
     */
    public CardActivationRequest createCardActivationRequest() {
        return new CardActivationRequest();
    }

    /**
     * Create an instance of {@link BlockStatusCardRequest }
     * 
     */
    public BlockStatusCardRequest createBlockStatusCardRequest() {
        return new BlockStatusCardRequest();
    }

    /**
     * Create an instance of {@link CancelEnrollmentRequest }
     * 
     */
    public CancelEnrollmentRequest createCancelEnrollmentRequest() {
        return new CancelEnrollmentRequest();
    }

    /**
     * Create an instance of {@link CardAccountBindingRequest }
     * 
     */
    public CardAccountBindingRequest createCardAccountBindingRequest() {
        return new CardAccountBindingRequest();
    }

    /**
     * Create an instance of {@link CardIssuingRequest }
     * 
     */
    public CardIssuingRequest createCardIssuingRequest() {
        return new CardIssuingRequest();
    }

    /**
     * Create an instance of {@link CardIssuingResponse }
     * 
     */
    public CardIssuingResponse createCardIssuingResponse() {
        return new CardIssuingResponse();
    }

    /**
     * Create an instance of {@link CardStatusChangeRequest }
     * 
     */
    public CardStatusChangeRequest createCardStatusChangeRequest() {
        return new CardStatusChangeRequest();
    }

    /**
     * Create an instance of {@link ChangePhoneNumberRequest }
     * 
     */
    public ChangePhoneNumberRequest createChangePhoneNumberRequest() {
        return new ChangePhoneNumberRequest();
    }

    /**
     * Create an instance of {@link EnrollCHRequest }
     * 
     */
    public EnrollCHRequest createEnrollCHRequest() {
        return new EnrollCHRequest();
    }

    /**
     * Create an instance of {@link EnrollCardRequest }
     * 
     */
    public EnrollCardRequest createEnrollCardRequest() {
        return new EnrollCardRequest();
    }

    /**
     * Create an instance of {@link CardBalanceRequest }
     * 
     */
    public CardBalanceRequest createCardBalanceRequest() {
        return new CardBalanceRequest();
    }

    /**
     * Create an instance of {@link CardBalance }
     * 
     */
    public CardBalance createCardBalance() {
        return new CardBalance();
    }

    /**
     * Create an instance of {@link CardStatusRequest }
     * 
     */
    public CardStatusRequest createCardStatusRequest() {
        return new CardStatusRequest();
    }

    /**
     * Create an instance of {@link CardStatus }
     * 
     */
    public CardStatus createCardStatus() {
        return new CardStatus();
    }

    /**
     * Create an instance of {@link GetTokenRequest }
     * 
     */
    public GetTokenRequest createGetTokenRequest() {
        return new GetTokenRequest();
    }

    /**
     * Create an instance of {@link GetTokenResponse }
     * 
     */
    public GetTokenResponse createGetTokenResponse() {
        return new GetTokenResponse();
    }

    /**
     * Create an instance of {@link GetUserDetailsRequest }
     * 
     */
    public GetUserDetailsRequest createGetUserDetailsRequest() {
        return new GetUserDetailsRequest();
    }

    /**
     * Create an instance of {@link GetUserDetailsPanRequest }
     * 
     */
    public GetUserDetailsPanRequest createGetUserDetailsPanRequest() {
        return new GetUserDetailsPanRequest();
    }

    /**
     * Create an instance of {@link GetUserDetailsResponse }
     * 
     */
    public GetUserDetailsResponse createGetUserDetailsResponse() {
        return new GetUserDetailsResponse();
    }

    /**
     * Create an instance of {@link Manage3DsCardRequest }
     * 
     */
    public Manage3DsCardRequest createManage3DsCardRequest() {
        return new Manage3DsCardRequest();
    }

    /**
     * Create an instance of {@link ManageCardRequest }
     * 
     */
    public ManageCardRequest createManageCardRequest() {
        return new ManageCardRequest();
    }

    /**
     * Create an instance of {@link OrderPinRequest }
     * 
     */
    public OrderPinRequest createOrderPinRequest() {
        return new OrderPinRequest();
    }

    /**
     * Create an instance of {@link CardIdResponse }
     * 
     */
    public CardIdResponse createCardIdResponse() {
        return new CardIdResponse();
    }

    /**
     * Create an instance of {@link ReadCardIdRequest }
     * 
     */
    public ReadCardIdRequest createReadCardIdRequest() {
        return new ReadCardIdRequest();
    }

    /**
     * Create an instance of {@link ReadCrtaRequest }
     * 
     */
    public ReadCrtaRequest createReadCrtaRequest() {
        return new ReadCrtaRequest();
    }

    /**
     * Create an instance of {@link CrtaResponse }
     * 
     */
    public CrtaResponse createCrtaResponse() {
        return new CrtaResponse();
    }

    /**
     * Create an instance of {@link ReadCtlsRequest }
     * 
     */
    public ReadCtlsRequest createReadCtlsRequest() {
        return new ReadCtlsRequest();
    }

    /**
     * Create an instance of {@link ReadCtlsResponse }
     * 
     */
    public ReadCtlsResponse createReadCtlsResponse() {
        return new ReadCtlsResponse();
    }

    /**
     * Create an instance of {@link ReadLimitsRequest }
     * 
     */
    public ReadLimitsRequest createReadLimitsRequest() {
        return new ReadLimitsRequest();
    }

    /**
     * Create an instance of {@link ReadLimitsResponse }
     * 
     */
    public ReadLimitsResponse createReadLimitsResponse() {
        return new ReadLimitsResponse();
    }

    /**
     * Create an instance of {@link ReadSecureCodeRequest }
     * 
     */
    public ReadSecureCodeRequest createReadSecureCodeRequest() {
        return new ReadSecureCodeRequest();
    }

    /**
     * Create an instance of {@link SecureCodeResult }
     * 
     */
    public SecureCodeResult createSecureCodeResult() {
        return new SecureCodeResult();
    }

    /**
     * Create an instance of {@link SendAuthStatusRequest }
     * 
     */
    public SendAuthStatusRequest createSendAuthStatusRequest() {
        return new SendAuthStatusRequest();
    }

    /**
     * Create an instance of {@link SetCtlsRequest }
     * 
     */
    public SetCtlsRequest createSetCtlsRequest() {
        return new SetCtlsRequest();
    }

    /**
     * Create an instance of {@link SetLimitsRequest }
     * 
     */
    public SetLimitsRequest createSetLimitsRequest() {
        return new SetLimitsRequest();
    }

    /**
     * Create an instance of {@link SetMonthlyLimitsRequest }
     * 
     */
    public SetMonthlyLimitsRequest createSetMonthlyLimitsRequest() {
        return new SetMonthlyLimitsRequest();
    }

    /**
     * Create an instance of {@link UnblockPinRequest }
     * 
     */
    public UnblockPinRequest createUnblockPinRequest() {
        return new UnblockPinRequest();
    }

    /**
     * Create an instance of {@link CardStatusUpdateRequest }
     * 
     */
    public CardStatusUpdateRequest createCardStatusUpdateRequest() {
        return new CardStatusUpdateRequest();
    }

    /**
     * Create an instance of {@link UpdateCrtaRequest }
     * 
     */
    public UpdateCrtaRequest createUpdateCrtaRequest() {
        return new UpdateCrtaRequest();
    }

    /**
     * Create an instance of {@link UpdateIssuerQuestionsRequest }
     * 
     */
    public UpdateIssuerQuestionsRequest createUpdateIssuerQuestionsRequest() {
        return new UpdateIssuerQuestionsRequest();
    }

    /**
     * Create an instance of {@link LimitsData }
     * 
     */
    public LimitsData createLimitsData() {
        return new LimitsData();
    }

    /**
     * Create an instance of {@link CtlsResponseData }
     * 
     */
    public CtlsResponseData createCtlsResponseData() {
        return new CtlsResponseData();
    }

    /**
     * Create an instance of {@link UserDetails }
     * 
     */
    public UserDetails createUserDetails() {
        return new UserDetails();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountManagementRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AccountManagementRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "accountManagement")
    public JAXBElement<AccountManagementRequest> createAccountManagement(AccountManagementRequest value) {
        return new JAXBElement<AccountManagementRequest>(_AccountManagement_QNAME, AccountManagementRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "accountManagementResponse")
    public JAXBElement<OperationResult> createAccountManagementResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_AccountManagementResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardActivationRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CardActivationRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "activateCard")
    public JAXBElement<CardActivationRequest> createActivateCard(CardActivationRequest value) {
        return new JAXBElement<CardActivationRequest>(_ActivateCard_QNAME, CardActivationRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "activateCardResponse")
    public JAXBElement<OperationResult> createActivateCardResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_ActivateCardResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BlockStatusCardRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BlockStatusCardRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "blockCard")
    public JAXBElement<BlockStatusCardRequest> createBlockCard(BlockStatusCardRequest value) {
        return new JAXBElement<BlockStatusCardRequest>(_BlockCard_QNAME, BlockStatusCardRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "blockCardResponse")
    public JAXBElement<OperationResult> createBlockCardResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_BlockCardResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelEnrollmentRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CancelEnrollmentRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "cancelEnrollment")
    public JAXBElement<CancelEnrollmentRequest> createCancelEnrollment(CancelEnrollmentRequest value) {
        return new JAXBElement<CancelEnrollmentRequest>(_CancelEnrollment_QNAME, CancelEnrollmentRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "cancelEnrollmentResponse")
    public JAXBElement<OperationResult> createCancelEnrollmentResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_CancelEnrollmentResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardAccountBindingRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CardAccountBindingRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "cardAccountBinding")
    public JAXBElement<CardAccountBindingRequest> createCardAccountBinding(CardAccountBindingRequest value) {
        return new JAXBElement<CardAccountBindingRequest>(_CardAccountBinding_QNAME, CardAccountBindingRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "cardAccountBindingResponse")
    public JAXBElement<OperationResult> createCardAccountBindingResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_CardAccountBindingResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardIssuingRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CardIssuingRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "cardIssuing")
    public JAXBElement<CardIssuingRequest> createCardIssuing(CardIssuingRequest value) {
        return new JAXBElement<CardIssuingRequest>(_CardIssuing_QNAME, CardIssuingRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardIssuingResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CardIssuingResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "cardIssuingResponse")
    public JAXBElement<CardIssuingResponse> createCardIssuingResponse(CardIssuingResponse value) {
        return new JAXBElement<CardIssuingResponse>(_CardIssuingResponse_QNAME, CardIssuingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardStatusChangeRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CardStatusChangeRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "changeCardStatus")
    public JAXBElement<CardStatusChangeRequest> createChangeCardStatus(CardStatusChangeRequest value) {
        return new JAXBElement<CardStatusChangeRequest>(_ChangeCardStatus_QNAME, CardStatusChangeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "changeCardStatusResponse")
    public JAXBElement<OperationResult> createChangeCardStatusResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_ChangeCardStatusResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangePhoneNumberRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChangePhoneNumberRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "changePhoneNumber")
    public JAXBElement<ChangePhoneNumberRequest> createChangePhoneNumber(ChangePhoneNumberRequest value) {
        return new JAXBElement<ChangePhoneNumberRequest>(_ChangePhoneNumber_QNAME, ChangePhoneNumberRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "changePhoneNumberResponse")
    public JAXBElement<OperationResult> createChangePhoneNumberResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_ChangePhoneNumberResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnrollCHRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EnrollCHRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "enrollCH")
    public JAXBElement<EnrollCHRequest> createEnrollCH(EnrollCHRequest value) {
        return new JAXBElement<EnrollCHRequest>(_EnrollCH_QNAME, EnrollCHRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "enrollCHResponse")
    public JAXBElement<OperationResult> createEnrollCHResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_EnrollCHResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnrollCardRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EnrollCardRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "enrollCard")
    public JAXBElement<EnrollCardRequest> createEnrollCard(EnrollCardRequest value) {
        return new JAXBElement<EnrollCardRequest>(_EnrollCard_QNAME, EnrollCardRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "enrollCardResponse")
    public JAXBElement<OperationResult> createEnrollCardResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_EnrollCardResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardBalanceRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CardBalanceRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "getBalance")
    public JAXBElement<CardBalanceRequest> createGetBalance(CardBalanceRequest value) {
        return new JAXBElement<CardBalanceRequest>(_GetBalance_QNAME, CardBalanceRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardBalance }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CardBalance }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "getBalanceResponse")
    public JAXBElement<CardBalance> createGetBalanceResponse(CardBalance value) {
        return new JAXBElement<CardBalance>(_GetBalanceResponse_QNAME, CardBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardStatusRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CardStatusRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "getCardStatus")
    public JAXBElement<CardStatusRequest> createGetCardStatus(CardStatusRequest value) {
        return new JAXBElement<CardStatusRequest>(_GetCardStatus_QNAME, CardStatusRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardStatus }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CardStatus }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "getCardStatusResponse")
    public JAXBElement<CardStatus> createGetCardStatusResponse(CardStatus value) {
        return new JAXBElement<CardStatus>(_GetCardStatusResponse_QNAME, CardStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTokenRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTokenRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "getToken")
    public JAXBElement<GetTokenRequest> createGetToken(GetTokenRequest value) {
        return new JAXBElement<GetTokenRequest>(_GetToken_QNAME, GetTokenRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTokenResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTokenResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "getTokenResponse")
    public JAXBElement<GetTokenResponse> createGetTokenResponse(GetTokenResponse value) {
        return new JAXBElement<GetTokenResponse>(_GetTokenResponse_QNAME, GetTokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserDetailsRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetUserDetailsRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "getUserDetails")
    public JAXBElement<GetUserDetailsRequest> createGetUserDetails(GetUserDetailsRequest value) {
        return new JAXBElement<GetUserDetailsRequest>(_GetUserDetails_QNAME, GetUserDetailsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserDetailsPanRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetUserDetailsPanRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "getUserDetailsPan")
    public JAXBElement<GetUserDetailsPanRequest> createGetUserDetailsPan(GetUserDetailsPanRequest value) {
        return new JAXBElement<GetUserDetailsPanRequest>(_GetUserDetailsPan_QNAME, GetUserDetailsPanRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserDetailsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetUserDetailsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "getUserDetailsPanResponse")
    public JAXBElement<GetUserDetailsResponse> createGetUserDetailsPanResponse(GetUserDetailsResponse value) {
        return new JAXBElement<GetUserDetailsResponse>(_GetUserDetailsPanResponse_QNAME, GetUserDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserDetailsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetUserDetailsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "getUserDetailsResponse")
    public JAXBElement<GetUserDetailsResponse> createGetUserDetailsResponse(GetUserDetailsResponse value) {
        return new JAXBElement<GetUserDetailsResponse>(_GetUserDetailsResponse_QNAME, GetUserDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Manage3DsCardRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Manage3DsCardRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "manage3dsCard")
    public JAXBElement<Manage3DsCardRequest> createManage3DsCard(Manage3DsCardRequest value) {
        return new JAXBElement<Manage3DsCardRequest>(_Manage3DsCard_QNAME, Manage3DsCardRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "manage3dsCardResponse")
    public JAXBElement<OperationResult> createManage3DsCardResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_Manage3DsCardResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ManageCardRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ManageCardRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "manageCard")
    public JAXBElement<ManageCardRequest> createManageCard(ManageCardRequest value) {
        return new JAXBElement<ManageCardRequest>(_ManageCard_QNAME, ManageCardRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "manageCardResponse")
    public JAXBElement<OperationResult> createManageCardResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_ManageCardResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderPinRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrderPinRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "orderPin")
    public JAXBElement<OrderPinRequest> createOrderPin(OrderPinRequest value) {
        return new JAXBElement<OrderPinRequest>(_OrderPin_QNAME, OrderPinRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CardIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "orderPinResponse")
    public JAXBElement<CardIdResponse> createOrderPinResponse(CardIdResponse value) {
        return new JAXBElement<CardIdResponse>(_OrderPinResponse_QNAME, CardIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadCardIdRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReadCardIdRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "readCardId")
    public JAXBElement<ReadCardIdRequest> createReadCardId(ReadCardIdRequest value) {
        return new JAXBElement<ReadCardIdRequest>(_ReadCardId_QNAME, ReadCardIdRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CardIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "readCardIdResponse")
    public JAXBElement<CardIdResponse> createReadCardIdResponse(CardIdResponse value) {
        return new JAXBElement<CardIdResponse>(_ReadCardIdResponse_QNAME, CardIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadCrtaRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReadCrtaRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "readCrta")
    public JAXBElement<ReadCrtaRequest> createReadCrta(ReadCrtaRequest value) {
        return new JAXBElement<ReadCrtaRequest>(_ReadCrta_QNAME, ReadCrtaRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrtaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CrtaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "readCrtaResponse")
    public JAXBElement<CrtaResponse> createReadCrtaResponse(CrtaResponse value) {
        return new JAXBElement<CrtaResponse>(_ReadCrtaResponse_QNAME, CrtaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadCtlsRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReadCtlsRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "readCtls")
    public JAXBElement<ReadCtlsRequest> createReadCtls(ReadCtlsRequest value) {
        return new JAXBElement<ReadCtlsRequest>(_ReadCtls_QNAME, ReadCtlsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadCtlsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReadCtlsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "readCtlsResponse")
    public JAXBElement<ReadCtlsResponse> createReadCtlsResponse(ReadCtlsResponse value) {
        return new JAXBElement<ReadCtlsResponse>(_ReadCtlsResponse_QNAME, ReadCtlsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadLimitsRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReadLimitsRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "readLimits")
    public JAXBElement<ReadLimitsRequest> createReadLimits(ReadLimitsRequest value) {
        return new JAXBElement<ReadLimitsRequest>(_ReadLimits_QNAME, ReadLimitsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadLimitsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReadLimitsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "readLimitsResponse")
    public JAXBElement<ReadLimitsResponse> createReadLimitsResponse(ReadLimitsResponse value) {
        return new JAXBElement<ReadLimitsResponse>(_ReadLimitsResponse_QNAME, ReadLimitsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadSecureCodeRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReadSecureCodeRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "readSecureCode")
    public JAXBElement<ReadSecureCodeRequest> createReadSecureCode(ReadSecureCodeRequest value) {
        return new JAXBElement<ReadSecureCodeRequest>(_ReadSecureCode_QNAME, ReadSecureCodeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecureCodeResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SecureCodeResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "readSecureCodeResponse")
    public JAXBElement<SecureCodeResult> createReadSecureCodeResponse(SecureCodeResult value) {
        return new JAXBElement<SecureCodeResult>(_ReadSecureCodeResponse_QNAME, SecureCodeResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendAuthStatusRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SendAuthStatusRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "sendAuthStatus")
    public JAXBElement<SendAuthStatusRequest> createSendAuthStatus(SendAuthStatusRequest value) {
        return new JAXBElement<SendAuthStatusRequest>(_SendAuthStatus_QNAME, SendAuthStatusRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "sendAuthStatusResponse")
    public JAXBElement<OperationResult> createSendAuthStatusResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_SendAuthStatusResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCtlsRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetCtlsRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "setCtls")
    public JAXBElement<SetCtlsRequest> createSetCtls(SetCtlsRequest value) {
        return new JAXBElement<SetCtlsRequest>(_SetCtls_QNAME, SetCtlsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "setCtlsResponse")
    public JAXBElement<OperationResult> createSetCtlsResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_SetCtlsResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetLimitsRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetLimitsRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "setLimits")
    public JAXBElement<SetLimitsRequest> createSetLimits(SetLimitsRequest value) {
        return new JAXBElement<SetLimitsRequest>(_SetLimits_QNAME, SetLimitsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "setLimitsResponse")
    public JAXBElement<OperationResult> createSetLimitsResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_SetLimitsResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetMonthlyLimitsRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetMonthlyLimitsRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "setMonthlyLimits")
    public JAXBElement<SetMonthlyLimitsRequest> createSetMonthlyLimits(SetMonthlyLimitsRequest value) {
        return new JAXBElement<SetMonthlyLimitsRequest>(_SetMonthlyLimits_QNAME, SetMonthlyLimitsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "setMonthlyLimitsResponse")
    public JAXBElement<OperationResult> createSetMonthlyLimitsResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_SetMonthlyLimitsResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BlockStatusCardRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BlockStatusCardRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "unblockCard")
    public JAXBElement<BlockStatusCardRequest> createUnblockCard(BlockStatusCardRequest value) {
        return new JAXBElement<BlockStatusCardRequest>(_UnblockCard_QNAME, BlockStatusCardRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "unblockCardResponse")
    public JAXBElement<OperationResult> createUnblockCardResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_UnblockCardResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnblockPinRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnblockPinRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "unblockPin")
    public JAXBElement<UnblockPinRequest> createUnblockPin(UnblockPinRequest value) {
        return new JAXBElement<UnblockPinRequest>(_UnblockPin_QNAME, UnblockPinRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "unblockPinResponse")
    public JAXBElement<OperationResult> createUnblockPinResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_UnblockPinResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardStatusUpdateRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CardStatusUpdateRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "updateCardStatus")
    public JAXBElement<CardStatusUpdateRequest> createUpdateCardStatus(CardStatusUpdateRequest value) {
        return new JAXBElement<CardStatusUpdateRequest>(_UpdateCardStatus_QNAME, CardStatusUpdateRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "updateCardStatusResponse")
    public JAXBElement<OperationResult> createUpdateCardStatusResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_UpdateCardStatusResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCrtaRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateCrtaRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "updateCrta")
    public JAXBElement<UpdateCrtaRequest> createUpdateCrta(UpdateCrtaRequest value) {
        return new JAXBElement<UpdateCrtaRequest>(_UpdateCrta_QNAME, UpdateCrtaRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "updateCrtaResponse")
    public JAXBElement<OperationResult> createUpdateCrtaResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_UpdateCrtaResponse_QNAME, OperationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateIssuerQuestionsRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateIssuerQuestionsRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "updateIssuerQuestions")
    public JAXBElement<UpdateIssuerQuestionsRequest> createUpdateIssuerQuestions(UpdateIssuerQuestionsRequest value) {
        return new JAXBElement<UpdateIssuerQuestionsRequest>(_UpdateIssuerQuestions_QNAME, UpdateIssuerQuestionsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.firstdata.pl/wdx/business/card/", name = "updateIssuerQuestionsResponse")
    public JAXBElement<OperationResult> createUpdateIssuerQuestionsResponse(OperationResult value) {
        return new JAXBElement<OperationResult>(_UpdateIssuerQuestionsResponse_QNAME, OperationResult.class, null, value);
    }

}
