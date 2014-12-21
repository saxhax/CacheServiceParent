
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

    private final static QName _StartServiceResponse_QNAME = new QName("http://cache.service.ws.pmf.unsa.com/", "startServiceResponse");
    private final static QName _IsServiceStarted_QNAME = new QName("http://cache.service.ws.pmf.unsa.com/", "isServiceStarted");
    private final static QName _StartService_QNAME = new QName("http://cache.service.ws.pmf.unsa.com/", "startService");
    private final static QName _IsServiceStartedResponse_QNAME = new QName("http://cache.service.ws.pmf.unsa.com/", "isServiceStartedResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.unsa.pmf.ws.service.cache
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IsServiceStartedResponse }
     * 
     */
    public IsServiceStartedResponse createIsServiceStartedResponse() {
        return new IsServiceStartedResponse();
    }

    /**
     * Create an instance of {@link StartService }
     * 
     */
    public StartService createStartService() {
        return new StartService();
    }

    /**
     * Create an instance of {@link IsServiceStarted }
     * 
     */
    public IsServiceStarted createIsServiceStarted() {
        return new IsServiceStarted();
    }

    /**
     * Create an instance of {@link StartServiceResponse }
     * 
     */
    public StartServiceResponse createStartServiceResponse() {
        return new StartServiceResponse();
    }

    /**
     * Create an instance of {@link SessionImpl }
     * 
     */
    public SessionImpl createSessionImpl() {
        return new SessionImpl();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cache.service.ws.pmf.unsa.com/", name = "startServiceResponse")
    public JAXBElement<StartServiceResponse> createStartServiceResponse(StartServiceResponse value) {
        return new JAXBElement<StartServiceResponse>(_StartServiceResponse_QNAME, StartServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsServiceStarted }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cache.service.ws.pmf.unsa.com/", name = "isServiceStarted")
    public JAXBElement<IsServiceStarted> createIsServiceStarted(IsServiceStarted value) {
        return new JAXBElement<IsServiceStarted>(_IsServiceStarted_QNAME, IsServiceStarted.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cache.service.ws.pmf.unsa.com/", name = "startService")
    public JAXBElement<StartService> createStartService(StartService value) {
        return new JAXBElement<StartService>(_StartService_QNAME, StartService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsServiceStartedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cache.service.ws.pmf.unsa.com/", name = "isServiceStartedResponse")
    public JAXBElement<IsServiceStartedResponse> createIsServiceStartedResponse(IsServiceStartedResponse value) {
        return new JAXBElement<IsServiceStartedResponse>(_IsServiceStartedResponse_QNAME, IsServiceStartedResponse.class, null, value);
    }

}
