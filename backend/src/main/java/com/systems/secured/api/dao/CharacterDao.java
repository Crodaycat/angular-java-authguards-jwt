/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systems.secured.api.dao;

import com.systems.secured.api.dto.CharacterDto;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author luis_
 */
public class CharacterDao
{
    
    private static CharacterDao singleton = new CharacterDao();
    Collection<CharacterDto> characters;

    public CharacterDao() 
    {
        characters = new LinkedList<>();
        
        characters.add(
            new CharacterDto(
                1, 
                "Rick Sanchez",
                "Alive",
                "Human",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
            )
        );
        
        characters.add(
            new CharacterDto(
                2, 
                "Morty Smith",
                "Alive",
                "Human",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/2.jpeg"
            )
        );
        
        characters.add(
            new CharacterDto(
                3, 
                "Summer Smith",
                "Alive",
                "Human",
                "Female",
                "https://rickandmortyapi.com/api/character/avatar/3.jpeg"
            )
        );
        
        characters.add(
            new CharacterDto(
                4, 
                "Beth Smith",
                "Alive",
                "Human",
                "Female",
                "https://rickandmortyapi.com/api/character/avatar/4.jpeg"
            )
        );
        
        characters.add(
            new CharacterDto(
                5, 
                "Jerry Smith",
                "Alive",
                "Human",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/5.jpeg"
            )
        );
        
        characters.add(
            new CharacterDto(
                6,
                "Abadango Cluster Princess",
                "Alive",
                "Human",
                "Alien",
                "https://rickandmortyapi.com/api/character/avatar/6.jpeg"
            )
        );
        
        characters.add(
            new CharacterDto(
                7, 
                "Abradolf Lincler",
                "unknown",
                "Genetic experiment",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/7.jpeg"
            )
        );
        
        characters.add(
            new CharacterDto(
                8, 
                "Adjudicator Rick",
                "Dead",
                "Human",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/8.jpeg"
            )
        );
        
        characters.add(
            new CharacterDto(
                9, 
                "Agency Director",
                "Dead",
                "Human",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/9.jpeg"
            )
        );
        
        characters.add(
            new CharacterDto(
                10, 
                "Alan Rails",
                "Dead",
                "Superhuman (Ghost trains summoner)",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/10.jpeg"
            )
        );
    }
    
    public static CharacterDao getInstance()
    {
        synchronized(CharacterDao.class)
        {
            if (singleton == null)
                singleton = new CharacterDao();
        }
        
        return singleton;
    }
    
    public Collection<CharacterDto> getAll()
    {
        return this.characters;
    }
    
    public CharacterDto getById (int id)
    {
        return this.characters
                .stream()
                .filter(chr -> chr.getId() == id)
                .findFirst()
                .get();
    }
    
}
