
package pl.firstdata.wdx.business.card;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setCtlsRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setCtlsRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cardNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ctlsState" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="sendScript" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setCtlsRequest", propOrder = {
    "cardNumber",
    "ctlsState",
    "sendScript"
})
public class SetCtlsRequest {

    @XmlElement(required = true)
    protected String cardNumber;
    protected int ctlsState;
    @XmlElement(required = true)
    protected String sendScript;

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
     * Gets the value of the ctlsState property.
     * 
     */
    public int getCtlsState() {
        return ctlsState;
    }

    /**
     * Sets the value of the ctlsState property.
     * 
     */
    public void setCtlsState(int value) {
        this.ctlsState = value;
    }

    /**
     * Gets the value of the sendScript property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendScript() {
        return sendScript;
    }

    /**
     * Sets the value of the sendScript property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendScript(String value) {
        this.sendScript = value;
    }

}
