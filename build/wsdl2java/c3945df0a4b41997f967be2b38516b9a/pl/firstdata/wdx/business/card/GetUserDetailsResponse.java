
package pl.firstdata.wdx.business.card;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pl.firstdata.wdx.business.card.v5.OperationResult;


/**
 * <p>Java class for getUserDetailsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getUserDetailsResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.firstdata.pl/wdx/business/card/v5/}operationResult"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userDetails" type="{http://www.firstdata.pl/wdx/business/card/}userDetails" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUserDetailsResponse", propOrder = {
    "userDetails"
})
public class GetUserDetailsResponse
    extends OperationResult
{

    @XmlElement(nillable = true)
    protected List<UserDetails> userDetails;

    /**
     * Gets the value of the userDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserDetails }
     * 
     * 
     */
    public List<UserDetails> getUserDetails() {
        if (userDetails == null) {
            userDetails = new ArrayList<UserDetails>();
        }
        return this.userDetails;
    }

}
