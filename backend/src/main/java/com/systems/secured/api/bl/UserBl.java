/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systems.secured.api.bl;

import com.systems.secured.api.dao.UserDao;
import com.systems.secured.api.dto.UserDto;

/**
 *
 * @author luis_
 */
public class UserBl 
{
    private static UserBl singleton = new UserBl();
    
    public static UserBl getInstance()
    {
        synchronized(UserBl.class)
        {
            if (singleton == null)
                singleton = new UserBl();
        }
        
        return singleton;
    }
    
    public UserDto getUser () 
    {
        return UserDao.getInstance().getUser();
    }
}
