
package com.unsa.pmf.ws.service.cache;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.unsa.pmf.ws.service.cache package. 
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

    private final static QName _GetValues_QNAME = new QName("http://cache.service.ws.pmf.unsa.com/", "getValues");
    private final static QName _GetCacheServiceSessionResponse_QNAME = new QName("http://cache.service.ws.pmf.unsa.com/", "getCacheServiceSessionResponse");
    private final static QName _GetValuesResponse_QNAME = new QName("http://cache.service.ws.pmf.unsa.com/", "getValuesResponse");
    private final static QName _CloseSessionResponse_QNAME = new QName("http://cache.service.ws.pmf.unsa.com/", "closeSessionResponse");
    private final static QName _CreateCacheServiceResponse_QNAME = new QName("http://cache.service.ws.pmf.unsa.com/", "createCacheServiceResponse");
    private final static QName _PutValuesResponse_QNAME = new QName("http://cache.service.ws.pmf.unsa.com/", "putValuesResponse");
    private final static QName _PutValues_QNAME = new QName("http://cache.service.ws.pmf.unsa.com/", "putValues");
    private final static QName _CreateCacheService_QNAME = new QName("http://cache.service.ws.pmf.unsa.com/", "createCacheService");
    private final static QName _Exception_QNAME = new QName("http://cache.service.ws.pmf.unsa.com/", "Exception");
    private final static QName _CloseSession_QNAME = new QName("http://cache.service.ws.pmf.unsa.com/", "closeSession");
    private final static QName _GetCacheServiceSession_QNAME = new QName("http://cache.service.ws.pmf.unsa.com/", "getCacheServiceSession");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.unsa.pmf.ws.service.cache
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link GetCacheServiceSession }
     * 
     */
    public GetCacheServiceSession createGetCacheServiceSession() {
        return new GetCacheServiceSession();
    }

    /**
     * Create an instance of {@link CloseSession }
     * 
     */
    public CloseSession createCloseSession() {
        return new CloseSession();
    }

    /**
     * Create an instance of {@link PutValues }
     * 
     */
    public PutValues createPutValues() {
        return new PutValues();
    }

    /**
     * Create an instance of {@link CreateCacheService }
     * 
     */
    public CreateCacheService createCreateCacheService() {
        return new CreateCacheService();
    }

    /**
     * Create an instance of {@link PutValuesResponse }
     * 
     */
    public PutValuesResponse createPutValuesResponse() {
        return new PutValuesResponse();
    }

    /**
     * Create an instance of {@link CreateCacheServiceResponse }
     * 
     */
    public CreateCacheServiceResponse createCreateCacheServiceResponse() {
        return new CreateCacheServiceResponse();
    }

    /**
     * Create an instance of {@link CloseSessionResponse }
     * 
     */
    public CloseSessionResponse createCloseSessionResponse() {
        return new CloseSessionResponse();
    }

    /**
     * Create an instance of {@link GetValues }
     * 
     */
    public GetValues createGetValues() {
        return new GetValues();
    }

    /**
     * Create an instance of {@link GetValuesResponse }
     * 
     */
    public GetValuesResponse createGetValuesResponse() {
        return new GetValuesResponse();
    }

    /**
     * Create an instance of {@link GetCacheServiceSessionResponse }
     * 
     */
    public GetCacheServiceSessionResponse createGetCacheServiceSessionResponse() {
        return new GetCacheServiceSessionResponse();
    }

    /**
     * Create an instance of {@link Condition }
     * 
     */
    public Condition createCondition() {
        return new Condition();
    }

    /**
     * Create an instance of {@link ArrayList }
     * 
     */
    public ArrayList createArrayList() {
        return new ArrayList();
    }

    /**
     * Create an instance of {@link Data }
     * 
     */
    public Data createData() {
        return new Data();
    }

    /**
     * Create an instance of {@link Row }
     * 
     */
    public Row createRow() {
        return new Row();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link Configurations }
     * 
     */
    public Configurations createConfigurations() {
        return new Configurations();
    }

    /**
     * Create an instance of {@link Filter }
     * 
     */
    public Filter createFilter() {
        return new Filter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetValues }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cache.service.ws.pmf.unsa.com/", name = "getValues")
    public JAXBElement<GetValues> createGetValues(GetValues value) {
        return new JAXBElement<GetValues>(_GetValues_QNAME, GetValues.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCacheServiceSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cache.service.ws.pmf.unsa.com/", name = "getCacheServiceSessionResponse")
    public JAXBElement<GetCacheServiceSessionResponse> createGetCacheServiceSessionResponse(GetCacheServiceSessionResponse value) {
        return new JAXBElement<GetCacheServiceSessionResponse>(_GetCacheServiceSessionResponse_QNAME, GetCacheServiceSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetValuesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cache.service.ws.pmf.unsa.com/", name = "getValuesResponse")
    public JAXBElement<GetValuesResponse> createGetValuesResponse(GetValuesResponse value) {
        return new JAXBElement<GetValuesResponse>(_GetValuesResponse_QNAME, GetValuesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cache.service.ws.pmf.unsa.com/", name = "closeSessionResponse")
    public JAXBElement<CloseSessionResponse> createCloseSessionResponse(CloseSessionResponse value) {
        return new JAXBElement<CloseSessionResponse>(_CloseSessionResponse_QNAME, CloseSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCacheServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cache.service.ws.pmf.unsa.com/", name = "createCacheServiceResponse")
    public JAXBElement<CreateCacheServiceResponse> createCreateCacheServiceResponse(CreateCacheServiceResponse value) {
        return new JAXBElement<CreateCacheServiceResponse>(_CreateCacheServiceResponse_QNAME, CreateCacheServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutValuesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cache.service.ws.pmf.unsa.com/", name = "putValuesResponse")
    public JAXBElement<PutValuesResponse> createPutValuesResponse(PutValuesResponse value) {
        return new JAXBElement<PutValuesResponse>(_PutValuesResponse_QNAME, PutValuesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutValues }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cache.service.ws.pmf.unsa.com/", name = "putValues")
    public JAXBElement<PutValues> createPutValues(PutValues value) {
        return new JAXBElement<PutValues>(_PutValues_QNAME, PutValues.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCacheService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cache.service.ws.pmf.unsa.com/", name = "createCacheService")
    public JAXBElement<CreateCacheService> createCreateCacheService(CreateCacheService value) {
        return new JAXBElement<CreateCacheService>(_CreateCacheService_QNAME, CreateCacheService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cache.service.ws.pmf.unsa.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseSession }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cache.service.ws.pmf.unsa.com/", name = "closeSession")
    public JAXBElement<CloseSession> createCloseSession(CloseSession value) {
        return new JAXBElement<CloseSession>(_CloseSession_QNAME, CloseSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCacheServiceSession }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cache.service.ws.pmf.unsa.com/", name = "getCacheServiceSession")
    public JAXBElement<GetCacheServiceSession> createGetCacheServiceSession(GetCacheServiceSession value) {
        return new JAXBElement<GetCacheServiceSession>(_GetCacheServiceSession_QNAME, GetCacheServiceSession.class, null, value);
    }

}
