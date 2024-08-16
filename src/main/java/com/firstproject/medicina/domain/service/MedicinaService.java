package com.firstproject.medicina.domain.service;

import java.util.List;
import java.util.Optional;

import com.firstproject.medicina.domain.entity.Medicina;
import com.firstproject.medicina.domain.entity.MedicinaDto;

public interface MedicinaService {
    List<Medicina> getAllMedicinas();
    List<MedicinaDto> getAllMedicinasDto();
    Optional<Medicina> getEspecifiedMedicina(int idMedicina);
    Optional<MedicinaDto> findMedicina(int idMedicina);
    void creatMedicina(Medicina medicina);
    void borrarMedicina(int idMedicina);
    void updateMedicina(Medicina medicina);
}
