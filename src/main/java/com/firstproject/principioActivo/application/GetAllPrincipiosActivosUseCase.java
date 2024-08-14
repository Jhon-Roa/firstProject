package com.firstproject.principioActivo.application;

import java.util.List;

import com.firstproject.principioActivo.domain.entity.PrincipioActivo;
import com.firstproject.principioActivo.domain.service.PrincipioActivoService;

public class GetAllPrincipiosActivosUseCase {
    private PrincipioActivoService principioActivoService;

    public GetAllPrincipiosActivosUseCase(PrincipioActivoService principioActivoService) {
        this.principioActivoService = principioActivoService;
    }

    public List<PrincipioActivo> execute() {
        return principioActivoService.getAllPrincipiosActivos();
    }
}
