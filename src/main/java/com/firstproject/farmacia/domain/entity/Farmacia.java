package com.firstproject.farmacia.domain.entity;

public class Farmacia {
    private int idFarmacia;
    private String nombre;
    private int idBarrio;
    private String direccion;
    private byte[] logoFarmacia;
    
    public Farmacia(int idFarmacia, String nombre, int idBarrio, String direccion, byte[] logoFarmacia) {
        this.idFarmacia = idFarmacia;
        this.nombre = nombre;
        this.idBarrio = idBarrio;
        this.direccion = direccion;
        this.logoFarmacia = logoFarmacia;
    }

    public int getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(int idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(int idBarrio) {
        this.idBarrio = idBarrio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public byte[] getLogoFarmacia() {
        return logoFarmacia;
    }

    public void setLogoFarmacia(byte[] logoFarmacia) {
        this.logoFarmacia = logoFarmacia;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
