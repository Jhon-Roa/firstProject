package com.firstproject.principioActivo.application;

import java.util.Optional;

import com.firstproject.principioActivo.domain.entity.PrincipioActivo;
import com.firstproject.principioActivo.domain.service.PrincipioActivoService;

public class GetEspecifiedPrincipioActivo {
    PrincipioActivoService principioActivoService;

    public GetEspecifiedPrincipioActivo(PrincipioActivoService principioActivoService) {
        this.principioActivoService = principioActivoService;
    }

    public Optional<PrincipioActivo> execute(int idPrincipioActivo) {
        return principioActivoService.getEspecifiedPrincipioActivo(idPrincipioActivo);
    } 
}
