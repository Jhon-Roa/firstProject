package com.firstproject.farmacia.application;

import java.util.Optional;

import com.firstproject.farmacia.domain.entity.Farmacia;
import com.firstproject.farmacia.domain.service.FarmaciaService;

public class GetSpecifiedFarmaciaUseCase {
    private FarmaciaService farmaciaService;

    public GetSpecifiedFarmaciaUseCase(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    public Optional<Farmacia> execute(int idFarmacia) {
        return farmaciaService.getEspecifiedFarmacia(idFarmacia);
    }
}
