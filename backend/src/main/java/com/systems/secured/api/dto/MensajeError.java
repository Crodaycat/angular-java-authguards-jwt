/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systems.secured.api.dto;

import java.io.Serializable;

/**
 *
 * @author luis_
 */
public class MensajeError implements Serializable
{
    private String mensaje;
    private int codigoError;
    private String documentacion;

    public MensajeError() {
    }

    public MensajeError(String mensaje, int codigoError, String documentacion) {
        this.mensaje = mensaje;
        this.codigoError = codigoError;
        this.documentacion = documentacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(int codigoError) {
        this.codigoError = codigoError;
    }

    public String getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(String documentacion) {
        this.documentacion = documentacion;
    }
}
