package com.firstproject.principioActivo.application;

import com.firstproject.principioActivo.domain.entity.PrincipioActivo;
import com.firstproject.principioActivo.domain.service.PrincipioActivoService;

public class GetEspecifiedPrincipioActivo {
    PrincipioActivoService principioActivoService;

    public GetEspecifiedPrincipioActivo(PrincipioActivoService principioActivoService) {
        this.principioActivoService = principioActivoService;
    }

    public PrincipioActivo execute(int idPrincipioActivo) {
        return principioActivoService.getEspecifiedPrincipioActivo(idPrincipioActivo);
    } 
}
