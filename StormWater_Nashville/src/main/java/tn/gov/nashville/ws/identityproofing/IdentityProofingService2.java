
package tn.gov.nashville.ws.identityproofing;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IdentityProofingService2", targetNamespace = "http://www.exchangenetwork.net/wsdl/sharedcromerr/identity/2")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IdentityProofingService2 {


    /**
     * 
     * @param securityToken
     * @param activityId
     * @param user
     * @throws SharedCromerrException
     */
    @WebMethod(operationName = "CreateRequest", action = "CreateRequest")
    @RequestWrapper(localName = "CreateRequest", targetNamespace = "http://www.exchangenetwork.net/schema/sharedcromerr/1", className = "tn.gov.nashville.ws.identityproofing.CreateRequest")
    @ResponseWrapper(localName = "CreateRequestResponse", targetNamespace = "http://www.exchangenetwork.net/schema/sharedcromerr/1", className = "tn.gov.nashville.ws.identityproofing.CreateRequestResponse")
    public void createRequest(
        @WebParam(name = "securityToken", targetNamespace = "")
        String securityToken,
        @WebParam(name = "activityId", targetNamespace = "")
        String activityId,
        @WebParam(name = "user", targetNamespace = "")
        IdentityProofingFullUserType user)
        throws SharedCromerrException
    ;

    /**
     * 
     * @param credential
     * @param adminId
     * @return
     *     returns java.lang.String
     * @throws SharedCromerrException
     */
    @WebMethod(operationName = "Authenticate", action = "Authenticate")
    @WebResult(name = "securityToken", targetNamespace = "")
    @RequestWrapper(localName = "Authenticate", targetNamespace = "http://www.exchangenetwork.net/schema/sharedcromerr/1", className = "tn.gov.nashville.ws.identityproofing.Authenticate")
    @ResponseWrapper(localName = "AuthenticateResponse", targetNamespace = "http://www.exchangenetwork.net/schema/sharedcromerr/1", className = "tn.gov.nashville.ws.identityproofing.AuthenticateResponse")
    public String authenticate(
        @WebParam(name = "adminId", targetNamespace = "")
        String adminId,
        @WebParam(name = "credential", targetNamespace = "")
        String credential)
        throws SharedCromerrException
    ;

    /**
     * 
     * @param securityToken
     * @param activityId
     * @return
     *     returns tn.gov.nashville.ws.identityproofing.IdentityProofingResultType
     * @throws SharedCromerrException
     */
    @WebMethod(operationName = "GetResult", action = "GetResult")
    @WebResult(name = "result", targetNamespace = "")
    @RequestWrapper(localName = "GetResult", targetNamespace = "http://www.exchangenetwork.net/schema/sharedcromerr/1", className = "tn.gov.nashville.ws.identityproofing.GetResult")
    @ResponseWrapper(localName = "GetResultResponse", targetNamespace = "http://www.exchangenetwork.net/schema/sharedcromerr/1", className = "tn.gov.nashville.ws.identityproofing.GetResultResponse")
    public IdentityProofingResultType getResult(
        @WebParam(name = "securityToken", targetNamespace = "")
        String securityToken,
        @WebParam(name = "activityId", targetNamespace = "")
        String activityId)
        throws SharedCromerrException
    ;

    /**
     * 
     * @param securityToken
     * @param dataflow
     * @param user
     * @param properties
     * @return
     *     returns java.lang.String
     * @throws SharedCromerrException
     */
    @WebMethod(operationName = "CreateActivity", action = "CreateActivity")
    @WebResult(name = "activityId", targetNamespace = "")
    @RequestWrapper(localName = "CreateActivity", targetNamespace = "http://www.exchangenetwork.net/schema/sharedcromerr/1", className = "tn.gov.nashville.ws.identityproofing.CreateActivity")
    @ResponseWrapper(localName = "CreateActivityResponse", targetNamespace = "http://www.exchangenetwork.net/schema/sharedcromerr/1", className = "tn.gov.nashville.ws.identityproofing.CreateActivityResponse")
    public String createActivity(
        @WebParam(name = "securityToken", targetNamespace = "")
        String securityToken,
        @WebParam(name = "dataflow", targetNamespace = "")
        String dataflow,
        @WebParam(name = "user", targetNamespace = "")
        UserType user,
        @WebParam(name = "properties", targetNamespace = "")
        PropertiesType properties)
        throws SharedCromerrException
    ;

}
