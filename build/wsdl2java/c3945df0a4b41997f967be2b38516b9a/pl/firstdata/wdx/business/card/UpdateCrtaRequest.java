
package pl.firstdata.wdx.business.card;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateCrtaRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateCrtaRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cardNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="crtaEnroll" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="crtaLimitAtm" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="crtaLimitCnp" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="crtaLimitFor" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="crtaLimitPos" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="crtaPhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="langId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateCrtaRequest", propOrder = {
    "cardNumber",
    "crtaEnroll",
    "crtaLimitAtm",
    "crtaLimitCnp",
    "crtaLimitFor",
    "crtaLimitPos",
    "crtaPhoneNumber",
    "langId",
    "phoneNumber"
})
public class UpdateCrtaRequest {

    @XmlElement(required = true)
    protected String cardNumber;
    @XmlElement(required = true)
    protected String crtaEnroll;
    protected int crtaLimitAtm;
    protected int crtaLimitCnp;
    protected int crtaLimitFor;
    protected int crtaLimitPos;
    protected String crtaPhoneNumber;
    protected String langId;
    protected String phoneNumber;

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
     * Gets the value of the crtaEnroll property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrtaEnroll() {
        return crtaEnroll;
    }

    /**
     * Sets the value of the crtaEnroll property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrtaEnroll(String value) {
        this.crtaEnroll = value;
    }

    /**
     * Gets the value of the crtaLimitAtm property.
     * 
     */
    public int getCrtaLimitAtm() {
        return crtaLimitAtm;
    }

    /**
     * Sets the value of the crtaLimitAtm property.
     * 
     */
    public void setCrtaLimitAtm(int value) {
        this.crtaLimitAtm = value;
    }

    /**
     * Gets the value of the crtaLimitCnp property.
     * 
     */
    public int getCrtaLimitCnp() {
        return crtaLimitCnp;
    }

    /**
     * Sets the value of the crtaLimitCnp property.
     * 
     */
    public void setCrtaLimitCnp(int value) {
        this.crtaLimitCnp = value;
    }

    /**
     * Gets the value of the crtaLimitFor property.
     * 
     */
    public int getCrtaLimitFor() {
        return crtaLimitFor;
    }

    /**
     * Sets the value of the crtaLimitFor property.
     * 
     */
    public void setCrtaLimitFor(int value) {
        this.crtaLimitFor = value;
    }

    /**
     * Gets the value of the crtaLimitPos property.
     * 
     */
    public int getCrtaLimitPos() {
        return crtaLimitPos;
    }

    /**
     * Sets the value of the crtaLimitPos property.
     * 
     */
    public void setCrtaLimitPos(int value) {
        this.crtaLimitPos = value;
    }

    /**
     * Gets the value of the crtaPhoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrtaPhoneNumber() {
        return crtaPhoneNumber;
    }

    /**
     * Sets the value of the crtaPhoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrtaPhoneNumber(String value) {
        this.crtaPhoneNumber = value;
    }

    /**
     * Gets the value of the langId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLangId() {
        return langId;
    }

    /**
     * Sets the value of the langId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLangId(String value) {
        this.langId = value;
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

}
