package com.firstproject.farmaciamedicina.application;

import com.firstproject.farmaciamedicina.domain.entity.FarmaciaMedicina;
import com.firstproject.farmaciamedicina.domain.service.FarmaciaMedicinaService;

public class DeleteMedicinaFromFarmaciaUseCase {
    private FarmaciaMedicinaService farmaciaMedicinaService;

    public DeleteMedicinaFromFarmaciaUseCase(FarmaciaMedicinaService farmaciaMedicinaService) {
        this.farmaciaMedicinaService = farmaciaMedicinaService;
    }

    public void execute(FarmaciaMedicina farmaciaMedicina) {
        farmaciaMedicinaService.deleteMedicinaFromFarmacia(farmaciaMedicina);
    }
}
