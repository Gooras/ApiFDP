
package pl.firstdata.wdx.business.card;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ctlsResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ctlsResponseData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ctlsState" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="scriptState" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ctlsResponseData", propOrder = {
    "ctlsState",
    "scriptState"
})
public class CtlsResponseData {

    protected int ctlsState;
    @XmlElement(required = true)
    protected String scriptState;

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
     * Gets the value of the scriptState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScriptState() {
        return scriptState;
    }

    /**
     * Sets the value of the scriptState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScriptState(String value) {
        this.scriptState = value;
    }

}
