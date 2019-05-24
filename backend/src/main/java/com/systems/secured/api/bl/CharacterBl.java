/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systems.secured.api.bl;

import com.systems.secured.api.dao.CharacterDao;
import com.systems.secured.api.dto.CharacterDto;
import java.util.Collection;

/**
 *
 * @author luis_
 */
public class CharacterBl 
{
    private static CharacterBl singleton = new CharacterBl();
    
    public static CharacterBl getInstance()
    {
        synchronized(CharacterBl.class)
        {
            if (singleton == null)
                singleton = new CharacterBl();
        }
        
        return singleton;
    }
    
    public Collection<CharacterDto> getAll () 
    {
        return CharacterDao.getInstance()
                .getAll();
    }
    
    public CharacterDto getById (int id)
    {
        return CharacterDao.getInstance()
                .getById(id);
    }
    
}
