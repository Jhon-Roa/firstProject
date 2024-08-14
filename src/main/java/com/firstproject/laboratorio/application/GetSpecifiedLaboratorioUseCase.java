package com.firstproject.laboratorio.application;

import com.firstproject.laboratorio.domain.entity.Laboratorio;
import com.firstproject.laboratorio.domain.service.LaboratorioService;

public class GetSpecifiedLaboratorioUseCase {
    private LaboratorioService laboratorioService;

    public GetSpecifiedLaboratorioUseCase(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    public Laboratorio execute(Laboratorio laboratorio) {
        return laboratorioService.getSpecifiedLaboratorio(laboratorio);
    }
}
