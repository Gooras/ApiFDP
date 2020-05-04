
package pl.firstdata.wdx.business.card;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import pl.firstdata.wdx.business.card.v5.OperationResult;


/**
 * <p>Java class for crtaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="crtaResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.firstdata.pl/wdx/business/card/v5/}operationResult"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="atmLimit" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="cnpLimit" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="crtaEnroll" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="intrnLimit" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="langId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="posLimit" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crtaResponse", propOrder = {
    "atmLimit",
    "cnpLimit",
    "crtaEnroll",
    "intrnLimit",
    "langId",
    "phoneNumber",
    "posLimit"
})
public class CrtaResponse
    extends OperationResult
{

    protected Integer atmLimit;
    protected Integer cnpLimit;
    protected String crtaEnroll;
    protected Integer intrnLimit;
    protected String langId;
    protected String phoneNumber;
    protected Integer posLimit;

    /**
     * Gets the value of the atmLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAtmLimit() {
        return atmLimit;
    }

    /**
     * Sets the value of the atmLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAtmLimit(Integer value) {
        this.atmLimit = value;
    }

    /**
     * Gets the value of the cnpLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCnpLimit() {
        return cnpLimit;
    }

    /**
     * Sets the value of the cnpLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCnpLimit(Integer value) {
        this.cnpLimit = value;
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
     * Gets the value of the intrnLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIntrnLimit() {
        return intrnLimit;
    }

    /**
     * Sets the value of the intrnLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIntrnLimit(Integer value) {
        this.intrnLimit = value;
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

    /**
     * Gets the value of the posLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPosLimit() {
        return posLimit;
    }

    /**
     * Sets the value of the posLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPosLimit(Integer value) {
        this.posLimit = value;
    }

}
