package com.firstproject.laboratorio.domain.entity;

public class Laboratorio {
    private int idLaboratorio;
    private String nombre;
    private int idBarrio;
    
    public Laboratorio(int idLaboratorio, String nombre, int idBarrio) {
        this.idLaboratorio = idLaboratorio;
        this.nombre = nombre;
        this.idBarrio = idBarrio;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
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
}
