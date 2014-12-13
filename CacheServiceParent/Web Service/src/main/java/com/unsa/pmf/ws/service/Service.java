package com.unsa.pmf.ws.service;

import java.io.Serializable;

/**
 * Created by Akif on 13.12.2014.
 */
public interface Service extends Serializable{

    public static final String CACHE = "Cache web service";

    /**
     * Service name
     * @return
     */
    public String getName();
}
