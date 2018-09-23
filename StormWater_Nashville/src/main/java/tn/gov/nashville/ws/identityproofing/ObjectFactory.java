
package tn.gov.nashville.ws.identityproofing;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tn.gov.nashville.ws.identityproofing package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Authenticate_QNAME = new QName("http://www.exchangenetwork.net/schema/sharedcromerr/1", "Authenticate");
    private final static QName _GetResult_QNAME = new QName("http://www.exchangenetwork.net/schema/sharedcromerr/1", "GetResult");
    private final static QName _GetResultResponse_QNAME = new QName("http://www.exchangenetwork.net/schema/sharedcromerr/1", "GetResultResponse");
    private final static QName _CreateRequest_QNAME = new QName("http://www.exchangenetwork.net/schema/sharedcromerr/1", "CreateRequest");
    private final static QName _AuthenticateResponse_QNAME = new QName("http://www.exchangenetwork.net/schema/sharedcromerr/1", "AuthenticateResponse");
    private final static QName _CreateRequestResponse_QNAME = new QName("http://www.exchangenetwork.net/schema/sharedcromerr/1", "CreateRequestResponse");
    private final static QName _SharedCromerrFault_QNAME = new QName("http://www.exchangenetwork.net/schema/sharedcromerr/1", "SharedCromerrFault");
    private final static QName _CreateActivity_QNAME = new QName("http://www.exchangenetwork.net/schema/sharedcromerr/1", "CreateActivity");
    private final static QName _CreateActivityResponse_QNAME = new QName("http://www.exchangenetwork.net/schema/sharedcromerr/1", "CreateActivityResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tn.gov.nashville.ws.identityproofing
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AuthenticateResponse }
     * 
     */
    public AuthenticateResponse createAuthenticateResponse() {
        return new AuthenticateResponse();
    }

    /**
     * Create an instance of {@link Authenticate }
     * 
     */
    public Authenticate createAuthenticate() {
        return new Authenticate();
    }

    /**
     * Create an instance of {@link GetResult }
     * 
     */
    public GetResult createGetResult() {
        return new GetResult();
    }

    /**
     * Create an instance of {@link CreateRequest }
     * 
     */
    public CreateRequest createCreateRequest() {
        return new CreateRequest();
    }

    /**
     * Create an instance of {@link GetResultResponse }
     * 
     */
    public GetResultResponse createGetResultResponse() {
        return new GetResultResponse();
    }

    /**
     * Create an instance of {@link SharedCromerrFault }
     * 
     */
    public SharedCromerrFault createSharedCromerrFault() {
        return new SharedCromerrFault();
    }

    /**
     * Create an instance of {@link CreateActivityResponse }
     * 
     */
    public CreateActivityResponse createCreateActivityResponse() {
        return new CreateActivityResponse();
    }

    /**
     * Create an instance of {@link CreateActivity }
     * 
     */
    public CreateActivity createCreateActivity() {
        return new CreateActivity();
    }

    /**
     * Create an instance of {@link CreateRequestResponse }
     * 
     */
    public CreateRequestResponse createCreateRequestResponse() {
        return new CreateRequestResponse();
    }

    /**
     * Create an instance of {@link DocumentType }
     * 
     */
    public DocumentType createDocumentType() {
        return new DocumentType();
    }

    /**
     * Create an instance of {@link PropertyType }
     * 
     */
    public PropertyType createPropertyType() {
        return new PropertyType();
    }

    /**
     * Create an instance of {@link IdentityProofingFullUserType }
     * 
     */
    public IdentityProofingFullUserType createIdentityProofingFullUserType() {
        return new IdentityProofingFullUserType();
    }

    /**
     * Create an instance of {@link RepudiationInfoType }
     * 
     */
    public RepudiationInfoType createRepudiationInfoType() {
        return new RepudiationInfoType();
    }

    /**
     * Create an instance of {@link PropertiesType }
     * 
     */
    public PropertiesType createPropertiesType() {
        return new PropertiesType();
    }

    /**
     * Create an instance of {@link IdentityProofingResultType }
     * 
     */
    public IdentityProofingResultType createIdentityProofingResultType() {
        return new IdentityProofingResultType();
    }

    /**
     * Create an instance of {@link UserType }
     * 
     */
    public UserType createUserType() {
        return new UserType();
    }

    /**
     * Create an instance of {@link Base64Binary }
     * 
     */
    public Base64Binary createBase64Binary() {
        return new Base64Binary();
    }

    /**
     * Create an instance of {@link HexBinary }
     * 
     */
    public HexBinary createHexBinary() {
        return new HexBinary();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Authenticate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.exchangenetwork.net/schema/sharedcromerr/1", name = "Authenticate")
    public JAXBElement<Authenticate> createAuthenticate(Authenticate value) {
        return new JAXBElement<Authenticate>(_Authenticate_QNAME, Authenticate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.exchangenetwork.net/schema/sharedcromerr/1", name = "GetResult")
    public JAXBElement<GetResult> createGetResult(GetResult value) {
        return new JAXBElement<GetResult>(_GetResult_QNAME, GetResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResultResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.exchangenetwork.net/schema/sharedcromerr/1", name = "GetResultResponse")
    public JAXBElement<GetResultResponse> createGetResultResponse(GetResultResponse value) {
        return new JAXBElement<GetResultResponse>(_GetResultResponse_QNAME, GetResultResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.exchangenetwork.net/schema/sharedcromerr/1", name = "CreateRequest")
    public JAXBElement<CreateRequest> createCreateRequest(CreateRequest value) {
        return new JAXBElement<CreateRequest>(_CreateRequest_QNAME, CreateRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.exchangenetwork.net/schema/sharedcromerr/1", name = "AuthenticateResponse")
    public JAXBElement<AuthenticateResponse> createAuthenticateResponse(AuthenticateResponse value) {
        return new JAXBElement<AuthenticateResponse>(_AuthenticateResponse_QNAME, AuthenticateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.exchangenetwork.net/schema/sharedcromerr/1", name = "CreateRequestResponse")
    public JAXBElement<CreateRequestResponse> createCreateRequestResponse(CreateRequestResponse value) {
        return new JAXBElement<CreateRequestResponse>(_CreateRequestResponse_QNAME, CreateRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SharedCromerrFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.exchangenetwork.net/schema/sharedcromerr/1", name = "SharedCromerrFault")
    public JAXBElement<SharedCromerrFault> createSharedCromerrFault(SharedCromerrFault value) {
        return new JAXBElement<SharedCromerrFault>(_SharedCromerrFault_QNAME, SharedCromerrFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateActivity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.exchangenetwork.net/schema/sharedcromerr/1", name = "CreateActivity")
    public JAXBElement<CreateActivity> createCreateActivity(CreateActivity value) {
        return new JAXBElement<CreateActivity>(_CreateActivity_QNAME, CreateActivity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateActivityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.exchangenetwork.net/schema/sharedcromerr/1", name = "CreateActivityResponse")
    public JAXBElement<CreateActivityResponse> createCreateActivityResponse(CreateActivityResponse value) {
        return new JAXBElement<CreateActivityResponse>(_CreateActivityResponse_QNAME, CreateActivityResponse.class, null, value);
    }

}
