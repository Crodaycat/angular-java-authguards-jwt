/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systems.secured.api.auth;

import com.systems.secured.api.dto.UserDto;
import com.systems.secured.api.exceptions.AuthException;
import com.systems.secured.api.properties.SecuredApiProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import java.security.Key;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author luis_
 */
public class AuthUtil 
{
    public static final String AUTH_HEADER_KEY = "Authorization";
    
    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = 
            SignatureAlgorithm.HS256;
    
    private static final byte[] JWT_SECRET_BYTES = DatatypeConverter
            .parseBase64Binary(
                    SecuredApiProperties.getInstance()
                        .getApplicationProperties()
                        .getString("JWT_SECRET")
            );
    private static final long TOKEN_LIFE = 3600000L;
    
    private static final String EXPIRE_ERROR_MSG = "El token ha expirado",
            JWT_ERROR_MSG = "No se puede convertir a JWT",
            JWT_INVALID_MSG = "Token JWT inválido";
    
    public static final String AUTH_AUDIENCE = "localhost:4200/";
    
    public static String createToken (String client, UserDto user) 
    {
        long nowMillis = System.currentTimeMillis();
        
        Key key = new SecretKeySpec(
                JWT_SECRET_BYTES, 
                SIGNATURE_ALGORITHM.getJcaName()
        );
        
        String[] roles = new String[1];
        roles[0] = "user";
        
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setIssuer(client)
                .setAudience(AUTH_AUDIENCE)
                .setSubject(user.getEmail())
                .claim("user", user.getName())
                .claim("roles", roles)
                .setIssuedAt(new Date(nowMillis))
                .setExpiration(new Date(nowMillis + TOKEN_LIFE))
                .signWith(SIGNATURE_ALGORITHM, key)
                .compact();
    }
    
    public static Claims decodeToken(String token) 
    {
        return Jwts.parser()
                .setSigningKey(JWT_SECRET_BYTES)
                .parseClaimsJws(token)
                .getBody();
    }
    
    public static boolean verifyToken(String authHeader)
    {
        if (authHeader == null || authHeader.isEmpty() || authHeader.split(" ").length != 2) {
            throw new AuthException("Usted no cuenta con permisos para llamar el WebService.");
        } else {
            Claims claims;
            try {
                claims = decodeToken(authHeader.split(" ")[1]);
            } catch (SignatureException e) {
                throw new AuthException("No se pudo validar la firma del token.");
            } catch (ExpiredJwtException e) {
                throw new AuthException(EXPIRE_ERROR_MSG);
            } catch (MalformedJwtException e) {
                throw new AuthException(JWT_ERROR_MSG);
            } catch (Exception e) {
                throw new AuthException(JWT_INVALID_MSG);
            }

            if(claims.getExpiration() == null){
                 throw new AuthException("El Token de autenticación no cuenta con Fecha de expiración.");
            }
            if (claims.getExpiration().getTime() < new Date().getTime()) {
                throw new AuthException(EXPIRE_ERROR_MSG);
            } else {
                return true;
            }
        }
    }
    
}
