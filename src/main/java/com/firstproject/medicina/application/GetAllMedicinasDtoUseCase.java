package com.firstproject.medicina.application;

import java.util.List;

import com.firstproject.medicina.domain.entity.MedicinaDto;
import com.firstproject.medicina.domain.service.MedicinaService;

public class GetAllMedicinasDtoUseCase {
    private MedicinaService medicinaService;

    public GetAllMedicinasDtoUseCase(MedicinaService medicinaService) {
        this.medicinaService = medicinaService;
    }

    public List<MedicinaDto> execute() {
        return medicinaService.getAllMedicinasDto();
    }
}
