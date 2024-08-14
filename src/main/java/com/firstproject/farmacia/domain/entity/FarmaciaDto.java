package com.firstproject.farmacia.domain.entity;

public class FarmaciaDto {
    private int idFarmacia;
    private String nombre;
    private String barrio;
    private String direccion;
    private byte[] logoFarmacia;
    
    public FarmaciaDto(int idFarmacia, String nombre, String barrio, String direccion, byte[] logoFarmacia) {
        this.idFarmacia = idFarmacia;
        this.nombre = nombre;
        this.barrio = barrio;
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

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
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

    
}
