
package tn.gov.nashville.ws.identityproofing;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SharedCromerrErrorCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SharedCromerrErrorCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="E_Unknown"/>
 *     &lt;enumeration value="E_UnknownUser"/>
 *     &lt;enumeration value="E_InvalidCredential"/>
 *     &lt;enumeration value="E_AccountLocked"/>
 *     &lt;enumeration value="E_AccessDenied"/>
 *     &lt;enumeration value="E_TokenExpired"/>
 *     &lt;enumeration value="E_InvalidToken"/>
 *     &lt;enumeration value="E_InvalidDataflowName"/>
 *     &lt;enumeration value="E_InvalidArgument"/>
 *     &lt;enumeration value="E_InsufficientPrivileges"/>
 *     &lt;enumeration value="E_InvalidSignature"/>
 *     &lt;enumeration value="E_WrongIdPassword"/>
 *     &lt;enumeration value="E_AccountExpired"/>
 *     &lt;enumeration value="E_WrongAnswer"/>
 *     &lt;enumeration value="E_WeakPassword"/>
 *     &lt;enumeration value="E_ReachedMaxNumberOfAttempts"/>
 *     &lt;enumeration value="E_InternalError"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SharedCromerrErrorCode")
@XmlEnum
public enum SharedCromerrErrorCode {

    @XmlEnumValue("E_Unknown")
    E_UNKNOWN("E_Unknown"),
    @XmlEnumValue("E_UnknownUser")
    E_UNKNOWN_USER("E_UnknownUser"),
    @XmlEnumValue("E_InvalidCredential")
    E_INVALID_CREDENTIAL("E_InvalidCredential"),
    @XmlEnumValue("E_AccountLocked")
    E_ACCOUNT_LOCKED("E_AccountLocked"),
    @XmlEnumValue("E_AccessDenied")
    E_ACCESS_DENIED("E_AccessDenied"),
    @XmlEnumValue("E_TokenExpired")
    E_TOKEN_EXPIRED("E_TokenExpired"),
    @XmlEnumValue("E_InvalidToken")
    E_INVALID_TOKEN("E_InvalidToken"),
    @XmlEnumValue("E_InvalidDataflowName")
    E_INVALID_DATAFLOW_NAME("E_InvalidDataflowName"),
    @XmlEnumValue("E_InvalidArgument")
    E_INVALID_ARGUMENT("E_InvalidArgument"),
    @XmlEnumValue("E_InsufficientPrivileges")
    E_INSUFFICIENT_PRIVILEGES("E_InsufficientPrivileges"),
    @XmlEnumValue("E_InvalidSignature")
    E_INVALID_SIGNATURE("E_InvalidSignature"),
    @XmlEnumValue("E_WrongIdPassword")
    E_WRONG_ID_PASSWORD("E_WrongIdPassword"),
    @XmlEnumValue("E_AccountExpired")
    E_ACCOUNT_EXPIRED("E_AccountExpired"),
    @XmlEnumValue("E_WrongAnswer")
    E_WRONG_ANSWER("E_WrongAnswer"),
    @XmlEnumValue("E_WeakPassword")
    E_WEAK_PASSWORD("E_WeakPassword"),
    @XmlEnumValue("E_ReachedMaxNumberOfAttempts")
    E_REACHED_MAX_NUMBER_OF_ATTEMPTS("E_ReachedMaxNumberOfAttempts"),
    @XmlEnumValue("E_InternalError")
    E_INTERNAL_ERROR("E_InternalError");
    private final String value;

    SharedCromerrErrorCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SharedCromerrErrorCode fromValue(String v) {
        for (SharedCromerrErrorCode c: SharedCromerrErrorCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
