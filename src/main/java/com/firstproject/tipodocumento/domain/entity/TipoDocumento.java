package com.firstproject.tipodocumento.domain.entity;

public class TipoDocumento {
    private int idTipoDocumento;
    private String nombre;
    
    public TipoDocumento(int idTipoDocumento, String nombre) {
        this.idTipoDocumento = idTipoDocumento;
        this.nombre = nombre;
    }

    public int getidTipoDocumento() {
        return idTipoDocumento;
    }

    public void setidTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
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
