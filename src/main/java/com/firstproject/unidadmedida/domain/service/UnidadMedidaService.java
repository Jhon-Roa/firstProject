package com.firstproject.unidadmedida.domain.service;

import java.util.List;

import com.firstproject.unidadmedida.domain.entity.UnidadMedida;

public interface UnidadMedidaService {
    List<UnidadMedida> getAllUnidadesMedida();
    void borrarUnidadMedida(UnidadMedida unidadMedida);
    UnidadMedida getEspecifiedUnidadMedida(int idUnidadMedida);
    void crearUnidadMedida(String nombre);
}
