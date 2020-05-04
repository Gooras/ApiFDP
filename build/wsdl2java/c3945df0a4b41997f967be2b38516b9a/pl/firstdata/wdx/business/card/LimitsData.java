
package pl.firstdata.wdx.business.card;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for limitsData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="limitsData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="atmCcaLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="atmDepCrLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="atmOfflCcaLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="atmOfflWdlLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="atmUseLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="atmWdlLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="b24AggrLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="b24CcaLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="b24OfflAggrLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="b24OfflCcaLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="b24OfflWdlLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="b24WdlLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="ecUseLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="motoUseLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="offlEcPurLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="offlEcPurWdlLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="offlMotoPurLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="offlMotoPurWdlLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="posCcaLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="posOfflCcaLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="posOfflPurLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="posOfflRfndCrLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="posOfflWdlLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="posPurLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="posRfndCrLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="posUseLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="posWdlLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="ttlEcPurLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="ttlEcPurWdlLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="ttlMotoPurLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="ttlMotoPurWdlLmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "limitsData", propOrder = {
    "atmCcaLmt",
    "atmDepCrLmt",
    "atmOfflCcaLmt",
    "atmOfflWdlLmt",
    "atmUseLmt",
    "atmWdlLmt",
    "b24AggrLmt",
    "b24CcaLmt",
    "b24OfflAggrLmt",
    "b24OfflCcaLmt",
    "b24OfflWdlLmt",
    "b24WdlLmt",
    "ecUseLmt",
    "motoUseLmt",
    "offlEcPurLmt",
    "offlEcPurWdlLmt",
    "offlMotoPurLmt",
    "offlMotoPurWdlLmt",
    "posCcaLmt",
    "posOfflCcaLmt",
    "posOfflPurLmt",
    "posOfflRfndCrLmt",
    "posOfflWdlLmt",
    "posPurLmt",
    "posRfndCrLmt",
    "posUseLmt",
    "posWdlLmt",
    "ttlEcPurLmt",
    "ttlEcPurWdlLmt",
    "ttlMotoPurLmt",
    "ttlMotoPurWdlLmt"
})
public class LimitsData {

    protected Long atmCcaLmt;
    protected Long atmDepCrLmt;
    protected Long atmOfflCcaLmt;
    protected Long atmOfflWdlLmt;
    protected Long atmUseLmt;
    protected Long atmWdlLmt;
    protected Long b24AggrLmt;
    protected Long b24CcaLmt;
    protected Long b24OfflAggrLmt;
    protected Long b24OfflCcaLmt;
    protected Long b24OfflWdlLmt;
    protected Long b24WdlLmt;
    protected Long ecUseLmt;
    protected Long motoUseLmt;
    protected Long offlEcPurLmt;
    protected Long offlEcPurWdlLmt;
    protected Long offlMotoPurLmt;
    protected Long offlMotoPurWdlLmt;
    protected Long posCcaLmt;
    protected Long posOfflCcaLmt;
    protected Long posOfflPurLmt;
    protected Long posOfflRfndCrLmt;
    protected Long posOfflWdlLmt;
    protected Long posPurLmt;
    protected Long posRfndCrLmt;
    protected Long posUseLmt;
    protected Long posWdlLmt;
    protected Long ttlEcPurLmt;
    protected Long ttlEcPurWdlLmt;
    protected Long ttlMotoPurLmt;
    protected Long ttlMotoPurWdlLmt;

