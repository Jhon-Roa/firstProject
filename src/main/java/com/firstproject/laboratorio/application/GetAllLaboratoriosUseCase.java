package com.firstproject.laboratorio.application;

import java.util.List;

import com.firstproject.laboratorio.domain.entity.Laboratorio;
import com.firstproject.laboratorio.domain.service.LaboratorioService;

public class GetAllLaboratoriosUseCase {
    private LaboratorioService laboratorioService;

    public GetAllLaboratoriosUseCase(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    public List<Laboratorio> execute() {
        return laboratorioService.getAllLaboratorios();
    }
}
