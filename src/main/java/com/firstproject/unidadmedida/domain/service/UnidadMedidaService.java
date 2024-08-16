package com.firstproject.unidadmedida.domain.service;

import java.util.List;
import java.util.Optional;

import com.firstproject.unidadmedida.domain.entity.UnidadMedida;

public interface UnidadMedidaService {
    List<UnidadMedida> getAllUnidadesMedida();
    void borrarUnidadMedida(UnidadMedida unidadMedida);
    Optional<UnidadMedida> getEspecifiedUnidadMedida(int idUnidadMedida);
    void crearUnidadMedida(String nombre);
}
