package com.firstproject.medicina.application;

import java.util.List;

import com.firstproject.medicina.domain.entity.Medicina;
import com.firstproject.medicina.domain.service.MedicinaService;

public class GetAllMedicinasUseCase {
    private MedicinaService medicinaService;

    public GetAllMedicinasUseCase(MedicinaService medicinaService) {
        this.medicinaService = medicinaService;
    }

    public List<Medicina> execute() {
        return medicinaService.getAllMedicinas();
    }
}
