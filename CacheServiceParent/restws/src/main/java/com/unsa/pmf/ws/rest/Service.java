package com.unsa.pmf.ws.rest;

import java.io.Serializable;

import javax.ws.rs.core.Response;

/**
 * Created by Akif on 13.12.2014.
 */
public interface Service extends Serializable{

    public static final String CACHE = "Cache web service";

    /**
     * Service name
     * @return
     */
    public Response getName();
}
