package com.firstproject.region.domain.entity;

public class Region {
    private int idRegion;
    private String nombre;
    private int idPais;

    public Region(int idRegion, String nombre, int idPais) {
        this.idRegion = idRegion;
        this.nombre = nombre;
        this.idPais = idPais;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
