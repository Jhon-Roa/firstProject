package com.firstproject.farmacia.application;

import java.util.List;

import com.firstproject.farmacia.domain.entity.Farmacia;
import com.firstproject.farmacia.domain.service.FarmaciaService;

public class GetAllFarmaciasUseCase {
    private FarmaciaService farmaciaService;
    
    public GetAllFarmaciasUseCase(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    public List<Farmacia> execute() {
        return farmaciaService.getAllFarmacias();
    }
}
