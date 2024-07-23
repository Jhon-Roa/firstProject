package com.firstproject.ciudad.application;

import com.firstproject.ciudad.domain.entity.Ciudad;
import com.firstproject.ciudad.domain.services.CiudadServices;

public class GetSpecifiedCiudadUseCase {
    private CiudadServices ciudadServices;

    public GetSpecifiedCiudadUseCase(CiudadServices ciudadServices) {
        this.ciudadServices = ciudadServices;
    }
    
    public Ciudad execute(int idCiudad) {
        return ciudadServices.getSpecifiedCiudad(idCiudad);
    }
}
