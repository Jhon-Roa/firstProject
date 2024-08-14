package com.firstproject.unidadmedida.application;

import com.firstproject.unidadmedida.domain.entity.UnidadMedida;
import com.firstproject.unidadmedida.domain.service.UnidadMedidaService;

public class GetEspecifiedUnidadMedidaUseCase {
    private UnidadMedidaService unidadMedidaService;

    public GetEspecifiedUnidadMedidaUseCase(UnidadMedidaService unidadMedidaService) {
        this.unidadMedidaService = unidadMedidaService;
    }

    public UnidadMedida execute(int idUnidadMedida) {
        return unidadMedidaService.getEspecifiedUnidadMedida(idUnidadMedida);
    }
}
