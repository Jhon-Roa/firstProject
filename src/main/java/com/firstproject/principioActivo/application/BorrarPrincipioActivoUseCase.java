package com.firstproject.principioActivo.application;

import com.firstproject.principioActivo.domain.entity.PrincipioActivo;
import com.firstproject.principioActivo.domain.service.PrincipioActivoService;

public class BorrarPrincipioActivoUseCase {
    private PrincipioActivoService principioActivoService;

    public BorrarPrincipioActivoUseCase(PrincipioActivoService principioActivoService) {
        this.principioActivoService = principioActivoService;
    }

    public void execute(PrincipioActivo principioActivo) {
        principioActivoService.borrarPrincipioActivo(principioActivo);
    }
}
