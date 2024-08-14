package com.firstproject.farmacia.application;

import com.firstproject.farmacia.domain.entity.Farmacia;
import com.firstproject.farmacia.domain.service.FarmaciaService;

public class UpdateFarmaciaUseCase {
    private FarmaciaService farmaciaService;

    public UpdateFarmaciaUseCase(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    public void execute(Farmacia farmacia) {
        farmaciaService.updateFarmacia(farmacia);
    }
}
