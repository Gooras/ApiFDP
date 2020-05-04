
package pl.firstdata.wdx.business.card.v5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import pl.firstdata.wdx.business.card.CardBalance;
import pl.firstdata.wdx.business.card.CardIdResponse;
import pl.firstdata.wdx.business.card.CardIssuingResponse;
import pl.firstdata.wdx.business.card.CardStatus;
import pl.firstdata.wdx.business.card.CrtaResponse;
import pl.firstdata.wdx.business.card.GetTokenResponse;
import pl.firstdata.wdx.business.card.GetUserDetailsResponse;
import pl.firstdata.wdx.business.card.ReadCtlsResponse;
import pl.firstdata.wdx.business.card.ReadLimitsResponse;
import pl.firstdata.wdx.business.card.SecureCodeResult;


/**
 * <p>Java class for operationResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="operationResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="responseDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="responseTime" type="{http://www.w3.org/2001/XMLSchema}time"/&gt;
 *         &lt;element name="wdxMessageId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="wdxResponseCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "operationResult", propOrder = {
    "responseDate",
    "responseTime",
    "wdxMessageId",
    "wdxResponseCode"
})
@XmlSeeAlso({
    CardIssuingResponse.class,
    CardBalance.class,
    CardStatus.class,
    GetTokenResponse.class,
    GetUserDetailsResponse.class,
    CardIdResponse.class,
    CrtaResponse.class,
    ReadCtlsResponse.class,
    ReadLimitsResponse.class,
    SecureCodeResult.class
})
public class OperationResult {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar responseDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar responseTime;
    protected long wdxMessageId;
    @XmlElement(required = true)
    protected String wdxResponseCode;

    /**
     * Gets the value of the responseDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getResponseDate() {
        return responseDate;
    }

    /**
     * Sets the value of the responseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setResponseDate(XMLGregorianCalendar value) {
        this.responseDate = value;
    }

    /**
     * Gets the value of the responseTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getResponseTime() {
        return responseTime;
    }

    /**
     * Sets the value of the responseTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setResponseTime(XMLGregorianCalendar value) {
        this.responseTime = value;
    }

    /**
     * Gets the value of the wdxMessageId property.
     * 
     */
    public long getWdxMessageId() {
        return wdxMessageId;
    }

    /**
     * Sets the value of the wdxMessageId property.
     * 
     */
    public void setWdxMessageId(long value) {
        this.wdxMessageId = value;
    }

    /**
     * Gets the value of the wdxResponseCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWdxResponseCode() {
        return wdxResponseCode;
    }

    /**
     * Sets the value of the wdxResponseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWdxResponseCode(String value) {
        this.wdxResponseCode = value;
    }

}
