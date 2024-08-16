package com.firstproject.unidadmedida.application;

import java.util.Optional;

import com.firstproject.unidadmedida.domain.entity.UnidadMedida;
import com.firstproject.unidadmedida.domain.service.UnidadMedidaService;

public class GetEspecifiedUnidadMedidaUseCase {
    private UnidadMedidaService unidadMedidaService;

    public GetEspecifiedUnidadMedidaUseCase(UnidadMedidaService unidadMedidaService) {
        this.unidadMedidaService = unidadMedidaService;
    }

    public Optional<UnidadMedida> execute(int idUnidadMedida) {
        return unidadMedidaService.getEspecifiedUnidadMedida(idUnidadMedida);
    }
}
