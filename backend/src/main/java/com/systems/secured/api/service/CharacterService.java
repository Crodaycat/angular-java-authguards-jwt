/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systems.secured.api.service;

import com.systems.secured.api.bl.CharacterBl;
import com.systems.secured.api.dto.CharacterDto;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author luis_
 */

@Path("/characters")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CharacterService 
{
    @GET
    public Collection<CharacterDto> getAll() 
    {
        return CharacterBl.getInstance().getAll();
    }
    
    @GET
    @Path("/{id}")
    public CharacterDto getById(@PathParam("id") int id) 
    {
        return CharacterBl.getInstance().getById(id);
    }
}
