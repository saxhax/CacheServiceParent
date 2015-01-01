
package com.unsa.pmf.ws.service.cache;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createCacheService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createCacheService">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="configuration" type="{http://cache.service.ws.pmf.unsa.com/}configurations" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createCacheService", propOrder = {
    "configuration"
})
public class CreateCacheService {

    protected Configurations configuration;

    /**
     * Gets the value of the configuration property.
     * 
     * @return
     *     possible object is
     *     {@link Configurations }
     *     
     */
    public Configurations getConfiguration() {
        return configuration;
    }

    /**
     * Sets the value of the configuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Configurations }
     *     
     */
    public void setConfiguration(Configurations value) {
        this.configuration = value;
    }

}
