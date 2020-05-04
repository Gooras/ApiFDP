
package pl.firstdata.wdx.business.card;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for userDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="activeFlag" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="address1" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="address2" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="binTypeId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="birthDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="chip" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dateIn" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="dbAtmLimit" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="dbLimit" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="expiryDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="maidenName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="postCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sms" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="totalLimit" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="txnAtmLimit" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="txnLimit" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userDetails", propOrder = {
    "activeFlag",
    "address1",
    "address2",
    "binTypeId",
    "birthDate",
    "chip",
    "city",
    "dateIn",
    "dbAtmLimit",
    "dbLimit",
    "description",
    "email",
    "expiryDate",
    "firstName",
    "lastName",
    "maidenName",
    "postCode",
    "sms",
    "totalLimit",
    "txnAtmLimit",
    "txnLimit"
})
public class UserDetails {

    @XmlElement(required = true)
    protected String activeFlag;
    @XmlElement(required = true)
    protected String address1;
    @XmlElement(required = true)
    protected String address2;
    @XmlElement(required = true)
    protected String binTypeId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthDate;
    @XmlElement(required = true)
    protected String chip;
    @XmlElement(required = true)
    protected String city;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateIn;
    protected long dbAtmLimit;
    protected long dbLimit;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String email;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar expiryDate;
    @XmlElement(required = true)
    protected String firstName;
    @XmlElement(required = true)
    protected String lastName;
    @XmlElement(required = true)
    protected String maidenName;
    @XmlElement(required = true)
    protected String postCode;
    @XmlElement(required = true)
    protected String sms;
    protected long totalLimit;
    protected long txnAtmLimit;
    protected long txnLimit;

    /**
     * Gets the value of the activeFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActiveFlag() {
        return activeFlag;
    }

    /**
     * Sets the value of the activeFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActiveFlag(String value) {
        this.activeFlag = value;
    }

    /**
     * Gets the value of the address1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * Sets the value of the address1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress1(String value) {
        this.address1 = value;
    }

    /**
     * Gets the value of the address2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * Sets the value of the address2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress2(String value) {
        this.address2 = value;
    }

    /**
     * Gets the value of the binTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBinTypeId() {
        return binTypeId;
    }

    /**
     * Sets the value of the binTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBinTypeId(String value) {
        this.binTypeId = value;
    }

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthDate(XMLGregorianCalendar value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the chip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChip() {
        return chip;
    }

    /**
     * Sets the value of the chip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChip(String value) {
        this.chip = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the dateIn property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateIn() {
        return dateIn;
    }

    /**
     * Sets the value of the dateIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateIn(XMLGregorianCalendar value) {
        this.dateIn = value;
    }

    /**
     * Gets the value of the dbAtmLimit property.
     * 
     */
    public long getDbAtmLimit() {
        return dbAtmLimit;
    }

    /**
     * Sets the value of the dbAtmLimit property.
     * 
     */
    public void setDbAtmLimit(long value) {
        this.dbAtmLimit = value;
    }

    /**
     * Gets the value of the dbLimit property.
     * 
     */
    public long getDbLimit() {
        return dbLimit;
    }

    /**
     * Sets the value of the dbLimit property.
     * 
     */
    public void setDbLimit(long value) {
        this.dbLimit = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
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
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
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
     * Gets the value of the postCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Sets the value of the postCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostCode(String value) {
        this.postCode = value;
    }

    /**
     * Gets the value of the sms property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSms() {
        return sms;
    }

    /**
     * Sets the value of the sms property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSms(String value) {
        this.sms = value;
    }

    /**
     * Gets the value of the totalLimit property.
     * 
     */
    public long getTotalLimit() {
        return totalLimit;
    }

    /**
     * Sets the value of the totalLimit property.
     * 
     */
    public void setTotalLimit(long value) {
        this.totalLimit = value;
    }

    /**
     * Gets the value of the txnAtmLimit property.
     * 
     */
    public long getTxnAtmLimit() {
        return txnAtmLimit;
    }

    /**
     * Sets the value of the txnAtmLimit property.
     * 
     */
    public void setTxnAtmLimit(long value) {
        this.txnAtmLimit = value;
    }

    /**
     * Gets the value of the txnLimit property.
     * 
     */
    public long getTxnLimit() {
        return txnLimit;
    }

    /**
     * Sets the value of the txnLimit property.
     * 
     */
    public void setTxnLimit(long value) {
        this.txnLimit = value;
    }

}
