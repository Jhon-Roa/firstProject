package com.firstproject.viaadministracion.application;

import java.util.List;

import com.firstproject.viaadministracion.domain.entity.ViaAdministracion;
import com.firstproject.viaadministracion.domain.services.ViaAdministracionServices;

public class GetAllViasAdministracionUseCase {
    private ViaAdministracionServices viaAdministracionServices;

    public GetAllViasAdministracionUseCase(ViaAdministracionServices viaAdministracionServices) {
        this.viaAdministracionServices = viaAdministracionServices;
    }

    public List<ViaAdministracion> execute() {
        return viaAdministracionServices.getAllViasAdministracion();
    }
}
