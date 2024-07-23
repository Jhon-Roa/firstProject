package com.firstproject.pais.domain.service;

import java.util.List;

import com.firstproject.pais.domain.entity.Pais;

public interface PaisServices {
    List<Pais> getAllPaises();
    Pais getSpecifiedPais(int idPais);
}
