package com.firstproject.unidadmedida.application;

import com.firstproject.unidadmedida.domain.service.UnidadMedidaService;

public class CrearUnidadMedidaUseCase {
    private UnidadMedidaService unidadMedidaService;

    public CrearUnidadMedidaUseCase(UnidadMedidaService unidadMedidaService) {
        this.unidadMedidaService = unidadMedidaService;
    }

    public void execute(String nombre) {
        unidadMedidaService.crearUnidadMedida(nombre);
    }
}
