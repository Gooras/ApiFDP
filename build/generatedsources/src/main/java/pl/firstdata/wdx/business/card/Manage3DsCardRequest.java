
package pl.firstdata.wdx.business.card;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for manage3DsCardRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="manage3DsCardRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cardNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="deviceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="internetBankingIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="mobileAppIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="primaryAuthMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="staticPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tdsStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "manage3DsCardRequest", propOrder = {
    "cardNumber",
    "deviceId",
    "internetBankingIndicator",
    "mobileAppIndicator",
    "phoneNumber",
    "primaryAuthMethod",
    "staticPassword",
    "tdsStatus"
})
public class Manage3DsCardRequest {

    @XmlElement(required = true)
    protected String cardNumber;
    protected String deviceId;
    protected String internetBankingIndicator;
    protected String mobileAppIndicator;
    protected String phoneNumber;
    protected String primaryAuthMethod;
    protected String staticPassword;
    protected String tdsStatus;

    /**
     * Gets the value of the cardNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the value of the cardNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    /**
     * Gets the value of the deviceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Sets the value of the deviceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceId(String value) {
        this.deviceId = value;
    }

    /**
     * Gets the value of the internetBankingIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternetBankingIndicator() {
        return internetBankingIndicator;
    }

    /**
     * Sets the value of the internetBankingIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternetBankingIndicator(String value) {
        this.internetBankingIndicator = value;
    }

    /**
     * Gets the value of the mobileAppIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobileAppIndicator() {
        return mobileAppIndicator;
    }

    /**
     * Sets the value of the mobileAppIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobileAppIndicator(String value) {
        this.mobileAppIndicator = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the primaryAuthMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryAuthMethod() {
        return primaryAuthMethod;
    }

    /**
     * Sets the value of the primaryAuthMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryAuthMethod(String value) {
        this.primaryAuthMethod = value;
    }

    /**
     * Gets the value of the staticPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStaticPassword() {
        return staticPassword;
    }

    /**
     * Sets the value of the staticPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStaticPassword(String value) {
        this.staticPassword = value;
    }

    /**
     * Gets the value of the tdsStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTdsStatus() {
        return tdsStatus;
    }

    /**
     * Sets the value of the tdsStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTdsStatus(String value) {
        this.tdsStatus = value;
    }

}
