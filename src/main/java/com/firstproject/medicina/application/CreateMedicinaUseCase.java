package com.firstproject.medicina.application;

import com.firstproject.medicina.domain.entity.Medicina;
import com.firstproject.medicina.domain.service.MedicinaService;

public class CreateMedicinaUseCase {
    private MedicinaService medicinaService;

    public CreateMedicinaUseCase(MedicinaService medicinaService) {
        this.medicinaService = medicinaService;
    }

    public void execute (Medicina medicina) {
        medicinaService.creatMedicina(medicina);
    }
}
