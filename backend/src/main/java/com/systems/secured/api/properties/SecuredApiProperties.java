/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systems.secured.api.properties;

import java.io.Serializable;
import java.util.ResourceBundle;

/**
 *
 * @author luis_
 */
public class SecuredApiProperties implements Serializable
{
     private static SecuredApiProperties singletonInstance = new SecuredApiProperties();
    
    private ResourceBundle applicationProperties = ResourceBundle
            .getBundle("application");
    
    private SecuredApiProperties() {
    }
    
    public static SecuredApiProperties getInstance() 
    {
        synchronized (SecuredApiProperties.class) 
        {
            if (singletonInstance == null)
                singletonInstance = new SecuredApiProperties();
        }
        return singletonInstance;
    }

    protected Object readResolve() {
        return getInstance();
    }
    
    public ResourceBundle getApplicationProperties() {
        return applicationProperties;
    }

}
