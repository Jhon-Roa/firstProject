package com.firstproject.barrio.domain.entity;

public class Barrio {
    private Integer idBarrio;
    private String nombre;
    private int idCiudad;
    
    public Barrio(Integer idBarrio, String nombre, int idCiudad) {
        this.idBarrio = idBarrio;
        this.nombre = nombre;
        this.idCiudad = idCiudad;
    }

    public int getIdBarrio() {
        return idBarrio;
    }
    public void setIdBarrio(int idBarrio) {
        this.idBarrio = idBarrio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getIdCiudad() {
        return idCiudad;
    }
    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
