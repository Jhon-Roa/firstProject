package com.firstproject.laboratorio.application;

import java.util.List;

import com.firstproject.laboratorio.domain.entity.LaboratorioDto;
import com.firstproject.laboratorio.domain.service.LaboratorioService;

public class GetAllLaboratorioDtosUseCase {
    private LaboratorioService laboratorioService;

    public GetAllLaboratorioDtosUseCase(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    public List<LaboratorioDto> execute() {
        return laboratorioService.getAllLaboratorioDtos();
    }
}