package com.firstproject.farmaciamedicina.application;

import java.util.List;

import com.firstproject.farmaciamedicina.domain.entity.FarmaciaMedicinaDto;
import com.firstproject.farmaciamedicina.domain.service.FarmaciaMedicinaService;

public class GetAllMedicinasFromFarmaciaUseCase {
    private FarmaciaMedicinaService farmaciaMedicinaService;

    public GetAllMedicinasFromFarmaciaUseCase(FarmaciaMedicinaService farmaciaMedicinaService) {
        this.farmaciaMedicinaService = farmaciaMedicinaService;
    }

    public List<FarmaciaMedicinaDto> execute(int idFarmacia) {
        return farmaciaMedicinaService.getAllMedicinasFromFarmacia(idFarmacia);
    }
}
