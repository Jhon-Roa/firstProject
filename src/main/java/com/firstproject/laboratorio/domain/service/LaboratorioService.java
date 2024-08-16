package com.firstproject.laboratorio.domain.service;

import java.util.List;
import java.util.Optional;

import com.firstproject.laboratorio.domain.entity.Laboratorio;
import com.firstproject.laboratorio.domain.entity.LaboratorioDto;

public interface LaboratorioService {
    List<LaboratorioDto> getAllLaboratorioDtos();
    List<Laboratorio> getAllLaboratorios();
    Optional<Laboratorio> getSpecifiedLaboratorio(int idLaboratorio);
    void borrarLaboratorio(int idLaboratorio);
    void crearLaboratorio(Laboratorio laboratorio);
}
