
package pl.firstdata.wdx.business.card;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import pl.firstdata.wdx.business.card.v5.OperationResult;


/**
 * <p>Java class for readLimitsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readLimitsResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.firstdata.pl/wdx/business/card/v5/}operationResult"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="limitsData" type="{http://www.firstdata.pl/wdx/business/card/}limitsData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readLimitsResponse", propOrder = {
    "limitsData"
})
public class ReadLimitsResponse
    extends OperationResult
{

    protected LimitsData limitsData;

    /**
     * Gets the value of the limitsData property.
     * 
     * @return
     *     possible object is
     *     {@link LimitsData }
     *     
     */
    public LimitsData getLimitsData() {
        return limitsData;
    }

    /**
     * Sets the value of the limitsData property.
     * 
     * @param value
     *     allowed object is
     *     {@link LimitsData }
     *     
     */
    public void setLimitsData(LimitsData value) {
        this.limitsData = value;
    }

}
