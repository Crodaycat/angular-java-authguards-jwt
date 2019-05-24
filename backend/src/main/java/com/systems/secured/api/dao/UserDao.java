/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systems.secured.api.dao;

import com.systems.secured.api.dto.UserDto;
import java.io.Serializable;

/**
 *
 * @author luis_
 */
public class UserDao implements Serializable
{
    private static UserDao singleton = new UserDao();
    private UserDto user;

    public UserDao() 
    {
        this.user = new UserDto("user", "email@eamil.com", "password");
    }
    
    public static UserDao getInstance()
    {
        synchronized(UserDao.class)
        {
            if (singleton == null)
                singleton = new UserDao();
        }
        
        return singleton;
    }
    
    public UserDto getUser ()
    {
        return this.user;
    }
    
}
