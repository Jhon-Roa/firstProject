package com.firstproject.unidadmedida.application;

import java.util.List;

import com.firstproject.unidadmedida.domain.entity.UnidadMedida;
import com.firstproject.unidadmedida.domain.service.UnidadMedidaService;

public class GetAllUnidadesMedidaUseCase {
    UnidadMedidaService unidadMedidaService;

    public GetAllUnidadesMedidaUseCase(UnidadMedidaService unidadMedidaService) {
        this.unidadMedidaService = unidadMedidaService;
    }

    public List<UnidadMedida> execute() {
        return unidadMedidaService.getAllUnidadesMedida();
    }
}
