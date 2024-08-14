package com.firstproject.laboratorio.application;

import com.firstproject.laboratorio.domain.service.LaboratorioService;

public class BorrarLaboratorioUseCase {
    LaboratorioService laboratorioService;

    public BorrarLaboratorioUseCase(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    public void execute(int idLaboratorio) {
        laboratorioService.borrarLaboratorio(idLaboratorio);
    }
}
