package com.firstproject.farmaciamedicina.domain.entity;

public class FarmaciaMedicinaDto {
    private String farmacia;
    private String medicina;
    private float precio;
    
    public FarmaciaMedicinaDto(String farmacia, String medicina, float precio) {
        this.farmacia = farmacia;
        this.medicina = medicina;
        this.precio = precio;
    }

    public String getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(String farmacia) {
        this.farmacia = farmacia;
    }

    public String getMedicina() {
        return medicina;
    }

    public void setMedicina(String medicina) {
        this.medicina = medicina;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
