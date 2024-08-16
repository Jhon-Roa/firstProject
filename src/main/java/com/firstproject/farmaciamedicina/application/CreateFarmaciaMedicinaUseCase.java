package com.firstproject.farmaciamedicina.application;

import com.firstproject.farmaciamedicina.domain.entity.FarmaciaMedicina;
import com.firstproject.farmaciamedicina.domain.service.FarmaciaMedicinaService;

public class CreateFarmaciaMedicinaUseCase {
    private FarmaciaMedicinaService farmaciaMedicinaService;

    public CreateFarmaciaMedicinaUseCase(FarmaciaMedicinaService farmaciaMedicinaService) {
        this.farmaciaMedicinaService = farmaciaMedicinaService;
    }

    public boolean execute(FarmaciaMedicina farmaciaMedicina) {
        return farmaciaMedicinaService.createFarmaciaMedicina(farmaciaMedicina);
    }
}
