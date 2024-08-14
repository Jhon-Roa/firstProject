package com.firstproject.medicina.application;

import com.firstproject.medicina.domain.entity.Medicina;
import com.firstproject.medicina.domain.service.MedicinaService;

public class GetSpecifedMedicinaUseCase {
    private MedicinaService medicinaService;

    public GetSpecifedMedicinaUseCase(MedicinaService medicinaService) {
        this.medicinaService = medicinaService;
    }

    public Medicina execute(int idMedicina) {
        return medicinaService.getEspecifiedMedicina(idMedicina);
    }
}
