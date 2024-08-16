package com.firstproject.farmaciamedicina.domain.service;

import java.util.List;

import com.firstproject.farmaciamedicina.domain.entity.FarmaciaMedicina;
import com.firstproject.farmaciamedicina.domain.entity.FarmaciaMedicinaDto;

public interface FarmaciaMedicinaService {
    boolean createFarmaciaMedicina(FarmaciaMedicina farmaciaMedicina);
    List<FarmaciaMedicinaDto> getAllMedicinasFromFarmacia(int idFarmacia);
    boolean deleteMedicinaFromFarmacia(FarmaciaMedicina farmaciaMedicina);
}
