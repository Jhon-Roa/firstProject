package com.firstproject.laboratorio.application;

import java.util.Optional;

import com.firstproject.laboratorio.domain.entity.Laboratorio;
import com.firstproject.laboratorio.domain.service.LaboratorioService;

public class GetSpecifiedLaboratorioUseCase {
    private LaboratorioService laboratorioService;

    public GetSpecifiedLaboratorioUseCase(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    public Optional<Laboratorio> execute(int idLaboratorio) {
        return laboratorioService.getSpecifiedLaboratorio(idLaboratorio);
    }
}
