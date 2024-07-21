package com.firstproject.ciudad.application;

import java.util.List;

import com.firstproject.ciudad.domain.entity.Ciudad;
import com.firstproject.ciudad.domain.services.CiudadServices;

public class GetAllCiudadesUseCase {
    private CiudadServices ciudadServices;

    public GetAllCiudadesUseCase(CiudadServices ciudadServices) {
        this.ciudadServices = ciudadServices;
    }

    public List<Ciudad> execute() {
        return ciudadServices.getAllCiudades();
    }
}
