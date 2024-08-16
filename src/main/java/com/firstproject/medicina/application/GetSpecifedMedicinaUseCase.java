package com.firstproject.medicina.application;

import java.util.Optional;

import com.firstproject.medicina.domain.entity.Medicina;
import com.firstproject.medicina.domain.service.MedicinaService;

public class GetSpecifedMedicinaUseCase {
    private MedicinaService medicinaService;

    public GetSpecifedMedicinaUseCase(MedicinaService medicinaService) {
        this.medicinaService = medicinaService;
    }

    public Optional<Medicina> execute(int idMedicina) {
        return medicinaService.getEspecifiedMedicina(idMedicina);
    }
}
