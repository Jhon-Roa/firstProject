package com.firstproject.medicina.domain.entity;

public class MedicinaDto {
    private int idMedicina;
    private String acta;
    private String nombre;
    private String registroSalud;
    private String descripcion;
    private String viaAdministracion;
    private String principioActivo;
    private String unidadMedida;
    private String laboratorio;
    
    public MedicinaDto(int idMedicina, String acta, String nombre, String registroSalud, String descripcion,
            String viaAdministracion, String principioActivo, String unidadMedida, String laboratorio) {
        this.idMedicina = idMedicina;
        this.acta = acta;
        this.nombre = nombre;
        this.registroSalud = registroSalud;
        this.descripcion = descripcion;
        this.viaAdministracion = viaAdministracion;
        this.principioActivo = principioActivo;
        this.unidadMedida = unidadMedida;
        this.laboratorio = laboratorio;
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

    public String getViaAdministracion() {
        return viaAdministracion;
    }

    public void setViaAdministracion(String viaAdministracion) {
        this.viaAdministracion = viaAdministracion;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    
}

