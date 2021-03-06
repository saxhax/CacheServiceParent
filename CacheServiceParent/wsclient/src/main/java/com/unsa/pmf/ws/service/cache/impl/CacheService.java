
package com.unsa.pmf.ws.service.cache.impl;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import com.unsa.pmf.ws.service.cache.Configurations;
import com.unsa.pmf.ws.service.cache.Data;
import com.unsa.pmf.ws.service.cache.Field;
import com.unsa.pmf.ws.service.cache.Filter;
import com.unsa.pmf.ws.service.cache.ObjectFactory;
import com.unsa.pmf.ws.service.cache.Session;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CacheService", targetNamespace = "http://cache.service.ws.pmf.unsa.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CacheService {


    /**
     * 
     * @param name
     * @return
     *     returns com.unsa.pmf.ws.service.cache.Session
     * @throws Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCacheServiceSession", targetNamespace = "http://cache.service.ws.pmf.unsa.com/", className = "com.unsa.pmf.ws.service.cache.GetCacheServiceSession")
    @ResponseWrapper(localName = "getCacheServiceSessionResponse", targetNamespace = "http://cache.service.ws.pmf.unsa.com/", className = "com.unsa.pmf.ws.service.cache.GetCacheServiceSessionResponse")
    public Session getCacheServiceSession(
        @WebParam(name = "name", targetNamespace = "")
        String name)
        throws Exception
    ;

    /**
     * 
     * @param session
     * @throws Exception
     */
    @WebMethod
    @RequestWrapper(localName = "closeSession", targetNamespace = "http://cache.service.ws.pmf.unsa.com/", className = "com.unsa.pmf.ws.service.cache.CloseSession")
    @ResponseWrapper(localName = "closeSessionResponse", targetNamespace = "http://cache.service.ws.pmf.unsa.com/", className = "com.unsa.pmf.ws.service.cache.CloseSessionResponse")
    public void closeSession(
        @WebParam(name = "session", targetNamespace = "")
        Session session)
        throws Exception
    ;

    /**
     * 
     * @param session
     * @param filter
     * @return
     *     returns com.unsa.pmf.ws.service.cache.Data
     * @throws Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getValues", targetNamespace = "http://cache.service.ws.pmf.unsa.com/", className = "com.unsa.pmf.ws.service.cache.GetValues")
    @ResponseWrapper(localName = "getValuesResponse", targetNamespace = "http://cache.service.ws.pmf.unsa.com/", className = "com.unsa.pmf.ws.service.cache.GetValuesResponse")
    public Data getValues(
        @WebParam(name = "session", targetNamespace = "")
        Session session,
        @WebParam(name = "filter", targetNamespace = "")
        Filter filter)
        throws Exception
    ;

    /**
     * 
     * @param session
     * @param data
     * @return
     *     returns com.unsa.pmf.ws.service.cache.Session
     * @throws Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "putValues", targetNamespace = "http://cache.service.ws.pmf.unsa.com/", className = "com.unsa.pmf.ws.service.cache.PutValues")
    @ResponseWrapper(localName = "putValuesResponse", targetNamespace = "http://cache.service.ws.pmf.unsa.com/", className = "com.unsa.pmf.ws.service.cache.PutValuesResponse")
    public Session putValues(
        @WebParam(name = "session", targetNamespace = "")
        Session session,
        @WebParam(name = "data", targetNamespace = "")
        List<Field> data)
        throws Exception
    ;

    /**
     * 
     * @param configuration
     * @return
     *     returns com.unsa.pmf.ws.service.cache.Session
     * @throws Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createCacheService", targetNamespace = "http://cache.service.ws.pmf.unsa.com/", className = "com.unsa.pmf.ws.service.cache.CreateCacheService")
    @ResponseWrapper(localName = "createCacheServiceResponse", targetNamespace = "http://cache.service.ws.pmf.unsa.com/", className = "com.unsa.pmf.ws.service.cache.CreateCacheServiceResponse")
    public Session createCacheService(
        @WebParam(name = "configuration", targetNamespace = "")
        Configurations configuration)
        throws Exception
    ;

}
