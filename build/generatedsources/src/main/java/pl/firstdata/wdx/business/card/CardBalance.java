
package pl.firstdata.wdx.business.card;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import pl.firstdata.wdx.business.card.v5.OperationResult;


/**
 * <p>Java class for cardBalance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cardBalance"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.firstdata.pl/wdx/business/card/v5/}operationResult"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountCashOTB" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="accountTotalOTB" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="availableCashFunds" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="availableTotalFunds" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="bonus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="bonusExpiryDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="cardCashOTB" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="cardStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cardTotalOTB" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cardBalance", propOrder = {
    "accountCashOTB",
    "accountTotalOTB",
    "availableCashFunds",
    "availableTotalFunds",
    "bonus",
    "bonusExpiryDate",
    "cardCashOTB",
    "cardStatus",
    "cardTotalOTB"
})
public class CardBalance
    extends OperationResult
{

    protected Long accountCashOTB;
    protected Long accountTotalOTB;
    protected Long availableCashFunds;
    protected Long availableTotalFunds;
    protected Long bonus;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar bonusExpiryDate;
    protected Long cardCashOTB;
    protected String cardStatus;
    protected Long cardTotalOTB;

    /**
     * Gets the value of the accountCashOTB property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccountCashOTB() {
        return accountCashOTB;
    }

    /**
     * Sets the value of the accountCashOTB property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccountCashOTB(Long value) {
        this.accountCashOTB = value;
    }

    /**
     * Gets the value of the accountTotalOTB property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccountTotalOTB() {
        return accountTotalOTB;
    }

    /**
     * Sets the value of the accountTotalOTB property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccountTotalOTB(Long value) {
        this.accountTotalOTB = value;
    }

    /**
     * Gets the value of the availableCashFunds property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAvailableCashFunds() {
        return availableCashFunds;
    }

    /**
     * Sets the value of the availableCashFunds property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAvailableCashFunds(Long value) {
        this.availableCashFunds = value;
    }

    /**
     * Gets the value of the availableTotalFunds property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAvailableTotalFunds() {
        return availableTotalFunds;
    }

    /**
     * Sets the value of the availableTotalFunds property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAvailableTotalFunds(Long value) {
        this.availableTotalFunds = value;
    }

    /**
     * Gets the value of the bonus property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBonus() {
        return bonus;
    }

    /**
     * Sets the value of the bonus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBonus(Long value) {
        this.bonus = value;
    }

    /**
     * Gets the value of the bonusExpiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBonusExpiryDate() {
        return bonusExpiryDate;
    }

    /**
     * Sets the value of the bonusExpiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBonusExpiryDate(XMLGregorianCalendar value) {
        this.bonusExpiryDate = value;
    }

    /**
     * Gets the value of the cardCashOTB property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCardCashOTB() {
        return cardCashOTB;
    }

    /**
     * Sets the value of the cardCashOTB property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCardCashOTB(Long value) {
        this.cardCashOTB = value;
    }

    /**
     * Gets the value of the cardStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardStatus() {
        return cardStatus;
    }

    /**
     * Sets the value of the cardStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardStatus(String value) {
        this.cardStatus = value;
    }

    /**
     * Gets the value of the cardTotalOTB property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCardTotalOTB() {
        return cardTotalOTB;
    }

    /**
     * Sets the value of the cardTotalOTB property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCardTotalOTB(Long value) {
        this.cardTotalOTB = value;
    }

}
