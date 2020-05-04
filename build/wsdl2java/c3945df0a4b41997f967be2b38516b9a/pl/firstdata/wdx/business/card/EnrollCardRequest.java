
package pl.firstdata.wdx.business.card;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for enrollCardRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="enrollCardRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="blockFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cardNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cardholderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="custom1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="custom2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="custom3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dateOfBirth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="enrollmentFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="expiryDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="idNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="maidenName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pesel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="staticPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="temporaryPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enrollCardRequest", propOrder = {
    "blockFlag",
    "cardNumber",
    "cardholderName",
    "custom1",
    "custom2",
    "custom3",
    "dateOfBirth",
    "enrollmentFlag",
    "expiryDate",
    "idNumber",
    "maidenName",
    "pam",
    "pesel",
    "phoneNumber",
    "staticPassword",
    "temporaryPassword"
})
public class EnrollCardRequest {

    protected String blockFlag;
    @XmlElement(required = true)
    protected String cardNumber;
    protected String cardholderName;
    protected String custom1;
    protected String custom2;
    protected String custom3;
    protected String dateOfBirth;
    protected String enrollmentFlag;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar expiryDate;
    protected String idNumber;
    protected String maidenName;
    protected String pam;
    protected String pesel;
    protected String phoneNumber;
    protected String staticPassword;
    protected String temporaryPassword;

    /**
     * Gets the value of the blockFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlockFlag() {
        return blockFlag;
    }

    /**
     * Sets the value of the blockFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockFlag(String value) {
        this.blockFlag = value;
    }

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
     * Gets the value of the cardholderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardholderName() {
        return cardholderName;
    }

    /**
     * Sets the value of the cardholderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardholderName(String value) {
        this.cardholderName = value;
    }

    /**
     * Gets the value of the custom1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustom1() {
        return custom1;
    }

    /**
     * Sets the value of the custom1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustom1(String value) {
        this.custom1 = value;
    }

    /**
     * Gets the value of the custom2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustom2() {
        return custom2;
    }

    /**
     * Sets the value of the custom2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustom2(String value) {
        this.custom2 = value;
    }

    /**
     * Gets the value of the custom3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustom3() {
        return custom3;
    }

    /**
     * Sets the value of the custom3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustom3(String value) {
        this.custom3 = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfBirth(String value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the enrollmentFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnrollmentFlag() {
        return enrollmentFlag;
    }

    /**
     * Sets the value of the enrollmentFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnrollmentFlag(String value) {
        this.enrollmentFlag = value;
    }

    /**
     * Gets the value of the expiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpiryDate(XMLGregorianCalendar value) {
        this.expiryDate = value;
    }

    /**
     * Gets the value of the idNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * Sets the value of the idNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdNumber(String value) {
        this.idNumber = value;
    }

    /**
     * Gets the value of the maidenName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaidenName() {
        return maidenName;
    }

    /**
     * Sets the value of the maidenName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaidenName(String value) {
        this.maidenName = value;
    }

    /**
     * Gets the value of the pam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPam() {
        return pam;
    }

    /**
     * Sets the value of the pam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPam(String value) {
        this.pam = value;
    }

    /**
     * Gets the value of the pesel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPesel() {
        return pesel;
    }

    /**
     * Sets the value of the pesel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPesel(String value) {
        this.pesel = value;
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
     * Gets the value of the temporaryPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemporaryPassword() {
        return temporaryPassword;
    }

    /**
     * Sets the value of the temporaryPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemporaryPassword(String value) {
        this.temporaryPassword = value;
    }

}
