package com.firstproject.farmacia.application;

import com.firstproject.farmacia.domain.entity.Farmacia;
import com.firstproject.farmacia.domain.service.FarmaciaService;

public class CrearFarmaciaUseCase {
    private FarmaciaService farmaciaService;

    public CrearFarmaciaUseCase(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    public void execute(Farmacia farmacia) {
        farmaciaService.crearFarmacia(farmacia);
    }
}
