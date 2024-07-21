package com.firstproject.ciudad.domain.entity;

public class Ciudad {
    private int idCiudad;
    private String nombre;
    private int idRegion;
    
    public Ciudad(int idCiudad, String nombre, int idRegion) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.idRegion = idRegion;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
