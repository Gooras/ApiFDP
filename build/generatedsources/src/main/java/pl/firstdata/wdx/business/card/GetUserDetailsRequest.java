
package pl.firstdata.wdx.business.card;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getUserDetailsRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getUserDetailsRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="externalServiceClientId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="externalServiceId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUserDetailsRequest", propOrder = {
    "externalServiceClientId",
    "externalServiceId"
})
public class GetUserDetailsRequest {

    @XmlElement(required = true)
    protected String externalServiceClientId;
    @XmlElement(required = true)
    protected String externalServiceId;

    /**
     * Gets the value of the externalServiceClientId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalServiceClientId() {
        return externalServiceClientId;
    }

    /**
     * Sets the value of the externalServiceClientId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalServiceClientId(String value) {
        this.externalServiceClientId = value;
    }

    /**
     * Gets the value of the externalServiceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalServiceId() {
        return externalServiceId;
    }

    /**
     * Sets the value of the externalServiceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalServiceId(String value) {
        this.externalServiceId = value;
    }

}
