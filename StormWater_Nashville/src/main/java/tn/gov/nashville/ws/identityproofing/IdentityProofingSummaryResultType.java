
package tn.gov.nashville.ws.identityproofing;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IdentityProofingSummaryResultType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IdentityProofingSummaryResultType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CROMERR_Minimum"/>
 *     &lt;enumeration value="CROMERR_Exceeded"/>
 *     &lt;enumeration value="CROMERR_NotMet"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IdentityProofingSummaryResultType")
@XmlEnum
public enum IdentityProofingSummaryResultType {

    @XmlEnumValue("CROMERR_Minimum")
    CROMERR_MINIMUM("CROMERR_Minimum"),
    @XmlEnumValue("CROMERR_Exceeded")
    CROMERR_EXCEEDED("CROMERR_Exceeded"),
    @XmlEnumValue("CROMERR_NotMet")
    CROMERR_NOT_MET("CROMERR_NotMet");
    private final String value;

    IdentityProofingSummaryResultType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IdentityProofingSummaryResultType fromValue(String v) {
        for (IdentityProofingSummaryResultType c: IdentityProofingSummaryResultType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
