package com.firstproject.farmacia.application;

import java.util.List;

import com.firstproject.farmacia.domain.entity.FarmaciaDto;
import com.firstproject.farmacia.domain.service.FarmaciaService;

public class GetAllFarmaciasDtoUseCase {
    private FarmaciaService farmaciaService;

    public GetAllFarmaciasDtoUseCase(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    public List<FarmaciaDto> execute() {
        return farmaciaService.getAllFarmaciasDto();
    }
}
