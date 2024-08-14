package com.firstproject.farmaciamedicina.domain.entity;

public class FarmaciaMedicina {
    private int idFarmacia;
    private int idMedicina;
    private float precio;
    
    public FarmaciaMedicina(int idFarmacia, int idMedicina, float precio) {
        this.idFarmacia = idFarmacia;
        this.idMedicina = idMedicina;
        this.precio = precio;
    }

    public int getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(int idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public int getIdMedicina() {
        return idMedicina;
    }

    public void setIdMedicina(int idMedicina) {
        this.idMedicina = idMedicina;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
