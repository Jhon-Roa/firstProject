package com.firstproject.barrio.application;

import java.util.List;

import com.firstproject.barrio.domain.entity.Barrio;
import com.firstproject.barrio.domain.service.BarrioService;

public class GetAllBarriosUseCase {
    private BarrioService barrioService;

    public GetAllBarriosUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }

    public List<Barrio> execute() {
        return barrioService.getAllBarrios();
    }
}
