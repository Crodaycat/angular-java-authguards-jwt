/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systems.secured.api.filter;

import com.systems.secured.api.auth.AuthUtil;
import com.systems.secured.api.exceptions.AuthException;
import io.jsonwebtoken.Claims;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Priority;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author luis_
 */

@Provider
public class SecurityFilter implements ContainerRequestFilter
{
    @Context
    HttpHeaders headers;
    @Context
    private ResourceInfo resourceInfo;
    
    @Override
    public void filter(ContainerRequestContext requestContext)
    {
        String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        
        if (!requestContext.getMethod().equals("OPTIONS")) {
            Method method = resourceInfo.getResourceMethod();
                    
            System.out.println(method.isAnnotationPresent(PermitAll.class));
            if(!method.isAnnotationPresent(PermitAll.class))
            {
                if (method.isAnnotationPresent(RolesAllowed.class))
                {
                    AuthUtil.verifyToken(authHeader);
                    
                    RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
                    Set<String> rolesSet = new HashSet<String>
                            (Arrays.asList(rolesAnnotation.value()));
                    
                    Claims claims = AuthUtil.decodeToken(authHeader.split(" ")[1]);
                    
                    ArrayList<String> userRoles = (ArrayList<String>)claims.get("roles");
                    
                    if (!isUserAllow(rolesSet, userRoles))
                        throw new AuthException("No estás autorizado para consumir este servicio.");
                }
            }
        }
    }
    
    private boolean isUserAllow(Set<String> rolesAllow, ArrayList<String> roles)
    {
        for (String role : roles)
            if (rolesAllow.contains(role))
                return true;
        
        return false;
    }
}
