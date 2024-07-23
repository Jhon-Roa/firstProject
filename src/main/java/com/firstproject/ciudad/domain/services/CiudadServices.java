package com.firstproject.ciudad.domain.services;

import java.util.List;

import com.firstproject.ciudad.domain.entity.Ciudad;

public interface CiudadServices {
    List<Ciudad> getAllCiudades();
    Ciudad getSpecifiedCiudad(int idCiudad);
}
