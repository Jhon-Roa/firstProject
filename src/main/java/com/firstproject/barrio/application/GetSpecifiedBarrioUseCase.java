package com.firstproject.barrio.application;

import com.firstproject.barrio.domain.entity.Barrio;
import com.firstproject.barrio.domain.service.BarrioService;

public class GetSpecifiedBarrioUseCase {
    private BarrioService barrioService;

    public GetSpecifiedBarrioUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }

    public Barrio execute(int idBarrio) {
        return barrioService.getSpecifiedBarrio(idBarrio);
    }
}
