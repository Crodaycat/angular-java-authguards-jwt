/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systems.secured.api.service;

import com.systems.secured.api.bl.AuthBl;
import com.systems.secured.api.bl.UserBl;
import com.systems.secured.api.dto.UserDto;
import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author luis_
 */

@Path("/login")
public class AuthService 
{
    @PermitAll
    @POST
    public Response login(UserDto user)
    {        
        return Response.ok()
                .entity(UserBl.getInstance().login(user, "localhost:4200/"))
                .build();
    }
}
