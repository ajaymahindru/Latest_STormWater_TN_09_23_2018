
package tn.gov.nashville.ws.identityproofing;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IdentityProofingResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IdentityProofingResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{http://www.exchangenetwork.net/schema/sharedcromerr/1}IdentityProofingStatusType"/>
 *         &lt;element name="StatusDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RawResults" type="{http://www.exchangenetwork.net/schema/sharedcromerr/1}DocumentType" minOccurs="0"/>
 *         &lt;element name="SummaryResult" type="{http://www.exchangenetwork.net/schema/sharedcromerr/1}IdentityProofingSummaryResultType" minOccurs="0"/>
 *         &lt;element name="SummaryResultDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentityProofingResultType", propOrder = {
    "status",
    "statusDescription",
    "rawResults",
    "summaryResult",
    "summaryResultDescription"
})
public class IdentityProofingResultType {

    @XmlElement(name = "Status", required = true)
    @XmlSchemaType(name = "string")
    protected IdentityProofingStatusType status;
    @XmlElement(name = "StatusDescription")
    protected String statusDescription;
    @XmlElement(name = "RawResults")
    protected DocumentType rawResults;
    @XmlElement(name = "SummaryResult")
    @XmlSchemaType(name = "string")
    protected IdentityProofingSummaryResultType summaryResult;
    @XmlElement(name = "SummaryResultDescription")
    protected String summaryResultDescription;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link IdentityProofingStatusType }
     *     
     */
    public IdentityProofingStatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentityProofingStatusType }
     *     
     */
    public void setStatus(IdentityProofingStatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusDescription() {
        return statusDescription;
    }

    /**
     * Sets the value of the statusDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusDescription(String value) {
        this.statusDescription = value;
    }

    /**
     * Gets the value of the rawResults property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentType }
     *     
     */
    public DocumentType getRawResults() {
        return rawResults;
    }

    /**
     * Sets the value of the rawResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentType }
     *     
     */
    public void setRawResults(DocumentType value) {
        this.rawResults = value;
    }

    /**
     * Gets the value of the summaryResult property.
     * 
     * @return
     *     possible object is
     *     {@link IdentityProofingSummaryResultType }
     *     
     */
    public IdentityProofingSummaryResultType getSummaryResult() {
        return summaryResult;
    }

    /**
     * Sets the value of the summaryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentityProofingSummaryResultType }
     *     
     */
    public void setSummaryResult(IdentityProofingSummaryResultType value) {
        this.summaryResult = value;
    }

    /**
     * Gets the value of the summaryResultDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSummaryResultDescription() {
        return summaryResultDescription;
    }

    /**
     * Sets the value of the summaryResultDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSummaryResultDescription(String value) {
        this.summaryResultDescription = value;
    }

}
