package com.firstproject.viaadministracion.domain.entity;

public class ViaAdministracion {
    private int idViaAdministracion;
    private String nombre;
    
    public ViaAdministracion(int idViaAdministracion, String nombre) {
        this.idViaAdministracion = idViaAdministracion;
        this.nombre = nombre;
    }

    public int getIdViaAdministracion() {
        return idViaAdministracion;
    }

    public void setIdViaAdministracion(int idViaAdministracion) {
        this.idViaAdministracion = idViaAdministracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
