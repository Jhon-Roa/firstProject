package com.firstproject.medicina.application;

import com.firstproject.medicina.domain.entity.Medicina;
import com.firstproject.medicina.domain.service.MedicinaService;

public class UpdateMedicinaUseCase {
    private MedicinaService medicinaService;

    public UpdateMedicinaUseCase(MedicinaService medicinaService) {
        this.medicinaService = medicinaService;
    }

    public void execute(Medicina medicina) {
        medicinaService.updateMedicina(medicina);
    }
}
