
package pl.firstdata.wdx.business.card;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import pl.firstdata.wdx.business.card.v5.OperationResult;


/**
 * <p>Java class for cardIssuingResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cardIssuingResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.firstdata.pl/wdx/business/card/v5/}operationResult"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cardExpiryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cardNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cardIssuingResponse", propOrder = {
    "cardExpiryDate",
    "cardNumber"
})
public class CardIssuingResponse
    extends OperationResult
{

    protected String cardExpiryDate;
    protected String cardNumber;

    /**
     * Gets the value of the cardExpiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    /**
     * Sets the value of the cardExpiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardExpiryDate(String value) {
        this.cardExpiryDate = value;
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

}
