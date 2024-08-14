package com.firstproject.farmaciamedicina.domain.service;

import java.util.List;

import com.firstproject.farmaciamedicina.domain.entity.FarmaciaMedicina;
import com.firstproject.farmaciamedicina.domain.entity.FarmaciaMedicinaDto;

public interface FarmaciaMedicinaService {
    void createFarmaciaMedicina(FarmaciaMedicina farmaciaMedicina);
    List<FarmaciaMedicinaDto> getAllMedicinasFromFarmacia(int idFarmacia);
    void deleteMedicinaFromFarmacia(FarmaciaMedicina farmaciaMedicina);
}
