/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systems.secured.api.exceptions;

/**
 *
 * @author luis_
 */
public class AuthException extends RuntimeException
{
    public AuthException(String message) {
        super(message);
    }
}
