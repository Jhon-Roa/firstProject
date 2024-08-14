package com.firstproject.medicina.domain.entity;

public class Medicina {
    private int idMedicina;
    private String acta;
    private String nombre;
    private String registroSalud;
    private String descripcion;
    private int idViaAdministracion;
    private int idPrincipioActivo;
    private int idUnidadMedida;
    private int idLaboratorio;
    
    public Medicina(int idMedicina, String acta, String nombre, String registroSalud, String descripcion,
            int idViaAdministracion, int idPrincipioActivo, int idUnidadMedida, int idLaboratorio) {
        this.idMedicina = idMedicina;
        this.acta = acta;
        this.nombre = nombre;
        this.registroSalud = registroSalud;
        this.descripcion = descripcion;
        this.idViaAdministracion = idViaAdministracion;
        this.idPrincipioActivo = idPrincipioActivo;
        this.idUnidadMedida = idUnidadMedida;
        this.idLaboratorio = idLaboratorio;
    }

    public int getIdMedicina() {
        return idMedicina;
    }

    public void setIdMedicina(int idMedicina) {
        this.idMedicina = idMedicina;
    }

    public String getActa() {
        return acta;
    }

    public void setActa(String acta) {
        this.acta = acta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegistroSalud() {
        return registroSalud;
    }

    public void setRegistroSalud(String registroSalud) {
        this.registroSalud = registroSalud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdViaAdministracion() {
        return idViaAdministracion;
    }

    public void setIdViaAdministracion(int idViaAdministracion) {
        this.idViaAdministracion = idViaAdministracion;
    }

    public int getIdPrincipioActivo() {
        return idPrincipioActivo;
    }

    public void setIdPrincipioActivo(int idPrincipioActivo) {
        this.idPrincipioActivo = idPrincipioActivo;
    }

    public int getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(int idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }
}
