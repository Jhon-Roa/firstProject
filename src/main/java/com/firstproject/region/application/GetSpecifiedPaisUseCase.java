package com.firstproject.region.application;

import com.firstproject.pais.domain.entity.Pais;
import com.firstproject.pais.domain.service.PaisServices;

public class GetSpecifiedPaisUseCase {
    public PaisServices paisServices;

    public GetSpecifiedPaisUseCase(PaisServices paisServices) {
        this.paisServices = paisServices;
    }

    public Pais execute(int idPais) {
        return paisServices.getSpecifiedPais(idPais);
    }
}
