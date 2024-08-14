package com.firstproject.farmacia.application;

import com.firstproject.farmacia.domain.service.FarmaciaService;

public class DeleteFarmaciaUseCase {
    private FarmaciaService farmaciaService;

    public DeleteFarmaciaUseCase(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    public void execute(int idFarmacia) {
        farmaciaService.deleteFarmacia(idFarmacia);
    }
}
