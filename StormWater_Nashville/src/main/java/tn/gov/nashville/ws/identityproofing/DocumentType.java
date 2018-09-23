
package tn.gov.nashville.ws.identityproofing;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Format" type="{http://www.exchangenetwork.net/schema/sharedcromerr/1}DocumentFormatType"/>
 *         &lt;element name="CreatedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="RetentionStatus" type="{http://www.exchangenetwork.net/schema/sharedcromerr/1}RetentionStatusType" minOccurs="0"/>
 *         &lt;element name="RepudiationInfo" type="{http://www.exchangenetwork.net/schema/sharedcromerr/1}RepudiationInfoType" minOccurs="0"/>
 *         &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentType", propOrder = {
    "id",
    "name",
    "format",
    "createdDate",
    "retentionStatus",
    "repudiationInfo",
    "content"
})
public class DocumentType {

    @XmlElement(name = "ID")
    protected String id;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Format", required = true)
    @XmlSchemaType(name = "string")
    protected DocumentFormatType format;
    @XmlElement(name = "CreatedDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDate;
    @XmlElement(name = "RetentionStatus")
    @XmlSchemaType(name = "string")
    protected RetentionStatusType retentionStatus;
    @XmlElement(name = "RepudiationInfo")
    protected RepudiationInfoType repudiationInfo;
    @XmlElement(name = "Content")
    @XmlMimeType("*/*")
    protected DataHandler content;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentFormatType }
     *     
     */
    public DocumentFormatType getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentFormatType }
     *     
     */
    public void setFormat(DocumentFormatType value) {
        this.format = value;
    }

    /**
     * Gets the value of the createdDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the value of the createdDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedDate(XMLGregorianCalendar value) {
        this.createdDate = value;
    }

    /**
     * Gets the value of the retentionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link RetentionStatusType }
     *     
     */
    public RetentionStatusType getRetentionStatus() {
        return retentionStatus;
    }

    /**
     * Sets the value of the retentionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetentionStatusType }
     *     
     */
    public void setRetentionStatus(RetentionStatusType value) {
        this.retentionStatus = value;
    }

    /**
     * Gets the value of the repudiationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link RepudiationInfoType }
     *     
     */
    public RepudiationInfoType getRepudiationInfo() {
        return repudiationInfo;
    }

    /**
     * Sets the value of the repudiationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link RepudiationInfoType }
     *     
     */
    public void setRepudiationInfo(RepudiationInfoType value) {
        this.repudiationInfo = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link DataHandler }
     *     
     */
    public DataHandler getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataHandler }
     *     
     */
    public void setContent(DataHandler value) {
        this.content = value;
    }

}
