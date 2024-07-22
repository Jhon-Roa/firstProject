package com.firstproject.cliente.domain.entity;

import java.sql.Date;
import java.text.MessageFormat;

import com.firstproject.persona.domain.entity.Persona;

public class Cliente extends Persona {
    private String idCliente;
    private Date fechaRegistro;
    private Integer idBarrio;
    private int idTipoDocumento;

    public Cliente() {
    }

    public Cliente(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
            Date fechaNacimiento, String idCliente, Integer idBarrio, int idTipoDocumento) {
        super(primerNombre, segundoNombre, primerApellido, segundoApellido, fechaNacimiento);
        this.idCliente = idCliente;
        this.idBarrio = idBarrio;
        this.idTipoDocumento = idTipoDocumento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Integer idBarrio) {
        this.idBarrio = idBarrio;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    @Override 
    public String toString() {
        return getPrimerNombre();
    }
}
