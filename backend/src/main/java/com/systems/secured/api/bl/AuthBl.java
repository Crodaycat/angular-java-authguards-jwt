/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systems.secured.api.bl;

import com.systems.secured.api.auth.AuthUtil;

/**
 *
 * @author luis_
 */
public class AuthBl 
{
    private static AuthBl singleton = new AuthBl();
    
    public static AuthBl getInstance()
    {
        synchronized(AuthBl.class)
        {
            if (singleton == null)
                singleton = new AuthBl();
        }
        
        return singleton;
    }
    
    public String login (String client)
    {
        return AuthUtil.createToken(client, UserBl.getInstance().getUser());
    }
}
