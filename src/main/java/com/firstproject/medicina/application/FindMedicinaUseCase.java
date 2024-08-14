package com.firstproject.medicina.application;

import java.util.Optional;

import com.firstproject.medicina.domain.entity.MedicinaDto;
import com.firstproject.medicina.domain.service.MedicinaService;

public class FindMedicinaUseCase {
    private MedicinaService medicinaService;

    public FindMedicinaUseCase(MedicinaService medicinaService) {
        this.medicinaService = medicinaService;
    }

    public Optional<MedicinaDto> execute(int idMedicina) {
        return medicinaService.findMedicina(idMedicina);
    }
}
