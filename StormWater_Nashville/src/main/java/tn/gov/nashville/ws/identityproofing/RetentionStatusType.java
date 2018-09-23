
package tn.gov.nashville.ws.identityproofing;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetentionStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RetentionStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Default"/>
 *     &lt;enumeration value="HeldForEnforcement"/>
 *     &lt;enumeration value="Repudiated"/>
 *     &lt;enumeration value="Expired"/>
 *     &lt;enumeration value="Rescinded"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RetentionStatusType")
@XmlEnum
public enum RetentionStatusType {

    @XmlEnumValue("Default")
    DEFAULT("Default"),
    @XmlEnumValue("HeldForEnforcement")
    HELD_FOR_ENFORCEMENT("HeldForEnforcement"),
    @XmlEnumValue("Repudiated")
    REPUDIATED("Repudiated"),
    @XmlEnumValue("Expired")
    EXPIRED("Expired"),
    @XmlEnumValue("Rescinded")
    RESCINDED("Rescinded");
    private final String value;

    RetentionStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RetentionStatusType fromValue(String v) {
        for (RetentionStatusType c: RetentionStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
