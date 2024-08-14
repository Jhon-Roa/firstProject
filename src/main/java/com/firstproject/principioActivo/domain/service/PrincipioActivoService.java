package com.firstproject.principioActivo.domain.service;

import java.util.List;

import com.firstproject.principioActivo.domain.entity.PrincipioActivo;

public interface PrincipioActivoService {
    List<PrincipioActivo> getAllPrincipiosActivos();
    void borrarPrincipioActivo(PrincipioActivo principioActivo);
    PrincipioActivo getEspecifiedPrincipioActivo(int idPrincipioActivo);
    void crearPrincipioActivo(String nombre);
}
