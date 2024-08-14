package com.firstproject.laboratorio.domain.service;

import java.util.List;

import com.firstproject.laboratorio.domain.entity.Laboratorio;
import com.firstproject.laboratorio.domain.entity.LaboratorioDto;

public interface LaboratorioService {
    List<LaboratorioDto> getAllLaboratorioDtos();
    List<Laboratorio> getAllLaboratorios();
    Laboratorio getSpecifiedLaboratorio(Laboratorio laboratorio);
    void borrarLaboratorio(int idLaboratorio);
    void crearLaboratorio(Laboratorio laboratorio);
}
