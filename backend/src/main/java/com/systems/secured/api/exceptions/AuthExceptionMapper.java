/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systems.secured.api.exceptions;

import com.systems.secured.api.dto.MensajeError;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author luis_
 */
public class AuthExceptionMapper implements ExceptionMapper<AuthException>{
    
    @Override
    public Response toResponse(AuthException e) {
        MensajeError mensajeError =  new MensajeError(e.getMessage(), 401, "Error de Autenticación"); 
            return Response.status(Status.UNAUTHORIZED)
                    .type(MediaType.APPLICATION_JSON)
                    .entity(mensajeError)
                    .build();
    }
    
}
