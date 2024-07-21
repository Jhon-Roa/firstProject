package com.firstproject.pais.application;

import java.util.List;

import com.firstproject.pais.domain.entity.Pais;
import com.firstproject.pais.domain.service.PaisServices;

public class GetAllPaisesUseCase {
    private PaisServices paisServices;

    public GetAllPaisesUseCase(PaisServices paisServices) {
        this.paisServices = paisServices;
    }

    public List<Pais> execute() {
        return paisServices.getAllPaises();
    }
}
