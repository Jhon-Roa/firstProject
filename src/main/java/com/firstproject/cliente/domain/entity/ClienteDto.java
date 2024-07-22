package com.firstproject.cliente.domain.entity;

import java.sql.Date;

import com.firstproject.persona.domain.entity.Persona;

public class ClienteDto extends Persona{
    private String idCliente;
    private Date fechaRegistro;
    private String barrio;
    private String documento;

    public ClienteDto() {
    }


    public ClienteDto(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
            int edad, Date fechaNacimiento, String idCliente, Date fechaRegistro, String barrio, String documento) {
        super(primerNombre, segundoNombre, primerApellido, segundoApellido, edad, fechaNacimiento);
        this.idCliente = idCliente;
        this.fechaRegistro = fechaRegistro;
        this.barrio = barrio;
        this.documento = documento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    
}