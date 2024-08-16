package com.firstproject.principioActivo.domain.entity;

public class PrincipioActivo {
    private int idPrincipioActivo;
    private String nombre;

    public PrincipioActivo(int idPrincipioActivo, String nombre) {
        this.idPrincipioActivo = idPrincipioActivo;
        this.nombre = nombre;
    }

    public int getIdPrincipioActivo() {
        return idPrincipioActivo;
    }

    public void setIdPrincipioActivo(int idPrincipioActivo) {
        this.idPrincipioActivo = idPrincipioActivo;
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
