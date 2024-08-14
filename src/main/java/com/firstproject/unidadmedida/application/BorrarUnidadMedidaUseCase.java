package com.firstproject.unidadmedida.application;

import com.firstproject.unidadmedida.domain.entity.UnidadMedida;
import com.firstproject.unidadmedida.domain.service.UnidadMedidaService;

public class BorrarUnidadMedidaUseCase {
    private UnidadMedidaService unidadMedidaService;

    public BorrarUnidadMedidaUseCase(UnidadMedidaService unidadMedidaService) {
        this.unidadMedidaService = unidadMedidaService;
    }

    public void execute(UnidadMedida unidadMedida) {
        unidadMedidaService.borrarUnidadMedida(unidadMedida);
    }
}
