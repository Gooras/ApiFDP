
package pl.firstdata.wdx.business.card;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import pl.firstdata.wdx.business.card.v5.OperationResult;


/**
 * <p>Java class for readCtlsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readCtlsResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.firstdata.pl/wdx/business/card/v5/}operationResult"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ctlsResponseData" type="{http://www.firstdata.pl/wdx/business/card/}ctlsResponseData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readCtlsResponse", propOrder = {
    "ctlsResponseData"
})
public class ReadCtlsResponse
    extends OperationResult
{

    protected CtlsResponseData ctlsResponseData;

    /**
     * Gets the value of the ctlsResponseData property.
     * 
     * @return
     *     possible object is
     *     {@link CtlsResponseData }
     *     
     */
    public CtlsResponseData getCtlsResponseData() {
        return ctlsResponseData;
    }

    /**
     * Sets the value of the ctlsResponseData property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtlsResponseData }
     *     
     */
    public void setCtlsResponseData(CtlsResponseData value) {
        this.ctlsResponseData = value;
    }

}
