package com.firstproject.laboratorio.application;

import com.firstproject.laboratorio.domain.entity.Laboratorio;
import com.firstproject.laboratorio.domain.service.LaboratorioService;

public class CrearLaboratorioUseCase {
    private LaboratorioService laboratorioService;

    public CrearLaboratorioUseCase(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    public void execute(Laboratorio laboratorio) {
        laboratorioService.crearLaboratorio(laboratorio);
    }
}
