package com.firstproject.farmacia.application;

import java.util.Optional;

import com.firstproject.farmacia.domain.entity.FarmaciaDto;
import com.firstproject.farmacia.domain.service.FarmaciaService;

public class FindFarmaciaUseCase {
    private FarmaciaService farmaciaService;

    public FindFarmaciaUseCase(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    public Optional<FarmaciaDto> execute(int idFarmacia) {
        return farmaciaService.findFarmacia(idFarmacia);
    }
}
