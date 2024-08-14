package com.firstproject.principioActivo.application;

import com.firstproject.principioActivo.domain.service.PrincipioActivoService;

public class CrearPrincipioActivoUseCase {
    private PrincipioActivoService principioActivoService;

    public CrearPrincipioActivoUseCase(PrincipioActivoService principioActivoService) {
        this.principioActivoService = principioActivoService;
    }

    public void execute(String nombre) {
        principioActivoService.crearPrincipioActivo(nombre);
    }
}
