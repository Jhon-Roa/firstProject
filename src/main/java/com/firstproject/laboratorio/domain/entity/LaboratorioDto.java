package com.firstproject.laboratorio.domain.entity;

public class LaboratorioDto {
    private int idLaboratorio;
    private String nombre;
    private String nombreBarrio;

    public LaboratorioDto(int idLaboratorio, String nombre, String nombreBarrio) {
        this.idLaboratorio = idLaboratorio;
        this.nombre = nombre;
        this.nombreBarrio = nombreBarrio;
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

    public String getNombreBarrio() {
        return nombreBarrio;
    }

    public void setNombreBarrio(String nombreBarrio) {
        this.nombreBarrio = nombreBarrio;
    }
}