    /**
     * Gets the value of the atmCcaLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAtmCcaLmt() {
        return atmCcaLmt;
    }

    /**
     * Sets the value of the atmCcaLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAtmCcaLmt(Long value) {
        this.atmCcaLmt = value;
    }

    /**
     * Gets the value of the atmDepCrLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAtmDepCrLmt() {
        return atmDepCrLmt;
    }

    /**
     * Sets the value of the atmDepCrLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAtmDepCrLmt(Long value) {
        this.atmDepCrLmt = value;
    }

    /**
     * Gets the value of the atmOfflCcaLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAtmOfflCcaLmt() {
        return atmOfflCcaLmt;
    }

    /**
     * Sets the value of the atmOfflCcaLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAtmOfflCcaLmt(Long value) {
        this.atmOfflCcaLmt = value;
    }

    /**
     * Gets the value of the atmOfflWdlLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAtmOfflWdlLmt() {
        return atmOfflWdlLmt;
    }

    /**
     * Sets the value of the atmOfflWdlLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAtmOfflWdlLmt(Long value) {
        this.atmOfflWdlLmt = value;
    }

    /**
     * Gets the value of the atmUseLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAtmUseLmt() {
        return atmUseLmt;
    }

    /**
     * Sets the value of the atmUseLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAtmUseLmt(Long value) {
        this.atmUseLmt = value;
    }

    /**
     * Gets the value of the atmWdlLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAtmWdlLmt() {
        return atmWdlLmt;
    }

    /**
     * Sets the value of the atmWdlLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAtmWdlLmt(Long value) {
        this.atmWdlLmt = value;
    }

    /**
     * Gets the value of the b24AggrLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getB24AggrLmt() {
        return b24AggrLmt;
    }

    /**
     * Sets the value of the b24AggrLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setB24AggrLmt(Long value) {
        this.b24AggrLmt = value;
    }

    /**
     * Gets the value of the b24CcaLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getB24CcaLmt() {
        return b24CcaLmt;
    }

    /**
     * Sets the value of the b24CcaLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setB24CcaLmt(Long value) {
        this.b24CcaLmt = value;
    }

    /**
     * Gets the value of the b24OfflAggrLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getB24OfflAggrLmt() {
        return b24OfflAggrLmt;
    }

    /**
     * Sets the value of the b24OfflAggrLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setB24OfflAggrLmt(Long value) {
        this.b24OfflAggrLmt = value;
    }

    /**
     * Gets the value of the b24OfflCcaLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getB24OfflCcaLmt() {
        return b24OfflCcaLmt;
    }

    /**
     * Sets the value of the b24OfflCcaLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setB24OfflCcaLmt(Long value) {
        this.b24OfflCcaLmt = value;
    }

    /**
     * Gets the value of the b24OfflWdlLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getB24OfflWdlLmt() {
        return b24OfflWdlLmt;
    }

    /**
     * Sets the value of the b24OfflWdlLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setB24OfflWdlLmt(Long value) {
        this.b24OfflWdlLmt = value;
    }

    /**
     * Gets the value of the b24WdlLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getB24WdlLmt() {
        return b24WdlLmt;
    }

    /**
     * Sets the value of the b24WdlLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setB24WdlLmt(Long value) {
        this.b24WdlLmt = value;
    }

    /**
     * Gets the value of the ecUseLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEcUseLmt() {
        return ecUseLmt;
    }

    /**
     * Sets the value of the ecUseLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEcUseLmt(Long value) {
        this.ecUseLmt = value;
    }

    /**
     * Gets the value of the motoUseLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMotoUseLmt() {
        return motoUseLmt;
    }

    /**
     * Sets the value of the motoUseLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMotoUseLmt(Long value) {
        this.motoUseLmt = value;
    }

    /**
     * Gets the value of the offlEcPurLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOfflEcPurLmt() {
        return offlEcPurLmt;
    }

    /**
     * Sets the value of the offlEcPurLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOfflEcPurLmt(Long value) {
        this.offlEcPurLmt = value;
    }

    /**
     * Gets the value of the offlEcPurWdlLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOfflEcPurWdlLmt() {
        return offlEcPurWdlLmt;
    }

    /**
     * Sets the value of the offlEcPurWdlLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOfflEcPurWdlLmt(Long value) {
        this.offlEcPurWdlLmt = value;
    }

    /**
     * Gets the value of the offlMotoPurLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOfflMotoPurLmt() {
        return offlMotoPurLmt;
    }

    /**
     * Sets the value of the offlMotoPurLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOfflMotoPurLmt(Long value) {
        this.offlMotoPurLmt = value;
    }

    /**
     * Gets the value of the offlMotoPurWdlLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOfflMotoPurWdlLmt() {
        return offlMotoPurWdlLmt;
    }

    /**
     * Sets the value of the offlMotoPurWdlLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOfflMotoPurWdlLmt(Long value) {
        this.offlMotoPurWdlLmt = value;
    }

    /**
     * Gets the value of the posCcaLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPosCcaLmt() {
        return posCcaLmt;
    }

    /**
     * Sets the value of the posCcaLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPosCcaLmt(Long value) {
        this.posCcaLmt = value;
    }

    /**
     * Gets the value of the posOfflCcaLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPosOfflCcaLmt() {
        return posOfflCcaLmt;
    }

    /**
     * Sets the value of the posOfflCcaLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPosOfflCcaLmt(Long value) {
        this.posOfflCcaLmt = value;
    }

    /**
     * Gets the value of the posOfflPurLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPosOfflPurLmt() {
        return posOfflPurLmt;
    }

    /**
     * Sets the value of the posOfflPurLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPosOfflPurLmt(Long value) {
        this.posOfflPurLmt = value;
    }

    /**
     * Gets the value of the posOfflRfndCrLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPosOfflRfndCrLmt() {
        return posOfflRfndCrLmt;
    }

    /**
     * Sets the value of the posOfflRfndCrLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPosOfflRfndCrLmt(Long value) {
        this.posOfflRfndCrLmt = value;
    }

    /**
     * Gets the value of the posOfflWdlLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPosOfflWdlLmt() {
        return posOfflWdlLmt;
    }

    /**
     * Sets the value of the posOfflWdlLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPosOfflWdlLmt(Long value) {
        this.posOfflWdlLmt = value;
    }

    /**
     * Gets the value of the posPurLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPosPurLmt() {
        return posPurLmt;
    }

    /**
     * Sets the value of the posPurLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPosPurLmt(Long value) {
        this.posPurLmt = value;
    }

    /**
     * Gets the value of the posRfndCrLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPosRfndCrLmt() {
        return posRfndCrLmt;
    }

    /**
     * Sets the value of the posRfndCrLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPosRfndCrLmt(Long value) {
        this.posRfndCrLmt = value;
    }

    /**
     * Gets the value of the posUseLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPosUseLmt() {
        return posUseLmt;
    }

    /**
     * Sets the value of the posUseLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPosUseLmt(Long value) {
        this.posUseLmt = value;
    }

    /**
     * Gets the value of the posWdlLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPosWdlLmt() {
        return posWdlLmt;
    }

    /**
     * Sets the value of the posWdlLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPosWdlLmt(Long value) {
        this.posWdlLmt = value;
    }

    /**
     * Gets the value of the ttlEcPurLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTtlEcPurLmt() {
        return ttlEcPurLmt;
    }

    /**
     * Sets the value of the ttlEcPurLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTtlEcPurLmt(Long value) {
        this.ttlEcPurLmt = value;
    }

    /**
     * Gets the value of the ttlEcPurWdlLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTtlEcPurWdlLmt() {
        return ttlEcPurWdlLmt;
    }

    /**
     * Sets the value of the ttlEcPurWdlLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTtlEcPurWdlLmt(Long value) {
        this.ttlEcPurWdlLmt = value;
    }

    /**
     * Gets the value of the ttlMotoPurLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTtlMotoPurLmt() {
        return ttlMotoPurLmt;
    }

    /**
     * Sets the value of the ttlMotoPurLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTtlMotoPurLmt(Long value) {
        this.ttlMotoPurLmt = value;
    }

    /**
     * Gets the value of the ttlMotoPurWdlLmt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTtlMotoPurWdlLmt() {
        return ttlMotoPurWdlLmt;
    }

    /**
     * Sets the value of the ttlMotoPurWdlLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTtlMotoPurWdlLmt(Long value) {
        this.ttlMotoPurWdlLmt = value;
    }

}
