
package pl.firstdata.wdx.business.card;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for enrollCHRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="enrollCHRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="atmLimit" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cardNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="clientName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cnpLimit" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="daysNot" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="expiryDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="internLimit" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="langId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="packageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="posLimit" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enrollCHRequest", propOrder = {
    "atmLimit",
    "cardNumber",
    "clientName",
    "cnpLimit",
    "daysNot",
    "expiryDate",
    "internLimit",
    "langId",
    "message",
    "packageName",
    "phoneNumber",
    "posLimit",
    "status"
})
public class EnrollCHRequest {

    protected int atmLimit;
    @XmlElement(required = true)
    protected String cardNumber;
    protected String clientName;
    protected int cnpLimit;
    protected int daysNot;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar expiryDate;
    protected int internLimit;
    protected String langId;
    protected String message;
    protected String packageName;
    @XmlElement(required = true)
    protected String phoneNumber;
    protected int posLimit;
    protected String status;

    /**
     * Gets the value of the atmLimit property.
     * 
     */
    public int getAtmLimit() {
        return atmLimit;
    }

    /**
     * Sets the value of the atmLimit property.
     * 
     */
    public void setAtmLimit(int value) {
        this.atmLimit = value;
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
     * Gets the value of the clientName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Sets the value of the clientName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientName(String value) {
        this.clientName = value;
    }

    /**
     * Gets the value of the cnpLimit property.
     * 
     */
    public int getCnpLimit() {
        return cnpLimit;
    }

    /**
     * Sets the value of the cnpLimit property.
     * 
     */
    public void setCnpLimit(int value) {
        this.cnpLimit = value;
    }

    /**
     * Gets the value of the daysNot property.
     * 
     */
    public int getDaysNot() {
        return daysNot;
    }

    /**
     * Sets the value of the daysNot property.
     * 
     */
    public void setDaysNot(int value) {
        this.daysNot = value;
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
     * Gets the value of the internLimit property.
     * 
     */
    public int getInternLimit() {
        return internLimit;
    }

    /**
     * Sets the value of the internLimit property.
     * 
     */
    public void setInternLimit(int value) {
        this.internLimit = value;
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
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the packageName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * Sets the value of the packageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageName(String value) {
        this.packageName = value;
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
     * Gets the value of the posLimit property.
     * 
     */
    public int getPosLimit() {
        return posLimit;
    }

    /**
     * Sets the value of the posLimit property.
     * 
     */
    public void setPosLimit(int value) {
        this.posLimit = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
