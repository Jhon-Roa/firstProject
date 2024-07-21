package com.firstproject.barrio.application;

import com.firstproject.barrio.domain.service.BarrioService;
import com.firstproject.ciudad.domain.entity.Ciudad;

public class CreateBarrioUseCase {
    private BarrioService barrioService;

    public CreateBarrioUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }

    public void execute(String barrio, Ciudad selectedCiudad) {
        barrioService.createBarrio(barrio, selectedCiudad);
    }
}
